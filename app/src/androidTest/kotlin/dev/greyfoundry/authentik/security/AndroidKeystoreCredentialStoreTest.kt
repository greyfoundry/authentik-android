package dev.greyfoundry.authentik.security

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.greyfoundry.authentik.domain.model.InstanceId
import java.io.File
import java.security.KeyStore
import java.util.UUID
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidKeystoreCredentialStoreTest {
    private lateinit var context: Context
    private lateinit var storageDirectory: File
    private lateinit var keyAlias: String
    private lateinit var store: AndroidKeystoreCredentialStore

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        keyAlias = "authentik-credential-test-${UUID.randomUUID()}"
        storageDirectory = File(context.noBackupFilesDir, "credential-tests/${UUID.randomUUID()}")
        store = AndroidKeystoreCredentialStore(
            storageDirectory = storageDirectory,
            keyAlias = keyAlias,
        )
    }

    @After
    fun tearDown() {
        storageDirectory.deleteRecursively()
        val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        if (keyStore.containsAlias(keyAlias)) {
            keyStore.deleteEntry(keyAlias)
        }
    }

    @Test
    fun roundTripAndOverwrite() = runBlocking {
        val instanceId = InstanceId("55de417d-d468-4857-8bbc-037b06633c19")
        val firstCredential = "first credential".encodeToByteArray()

        store.put(instanceId, firstCredential)
        assertArrayEquals(firstCredential, store.get(instanceId))
        assertFalse(store.fileFor(instanceId).readBytes().containsSequence(firstCredential))

        store.put(instanceId, "replacement credential".encodeToByteArray())
        assertArrayEquals("replacement credential".encodeToByteArray(), store.get(instanceId))
    }

    @Test
    fun instancesRemainIsolated() = runBlocking {
        val firstId = InstanceId("328a1658-87ce-413e-9f73-fb242cbd97db")
        val secondId = InstanceId("02bdcb57-86ec-4777-81c0-bcad656eaed5")

        store.put(firstId, "first".encodeToByteArray())
        store.put(secondId, "second".encodeToByteArray())

        assertArrayEquals("first".encodeToByteArray(), store.get(firstId))
        assertArrayEquals("second".encodeToByteArray(), store.get(secondId))
    }

    @Test
    fun copiedEnvelopeCannotBeReadForAnotherInstance() = runBlocking {
        val firstId = InstanceId("084db27d-22c1-4fe3-af87-6942b6f05dc6")
        val secondId = InstanceId("be09c984-841d-4b74-85fd-c97bbc40f638")
        store.put(firstId, "credential".encodeToByteArray())

        val copiedEnvelope = store.fileFor(firstId).readBytes()
        secondId.value.encodeToByteArray().copyInto(
            copiedEnvelope,
            destinationOffset = AndroidKeystoreCredentialStore.INSTANCE_ID_OFFSET,
        )
        store.fileFor(secondId).writeBytes(copiedEnvelope)

        val error = assertThrows(CredentialStoreException::class.java) {
            runBlocking { store.get(secondId) }
        }
        assertTrue(error.reason == CredentialStoreFailure.UNREADABLE)
    }

    @Test
    fun removalIsIdempotent() = runBlocking {
        val instanceId = InstanceId("dd21a768-475d-4ec8-926a-ab266ef9a744")
        store.put(instanceId, "credential".encodeToByteArray())

        store.remove(instanceId)
        store.remove(instanceId)

        assertNull(store.get(instanceId))
        assertFalse(store.fileFor(instanceId).exists())
    }

    @Test
    fun productionStorageUsesNoBackupDirectory() {
        val productionStore = AndroidKeystoreCredentialStore(context)

        assertTrue(
            productionStore.storageDirectory.canonicalPath.startsWith(
                context.noBackupFilesDir.canonicalPath + File.separator,
            ),
        )
    }

    private fun ByteArray.containsSequence(sequence: ByteArray): Boolean =
        indices.any { start ->
            start + sequence.size <= size &&
                sequence.indices.all { offset -> this[start + offset] == sequence[offset] }
        }
}
