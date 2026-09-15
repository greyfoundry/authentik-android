package dev.greyfoundry.authentik.ui.navigation

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import dev.greyfoundry.authentik.AuthentikApplication
import dev.greyfoundry.authentik.MainActivity
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class AppNavigationRestorationTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun selectedTopLevelDestinationSurvivesActivityRecreation() {
        val repository = (composeRule.activity.application as AuthentikApplication).instanceRepository
        val profile = runBlocking {
            repository.getByBaseUrl(TEST_INSTANCE_URL)
                ?: repository.add(InstanceDraft(TEST_INSTANCE_URL, "Navigation test"))
        }
        runBlocking { repository.setActive(profile.id) }
        composeRule.waitUntil(timeoutMillis = 5_000) {
            composeRule.onAllNodes(hasText("Directory") and TabRole)
                .fetchSemanticsNodes().isNotEmpty()
        }

        try {
            composeRule
                .onNode(hasText("Directory") and TabRole)
                .performClick()
                .assertIsSelected()

            composeRule.activityRule.scenario.recreate()
            composeRule.waitForIdle()

            composeRule.onNode(hasText("Directory") and TabRole).assertIsSelected()
        } finally {
            runBlocking { repository.remove(profile.id) }
        }
    }

    private companion object {
        val TabRole =
            SemanticsMatcher.expectValue(
                SemanticsProperties.Role,
                Role.Tab,
            )
        const val TEST_INSTANCE_URL = "https://navigation-test.example.com/"
    }
}
