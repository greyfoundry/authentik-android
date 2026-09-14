package dev.greyfoundry.authentik.ui.navigation

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import dev.greyfoundry.authentik.MainActivity
import org.junit.Rule
import org.junit.Test

class AppNavigationRestorationTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun selectedTopLevelDestinationSurvivesActivityRecreation() {
        composeRule
            .onNode(hasText("Directory") and TabRole)
            .performClick()
            .assertIsSelected()

        composeRule.activityRule.scenario.recreate()
        composeRule.waitForIdle()

        composeRule.onNode(hasText("Directory") and TabRole).assertIsSelected()
    }

    private companion object {
        val TabRole =
            SemanticsMatcher.expectValue(
                SemanticsProperties.Role,
                Role.Tab,
            )
    }
}
