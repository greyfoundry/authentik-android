package dev.greyfoundry.authentik.security

import dev.greyfoundry.authentik.domain.model.InstanceId

interface SecureCredentialStore {
    suspend fun put(instanceId: InstanceId, value: ByteArray)

    suspend fun get(instanceId: InstanceId): ByteArray?

    suspend fun remove(instanceId: InstanceId)
}

enum class CredentialStoreFailure {
    UNAVAILABLE,
    UNREADABLE,
}

class CredentialStoreException(
    val reason: CredentialStoreFailure,
    cause: Throwable? = null,
) : Exception(
    when (reason) {
        CredentialStoreFailure.UNAVAILABLE -> "Secure credential storage is unavailable."
        CredentialStoreFailure.UNREADABLE -> "Stored credentials could not be read."
    },
    cause,
)
