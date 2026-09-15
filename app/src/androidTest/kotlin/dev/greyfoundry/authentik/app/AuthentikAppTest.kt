package dev.greyfoundry.authentik.app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import dev.greyfoundry.authentik.domain.model.AccessToken
import dev.greyfoundry.authentik.domain.model.AuthSessionState
import dev.greyfoundry.authentik.domain.model.ConnectedInstance
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.repository.AuthSessionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceConnectionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Rule
import org.junit.Test

class AuthentikAppTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun showsOnboardingUntilAuthorizationActivatesAnInstance() {
        val container = TestAppContainer()
        composeRule.setContent { AuthentikApp(container) }

        composeRule.onNodeWithText("Connect an authentik instance").assertIsDisplayed()

        composeRule.runOnIdle {
            container.instances.activate(profile())
        }

        composeRule.onNode(hasTestTag("home")).assertIsDisplayed()
    }

    private fun profile() = InstanceProfile(
        id = InstanceId("f1f8d661-8589-4596-bb08-51746d4df0f6"),
        baseUrl = "https://auth.example.com/",
        displayName = "auth.example.com",
    )
}

private class TestAppContainer : AppContainer {
    val instances = TestInstanceRepository()
    override val instanceRepository: InstanceRepository = instances
    override val instanceConnectionRepository: InstanceConnectionRepository =
        object : InstanceConnectionRepository {
            override suspend fun connect(baseUrl: String): ConnectedInstance = error("Not used")
        }
    override val authSessionRepository: AuthSessionRepository = TestAuthSessionRepository()
}

private class TestInstanceRepository : InstanceRepository {
    private val mutableActive = MutableStateFlow<InstanceProfile?>(null)
    private val mutableInstances = MutableStateFlow<List<InstanceProfile>>(emptyList())
    override val activeInstance: StateFlow<InstanceProfile?> = mutableActive
    override val instances: StateFlow<List<InstanceProfile>> = mutableInstances

    fun activate(profile: InstanceProfile) {
        mutableInstances.value = listOf(profile)
        mutableActive.value = profile
    }

    override suspend fun get(instanceId: InstanceId): InstanceProfile? =
        mutableInstances.value.firstOrNull { it.id == instanceId }

    override suspend fun getByBaseUrl(baseUrl: String): InstanceProfile? =
        mutableInstances.value.firstOrNull { it.baseUrl == baseUrl }

    override suspend fun add(draft: InstanceDraft): InstanceProfile = error("Not used")
    override suspend fun update(profile: InstanceProfile) = error("Not used")
    override suspend fun remove(instanceId: InstanceId) = error("Not used")
    override suspend fun setActive(instanceId: InstanceId) = error("Not used")
}

private class TestAuthSessionRepository : AuthSessionRepository {
    override val session: StateFlow<AuthSessionState> = MutableStateFlow(
        AuthSessionState.SignedOut(instanceId = null),
    )

    override suspend fun authorize(instanceId: InstanceId) = error("Not used")
    override suspend fun logout(instanceId: InstanceId, revokeRemote: Boolean) = error("Not used")
    override suspend fun accessToken(instanceId: InstanceId): AccessToken = error("Not used")
}
