package dev.greyfoundry.authentik.auth

import android.content.Intent
import dev.greyfoundry.authentik.domain.model.AuthFailure
import dev.greyfoundry.authentik.domain.model.AuthSessionException
import dev.greyfoundry.authentik.domain.model.AuthSessionState
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.RemoteRevocation
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import dev.greyfoundry.authentik.security.SecureCredentialStore
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AppAuthSessionRepositoryTest {
    private val profile = InstanceProfile(
        id = InstanceId("cc3e8db7-d662-4e3e-99e8-8b054ce2f80c"),
        baseUrl = "https://auth.example.com/",
        displayName = "Example",
    )
    private lateinit var scope: CoroutineScope
    private lateinit var store: FakeCredentialStore
    private lateinit var oidcClient: FakeOidcClient
    private lateinit var repository: AppAuthSessionRepository

    @Before
    fun setUp() {
        scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        store = FakeCredentialStore()
        oidcClient = FakeOidcClient(store)
        repository = AppAuthSessionRepository(
            instanceRepository = FakeInstanceRepository(profile),
            credentialStore = store,
            oidcClient = oidcClient,
            applicationScope = scope,
        )
    }

    @After
    fun tearDown() {
        scope.cancel()
    }

    @Test
    fun `concurrent token requests share one refresh and persist the result`() = runBlocking {
        store.put(
            profile.id,
            AuthStateCodec.encode(profile, "https://auth.example.com/", "old-state"),
        )

        val tokens = coroutineScope {
            List(8) { async { repository.accessToken(profile.id) } }.awaitAll()
        }

        assertEquals(1, oidcClient.refreshCount.get())
        assertTrue(tokens.all { it.bearerValue() == "access-token" })
        assertTrue(tokens.all { it.toString() == "[redacted]" })
        val persisted = AuthStateCodec.decode(profile, requireNotNull(store.get(profile.id)))
        assertEquals("new-state", persisted.authStateJson)
        assertEquals(AuthSessionState.Authorized(profile.id), repository.session.value)
    }

    @Test
    fun `missing credentials produce stable signed out failure`() {
        val error = assertThrows(AuthSessionException::class.java) {
            runBlocking { repository.accessToken(profile.id) }
        }

        assertEquals(AuthFailure.SIGNED_OUT, error.reason)
        assertEquals(
            AuthSessionState.Failed(profile.id, AuthFailure.SIGNED_OUT),
            repository.session.value,
        )
    }

    @Test
    fun `local logout completes before failed remote revocation`() = runBlocking {
        store.put(
            profile.id,
            AuthStateCodec.encode(profile, "https://auth.example.com/", "old-state"),
        )
        oidcClient.failRevocation = true

        repository.logout(profile.id, revokeRemote = true)

        assertNull(store.get(profile.id))
        assertTrue(oidcClient.credentialsWereRemovedBeforeRevocation)
        assertEquals(
            AuthSessionState.SignedOut(profile.id, RemoteRevocation.FAILED),
            repository.session.value,
        )
    }

    @Test
    fun `logout cannot be undone by an in flight refresh`() = runBlocking {
        store.put(
            profile.id,
            AuthStateCodec.encode(profile, "https://auth.example.com/", "old-state"),
        )
        oidcClient.refreshDelayMillis = 500
        val refresh = async { runCatching { repository.accessToken(profile.id) } }
        while (oidcClient.refreshCount.get() == 0) {
            delay(10)
        }

        repository.logout(profile.id, revokeRemote = false)

        assertTrue(refresh.await().isFailure)
        assertNull(store.get(profile.id))
        assertEquals(AuthSessionState.SignedOut(profile.id), repository.session.value)
    }
}

private class FakeInstanceRepository(
    private val profile: InstanceProfile,
) : InstanceRepository {
    override val activeInstance: StateFlow<InstanceProfile?> = MutableStateFlow(profile)
    override val instances: StateFlow<List<InstanceProfile>> = MutableStateFlow(listOf(profile))

    override suspend fun get(instanceId: InstanceId): InstanceProfile? =
        profile.takeIf { it.id == instanceId }

    override suspend fun add(draft: InstanceDraft): InstanceProfile = error("Not used")
    override suspend fun update(profile: InstanceProfile): Unit = error("Not used")
    override suspend fun remove(instanceId: InstanceId): Unit = error("Not used")
    override suspend fun setActive(instanceId: InstanceId): Unit = error("Not used")
}

private class FakeCredentialStore : SecureCredentialStore {
    private val values = mutableMapOf<InstanceId, ByteArray>()

    override suspend fun put(instanceId: InstanceId, value: ByteArray) {
        synchronized(values) { values[instanceId] = value.copyOf() }
    }

    override suspend fun get(instanceId: InstanceId): ByteArray? =
        synchronized(values) { values[instanceId]?.copyOf() }

    override suspend fun remove(instanceId: InstanceId) {
        synchronized(values) { values.remove(instanceId) }
    }
}

private class FakeOidcClient(
    private val store: FakeCredentialStore,
) : OidcClient {
    val refreshCount = AtomicInteger()
    var failRevocation = false
    var refreshDelayMillis = 100L
    var credentialsWereRemovedBeforeRevocation = false

    override suspend fun launchAuthorization(profile: InstanceProfile, instanceId: InstanceId) = Unit

    override suspend fun exchangeAuthorizationResponse(
        profile: InstanceProfile,
        responseIntent: Intent,
    ): PersistedOidcSession = error("Not used")

    override suspend fun freshAccessToken(
        profile: InstanceProfile,
        authStateJson: String,
    ): FreshOidcToken {
        refreshCount.incrementAndGet()
        delay(refreshDelayMillis)
        return FreshOidcToken("access-token", "new-state")
    }

    override suspend fun revoke(
        profile: InstanceProfile,
        authStateJson: String,
    ): RemoteRevocation {
        credentialsWereRemovedBeforeRevocation = store.get(profile.id) == null
        if (failRevocation) error("Expected test failure")
        return RemoteRevocation.COMPLETED
    }
}
