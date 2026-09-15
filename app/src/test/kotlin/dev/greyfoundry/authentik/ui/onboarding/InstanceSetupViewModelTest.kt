package dev.greyfoundry.authentik.ui.onboarding

import androidx.lifecycle.SavedStateHandle
import dev.greyfoundry.authentik.domain.model.AccessToken
import dev.greyfoundry.authentik.domain.model.AuthSessionState
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.ConnectedInstance
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.MalformedServerResponse
import dev.greyfoundry.authentik.domain.model.NetworkUnavailable
import dev.greyfoundry.authentik.domain.model.ServerProfile
import dev.greyfoundry.authentik.domain.model.TlsFailure
import dev.greyfoundry.authentik.domain.repository.AuthSessionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceConnectionRepository
import java.io.IOException
import javax.net.ssl.SSLException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class InstanceSetupViewModelTest {
    private lateinit var scope: CoroutineScope
    private lateinit var connectionRepository: FakeConnectionRepository
    private lateinit var authRepository: FakeAuthSessionRepository

    @Before
    fun setUp() {
        scope = CoroutineScope(SupervisorJob() + Dispatchers.Unconfined)
        connectionRepository = FakeConnectionRepository()
        authRepository = FakeAuthSessionRepository()
    }

    @After
    fun tearDown() {
        scope.cancel()
    }

    @Test
    fun `validates after blur or submit instead of while typing`() {
        val viewModel = viewModel()

        viewModel.onBaseUrlChanged("http://auth.example.com")
        assertNull(viewModel.uiState.value.baseUrlError)
        assertFalse(viewModel.uiState.value.canContinue)

        viewModel.onBaseUrlFocusChanged(hasFocus = false)
        assertNull(viewModel.uiState.value.baseUrlError)
        viewModel.onBaseUrlFocusChanged(hasFocus = true)
        viewModel.onBaseUrlFocusChanged(hasFocus = false)
        assertEquals(InstanceUrlError.HTTPS_REQUIRED, viewModel.uiState.value.baseUrlError)

        viewModel.onBaseUrlChanged("")
        viewModel.connect()
        assertEquals(InstanceUrlError.REQUIRED, viewModel.uiState.value.baseUrlError)

        viewModel.onBaseUrlChanged("https://")
        viewModel.onBaseUrlFocusChanged(hasFocus = false)
        assertEquals(InstanceUrlError.INVALID, viewModel.uiState.value.baseUrlError)
    }

    @Test
    fun `checks and normalizes a supported instance`() {
        connectionRepository.handler = { connected(CompatibilityLevel.SUPPORTED) }
        val viewModel = viewModel()

        viewModel.onBaseUrlChanged("https://AUTH.example.com")
        viewModel.connect()

        val ready = viewModel.uiState.value.connection as ConnectionState.Ready
        assertEquals("https://auth.example.com/", ready.connectedInstance.instance.baseUrl)
        assertEquals(CompatibilityLevel.SUPPORTED, ready.connectedInstance.server.compatibilityLevel)
        assertFalse(viewModel.uiState.value.canContinue)
        assertEquals(1, connectionRepository.calls)
    }

    @Test
    fun `allows a degraded instance with an explicit compatibility state`() {
        connectionRepository.handler = { connected(CompatibilityLevel.DEGRADED) }
        val viewModel = viewModel()

        viewModel.onBaseUrlChanged("https://auth.example.com")
        viewModel.connect()

        val ready = viewModel.uiState.value.connection as ConnectionState.Ready
        assertEquals(CompatibilityLevel.DEGRADED, ready.connectedInstance.server.compatibilityLevel)
    }

    @Test
    fun `blocks sign in for an unsupported instance`() {
        connectionRepository.handler = { connected(CompatibilityLevel.UNSUPPORTED) }
        val viewModel = viewModel()

        viewModel.onBaseUrlChanged("https://auth.example.com")
        viewModel.connect()
        viewModel.signIn()

        val failed = viewModel.uiState.value.connection as ConnectionState.Failed
        assertTrue(failed.error is InstanceConnectionError.Unsupported)
        assertEquals(0, authRepository.authorizeCalls)
    }

    @Test
    fun `maps TLS network and malformed response failures`() {
        listOf(
            TlsFailure(SSLException("test")) to InstanceConnectionError.Tls,
            NetworkUnavailable(IOException("test")) to InstanceConnectionError.Network,
            MalformedServerResponse() to InstanceConnectionError.MalformedResponse,
        ).forEach { (failure, expected) ->
            connectionRepository.handler = { throw failure }
            val viewModel = viewModel()
            viewModel.onBaseUrlChanged("https://auth.example.com")

            viewModel.connect()

            assertEquals(
                expected,
                (viewModel.uiState.value.connection as ConnectionState.Failed).error,
            )
        }
    }

    @Test
    fun `suppresses duplicate connection submissions`() = runBlocking {
        val started = CompletableDeferred<Unit>()
        val finish = CompletableDeferred<Unit>()
        connectionRepository.handler = {
            started.complete(Unit)
            finish.await()
            connected(CompatibilityLevel.SUPPORTED)
        }
        val viewModel = viewModel()
        viewModel.onBaseUrlChanged("https://auth.example.com")

        viewModel.connect()
        started.await()
        viewModel.connect()

        assertEquals(1, connectionRepository.calls)
        assertEquals(ConnectionState.Checking, viewModel.uiState.value.connection)
        finish.complete(Unit)
        assertTrue(viewModel.uiState.value.connection is ConnectionState.Ready)
    }

    @Test
    fun `restores the non-secret URL draft`() {
        val handle = SavedStateHandle(
            mapOf("instance_setup_base_url" to "https://auth.example.com"),
        )

        val viewModel = viewModel(handle)

        assertEquals("https://auth.example.com", viewModel.uiState.value.baseUrl)
        assertTrue(viewModel.uiState.value.canContinue)
    }

    @Test
    fun `launches browser authorization once for the verified instance`() = runBlocking {
        connectionRepository.handler = { connected(CompatibilityLevel.SUPPORTED) }
        val started = CompletableDeferred<Unit>()
        val finish = CompletableDeferred<Unit>()
        authRepository.authorizeHandler = {
            started.complete(Unit)
            finish.await()
        }
        val viewModel = viewModel()
        viewModel.onBaseUrlChanged("https://auth.example.com")
        viewModel.connect()

        viewModel.signIn()
        started.await()
        viewModel.signIn()

        assertEquals(1, authRepository.authorizeCalls)
        finish.complete(Unit)
        assertEquals(AuthorizationState.WaitingForBrowser, viewModel.uiState.value.authorization)
    }

    private fun viewModel(
        handle: SavedStateHandle = SavedStateHandle(),
    ): InstanceSetupViewModel = InstanceSetupViewModel(
        savedStateHandle = handle,
        connectionRepository = connectionRepository,
        authSessionRepository = authRepository,
        workScope = scope,
    )

    private fun connected(level: CompatibilityLevel): ConnectedInstance = ConnectedInstance(
        instance =
            InstanceProfile(
                id = InstanceId("41c1c94e-81ad-4b1d-808e-37acd9a30790"),
                baseUrl = "https://auth.example.com/",
                displayName = "auth.example.com",
            ),
        server =
            ServerProfile(
                versionCurrent = "2026.8.1",
                versionLatest = "2026.8.1",
                buildHash = "build",
                outdated = false,
                outpostOutdated = false,
                compatibilityLevel = level,
            ),
    )
}

private class FakeConnectionRepository : InstanceConnectionRepository {
    var calls = 0
    var handler: suspend (String) -> ConnectedInstance = { error("No connection result configured") }

    override suspend fun connect(baseUrl: String): ConnectedInstance {
        calls += 1
        return handler(baseUrl)
    }
}

private class FakeAuthSessionRepository : AuthSessionRepository {
    private val mutableSession = MutableStateFlow<AuthSessionState>(
        AuthSessionState.SignedOut(instanceId = null),
    )
    override val session: StateFlow<AuthSessionState> = mutableSession
    var authorizeCalls = 0
    var authorizeHandler: suspend (InstanceId) -> Unit = {}

    override suspend fun authorize(instanceId: InstanceId) {
        authorizeCalls += 1
        mutableSession.value = AuthSessionState.Authorizing(instanceId)
        authorizeHandler(instanceId)
    }

    override suspend fun logout(instanceId: InstanceId, revokeRemote: Boolean) = Unit

    override suspend fun accessToken(instanceId: InstanceId): AccessToken = error("Not used")
}
