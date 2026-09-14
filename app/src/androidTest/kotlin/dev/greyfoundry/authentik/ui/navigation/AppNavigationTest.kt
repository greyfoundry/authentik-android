package dev.greyfoundry.authentik.ui.navigation

import androidx.compose.material3.adaptive.layout.PaneScaffoldDirective
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.Density
import dev.greyfoundry.authentik.ui.theme.AuthentikTheme
import org.junit.Rule
import org.junit.Test

class AppNavigationTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun compactShell_showsFiveLabeledDestinationsAndSelection() {
        composeRule.setContent {
            AuthentikTheme {
                AppNavigation(
                    navigationSuiteTypeOverride = NavigationSuiteType.NavigationBar,
                    paneDirectiveOverride = singlePaneDirective,
                )
            }
        }

        composeRule.onNodeWithTag("navigation-bar").assertIsDisplayed()
        listOf("Home", "Directory", "Access", "Activity", "More").forEach { label ->
            composeRule.onNode(hasText(label) and TabRole).assertIsDisplayed()
        }
        composeRule.onNode(hasText("Home") and TabRole).assertIsSelected()

        composeRule
            .onNode(hasText("Directory") and TabRole)
            .performClick()
            .assertIsSelected()
        composeRule.onNodeWithTag("directory-list").assertIsDisplayed()
        composeRule.onAllNodesWithTag("user-detail").assertCountEquals(0)
    }

    @Test
    fun expandedShell_usesRailAndDisplaysListWithDetail() {
        composeRule.setContent {
            AuthentikTheme {
                AppNavigation(
                    navigationSuiteTypeOverride = NavigationSuiteType.NavigationRail,
                    paneDirectiveOverride = twoPaneDirective,
                    initialTopLevel = AppRoute.Directory,
                    initialDetail = AppRoute.UserDetail("user-1"),
                )
            }
        }

        composeRule.onNodeWithTag("navigation-rail").assertIsDisplayed()
        composeRule.onNode(hasText("Directory") and TabRole).assertIsSelected()
        composeRule.onNodeWithTag("directory-list").assertIsDisplayed()
        composeRule.onNodeWithTag("user-detail").assertIsDisplayed()
        composeRule.onAllNodesWithText("Back").assertCountEquals(0)
    }

    @Test
    fun compactDetail_displaysOnlyTheCurrentPane() {
        composeRule.setContent {
            AuthentikTheme {
                AppNavigation(
                    navigationSuiteTypeOverride = NavigationSuiteType.NavigationBar,
                    paneDirectiveOverride = singlePaneDirective,
                    initialTopLevel = AppRoute.Directory,
                    initialDetail = AppRoute.UserDetail("user-1"),
                )
            }
        }

        composeRule.onAllNodesWithTag("directory-list").assertCountEquals(0)
        composeRule.onNodeWithTag("user-detail").assertIsDisplayed()
    }

    @Test
    fun compactNavigation_remainsLabeledAtTwoHundredPercentFontScale() {
        composeRule.setContent {
            val density = LocalDensity.current
            CompositionLocalProvider(
                LocalDensity provides Density(density.density, fontScale = 2f),
            ) {
                AuthentikTheme {
                    AppNavigation(
                        navigationSuiteTypeOverride = NavigationSuiteType.NavigationBar,
                        paneDirectiveOverride = singlePaneDirective,
                    )
                }
            }
        }

        listOf("Home", "Directory", "Access", "Activity", "More").forEach { label ->
            composeRule.onNode(hasText(label) and TabRole).assertIsDisplayed()
        }
    }

    private companion object {
        val TabRole =
            SemanticsMatcher.expectValue(
                SemanticsProperties.Role,
                Role.Tab,
            )
        val singlePaneDirective =
            PaneScaffoldDirective.Default.copy(maxHorizontalPartitions = 1)
        val twoPaneDirective =
            PaneScaffoldDirective.Default.copy(maxHorizontalPartitions = 2)
    }
}
