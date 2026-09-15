package dev.greyfoundry.authentik.auth

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.greyfoundry.authentik.completeAuthorizationCallback
import dev.greyfoundry.authentik.domain.model.AuthFailure
import dev.greyfoundry.authentik.domain.model.AuthSessionState
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.RemoteRevocation
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import dev.greyfoundry.authentik.security.SecureCredentialStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppAuthSessionCallbackTest {
    @Test
    fun successfulCallbackBindsAndPersistsAppAuthState() = runBlocking {
        val profile = InstanceProfile(
            id = InstanceId("313984d4-8244-475f-8c9d-247fb5893626"),
            baseUrl = "https://auth.example.com/",
            displayName = "Example",
        )
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        val store = CallbackCredentialStore()
        val instances = CallbackInstanceRepository(profile)
        val repository = AppAuthSessionRepository(
            instanceRepository = instances,
            credentialStore = store,
            oidcClient = CallbackOidcClient(),
            applicationScope = scope,
        )

        try {
            completeAuthorizationCallback(repository, instances, profile.id, Intent())

            val encoded = store.get(profile.id)
            assertNotNull(encoded)
            val decoded = AuthStateCodec.decode(profile, requireNotNull(encoded))
            assertEquals("https://auth.example.com/", decoded.issuer)
            assertEquals("serialized-appauth-state", decoded.authStateJson)
            assertEquals(AuthSessionState.Authorized(profile.id), repository.session.value)
            assertEquals(profile, instances.activeInstance.value)
        } finally {
            scope.cancel()
        }
    }

    @Test
    fun failedCallbackDoesNotActivateInstance() = runBlocking {
        val profile = InstanceProfile(
            id = InstanceId("313984d4-8244-475f-8c9d-247fb5893626"),
            baseUrl = "https://auth.example.com/",
            displayName = "Example",
        )
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        val instances = CallbackInstanceRepository(profile)
        val repository = AppAuthSessionRepository(
            instanceRepository = instances,
            credentialStore = CallbackCredentialStore(),
            oidcClient = FailedCallbackOidcClient(),
            applicationScope = scope,
        )

        try {
            runCatching {
                completeAuthorizationCallback(repository, instances, profile.id, Intent())
            }

            assertEquals(null, instances.activeInstance.value)
            assertEquals(
                AuthSessionState.Failed(profile.id, AuthFailure.AUTHORIZATION_FAILED),
                repository.session.value,
            )
        } finally {
            scope.cancel()
        }
    }
}

private class CallbackInstanceRepository(
    private val profile: InstanceProfile,
) : InstanceRepository {
    private val mutableActiveInstance = MutableStateFlow<InstanceProfile?>(null)
    override val activeInstance: StateFlow<InstanceProfile?> = mutableActiveInstance
    override val instances: StateFlow<List<InstanceProfile>> = MutableStateFlow(listOf(profile))
    override suspend fun get(instanceId: InstanceId): InstanceProfile? = profile
    override suspend fun getByBaseUrl(baseUrl: String): InstanceProfile? =
        profile.takeIf { it.baseUrl == baseUrl }
    override suspend fun add(draft: InstanceDraft): InstanceProfile = error("Not used")
    override suspend fun update(profile: InstanceProfile): Unit = error("Not used")
    override suspend fun remove(instanceId: InstanceId): Unit = error("Not used")
    override suspend fun setActive(instanceId: InstanceId) {
        mutableActiveInstance.value = profile.takeIf { it.id == instanceId }
    }
}

private class CallbackCredentialStore : SecureCredentialStore {
    private val values = mutableMapOf<InstanceId, ByteArray>()
    override suspend fun put(instanceId: InstanceId, value: ByteArray) {
        values[instanceId] = value.copyOf()
    }
    override suspend fun get(instanceId: InstanceId): ByteArray? = values[instanceId]?.copyOf()
    override suspend fun remove(instanceId: InstanceId) {
        values.remove(instanceId)
    }
}

private class CallbackOidcClient : OidcClient {
    override suspend fun launchAuthorization(profile: InstanceProfile, instanceId: InstanceId) = Unit
    override suspend fun exchangeAuthorizationResponse(
        profile: InstanceProfile,
        responseIntent: Intent,
    ) = PersistedOidcSession(
        issuer = "https://auth.example.com/",
        authStateJson = "serialized-appauth-state",
    )
    override suspend fun freshAccessToken(
        profile: InstanceProfile,
        authStateJson: String,
    ) = error("Not used")
    override suspend fun revoke(
        profile: InstanceProfile,
        authStateJson: String,
    ) = RemoteRevocation.COMPLETED
}

private class FailedCallbackOidcClient : OidcClient {
    override suspend fun launchAuthorization(profile: InstanceProfile, instanceId: InstanceId) = Unit

    override suspend fun exchangeAuthorizationResponse(
        profile: InstanceProfile,
        responseIntent: Intent,
    ): PersistedOidcSession = throw OidcClientException(AuthFailure.AUTHORIZATION_FAILED)

    override suspend fun freshAccessToken(
        profile: InstanceProfile,
        authStateJson: String,
    ) = error("Not used")

    override suspend fun revoke(
        profile: InstanceProfile,
        authStateJson: String,
    ) = RemoteRevocation.COMPLETED
}
