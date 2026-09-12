package dev.greyfoundry.authentik.security

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import dev.greyfoundry.authentik.domain.model.InstanceId
import java.io.File
import java.io.FileOutputStream
import java.nio.ByteBuffer
import java.nio.file.AtomicMoveNotSupportedException
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.security.KeyStore
import javax.crypto.AEADBadTagException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

class AndroidKeystoreCredentialStore internal constructor(
    internal val storageDirectory: File,
    private val keyAlias: String,
) : SecureCredentialStore {
    constructor(context: Context) : this(
        storageDirectory = File(context.applicationContext.noBackupFilesDir, STORAGE_DIRECTORY),
        keyAlias = DEFAULT_KEY_ALIAS,
    )

    private val mutex = Mutex()

    override suspend fun put(instanceId: InstanceId, value: ByteArray) = withContext(Dispatchers.IO) {
        mutex.withLock {
            try {
                require(value.size <= MAX_PLAINTEXT_BYTES) {
                    "Credential value exceeds the supported size."
                }
                ensureStorageDirectory()
                val envelope = encrypt(instanceId, value)
                writeAtomically(fileFor(instanceId), envelope)
            } catch (error: CancellationException) {
                throw error
            } catch (error: CredentialStoreException) {
                throw error
            } catch (error: Exception) {
                throw CredentialStoreException(CredentialStoreFailure.UNAVAILABLE, error)
            }
        }
    }

    override suspend fun get(instanceId: InstanceId): ByteArray? = withContext(Dispatchers.IO) {
        mutex.withLock {
            val file = fileFor(instanceId)
            if (!file.exists()) {
                return@withLock null
            }

            val envelope = try {
                file.readBytes()
            } catch (error: Exception) {
                throw CredentialStoreException(CredentialStoreFailure.UNAVAILABLE, error)
            }

            try {
                decrypt(instanceId, envelope)
            } catch (error: CancellationException) {
                throw error
            } catch (error: CredentialEnvelopeException) {
                throw CredentialStoreException(CredentialStoreFailure.UNREADABLE, error)
            } catch (error: AEADBadTagException) {
                throw CredentialStoreException(CredentialStoreFailure.UNREADABLE, error)
            } catch (error: CredentialStoreException) {
                throw error
            } catch (error: Exception) {
                throw CredentialStoreException(CredentialStoreFailure.UNAVAILABLE, error)
            }
        }
    }

    override suspend fun remove(instanceId: InstanceId): Unit = withContext(Dispatchers.IO) {
        mutex.withLock {
            try {
                val credentialPath = fileFor(instanceId).toPath()
                if (Files.exists(credentialPath)) {
                    Files.delete(credentialPath)
                }
            } catch (error: CancellationException) {
                throw error
            } catch (error: Exception) {
                throw CredentialStoreException(CredentialStoreFailure.UNAVAILABLE, error)
            }
        }
    }

    internal fun fileFor(instanceId: InstanceId): File =
        File(storageDirectory, "${instanceId.value}$FILE_SUFFIX")

    private fun encrypt(instanceId: InstanceId, value: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, getOrCreateKey())
        val iv = cipher.iv
        val ciphertextSize = cipher.getOutputSize(value.size)
        val authenticatedHeader = createHeader(instanceId, iv.size, ciphertextSize)
        cipher.updateAAD(authenticatedHeader)
        val ciphertext = cipher.doFinal(value)
        check(ciphertext.size == ciphertextSize)

        return ByteBuffer.allocate(authenticatedHeader.size + iv.size + ciphertext.size)
            .put(authenticatedHeader)
            .put(iv)
            .put(ciphertext)
            .array()
    }

    private fun decrypt(instanceId: InstanceId, envelope: ByteArray): ByteArray {
        if (envelope.size !in MIN_ENVELOPE_BYTES..MAX_ENVELOPE_BYTES) {
            throw CredentialEnvelopeException()
        }

        val buffer = ByteBuffer.wrap(envelope)
        if (buffer.int != MAGIC || buffer.get() != FORMAT_VERSION) {
            throw CredentialEnvelopeException()
        }

        val instanceIdSize = buffer.short.toInt() and UNSIGNED_SHORT_MASK
        if (instanceIdSize !in 1..MAX_INSTANCE_ID_BYTES || buffer.remaining() < instanceIdSize + LENGTH_FIELDS_BYTES) {
            throw CredentialEnvelopeException()
        }

        val storedInstanceId = ByteArray(instanceIdSize).also(buffer::get).decodeToString()
        val ivSize = buffer.get().toInt() and UNSIGNED_BYTE_MASK
        val ciphertextSize = buffer.int
        if (
            storedInstanceId != instanceId.value ||
            ivSize !in 1..MAX_IV_BYTES ||
            ciphertextSize < GCM_TAG_BYTES ||
            ciphertextSize > MAX_CIPHERTEXT_BYTES ||
            buffer.remaining() != ivSize + ciphertextSize
        ) {
            throw CredentialEnvelopeException()
        }

        val authenticatedHeader = envelope.copyOfRange(0, buffer.position())
        val iv = ByteArray(ivSize).also(buffer::get)
        val ciphertext = ByteArray(ciphertextSize).also(buffer::get)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, getOrCreateKey(), GCMParameterSpec(GCM_TAG_BITS, iv))
        cipher.updateAAD(authenticatedHeader)
        return cipher.doFinal(ciphertext)
    }

    private fun createHeader(
        instanceId: InstanceId,
        ivSize: Int,
        ciphertextSize: Int,
    ): ByteArray {
        val instanceIdBytes = instanceId.value.encodeToByteArray()
        return ByteBuffer.allocate(FIXED_HEADER_BYTES + instanceIdBytes.size)
            .putInt(MAGIC)
            .put(FORMAT_VERSION)
            .putShort(instanceIdBytes.size.toShort())
            .put(instanceIdBytes)
            .put(ivSize.toByte())
            .putInt(ciphertextSize)
            .array()
    }

    private fun getOrCreateKey(): SecretKey {
        val keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER).apply { load(null) }
        val existingKey = keyStore.getKey(keyAlias, null)
        if (existingKey != null) {
            return existingKey as? SecretKey ?: throw CredentialStoreException(
                CredentialStoreFailure.UNAVAILABLE,
            )
        }

        val specification = KeyGenParameterSpec.Builder(
            keyAlias,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT,
        )
            .setKeySize(KEY_SIZE_BITS)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setRandomizedEncryptionRequired(true)
            .build()

        return KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, KEYSTORE_PROVIDER).run {
            init(specification)
            generateKey()
        }
    }

    private fun ensureStorageDirectory() {
        if (!storageDirectory.exists() && !storageDirectory.mkdirs()) {
            throw CredentialStoreException(CredentialStoreFailure.UNAVAILABLE)
        }
        if (!storageDirectory.isDirectory) {
            throw CredentialStoreException(CredentialStoreFailure.UNAVAILABLE)
        }
    }

    private fun writeAtomically(destination: File, contents: ByteArray) {
        val temporary = Files.createTempFile(
            storageDirectory.toPath(),
            ".${destination.name}.",
            ".tmp",
        )
        try {
            FileOutputStream(temporary.toFile()).use { output ->
                output.write(contents)
                output.fd.sync()
            }
            try {
                Files.move(
                    temporary,
                    destination.toPath(),
                    StandardCopyOption.ATOMIC_MOVE,
                    StandardCopyOption.REPLACE_EXISTING,
                )
            } catch (_: AtomicMoveNotSupportedException) {
                Files.move(
                    temporary,
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING,
                )
            }
        } finally {
            Files.deleteIfExists(temporary)
        }
    }

    private class CredentialEnvelopeException : Exception()

    internal companion object {
        const val INSTANCE_ID_OFFSET = 7

        private const val STORAGE_DIRECTORY = "credentials"
        private const val DEFAULT_KEY_ALIAS = "dev.greyfoundry.authentik.credentials.v1"
        private const val FILE_SUFFIX = ".bin"
        private const val KEYSTORE_PROVIDER = "AndroidKeyStore"
        private const val TRANSFORMATION = "AES/GCM/NoPadding"
        private const val KEY_SIZE_BITS = 256
        private const val GCM_TAG_BITS = 128
        private const val GCM_TAG_BYTES = GCM_TAG_BITS / 8
        private const val MAGIC = 0x414B4352
        private const val FORMAT_VERSION: Byte = 1
        private const val FIXED_HEADER_BYTES = 12
        private const val LENGTH_FIELDS_BYTES = 5
        private const val MAX_INSTANCE_ID_BYTES = 128
        private const val MAX_IV_BYTES = 32
        private const val MAX_PLAINTEXT_BYTES = 1024 * 1024
        private const val MAX_CIPHERTEXT_BYTES = MAX_PLAINTEXT_BYTES + GCM_TAG_BYTES
        private const val MIN_ENVELOPE_BYTES = FIXED_HEADER_BYTES + 1 + 1 + GCM_TAG_BYTES
        private const val MAX_ENVELOPE_BYTES =
            FIXED_HEADER_BYTES + MAX_INSTANCE_ID_BYTES + MAX_IV_BYTES + MAX_CIPHERTEXT_BYTES
        private const val UNSIGNED_BYTE_MASK = 0xff
        private const val UNSIGNED_SHORT_MASK = 0xffff
    }
}
