package dev.greyfoundry.authentik.ui.components

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHeightIsAtLeast
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsAtLeast
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import dev.greyfoundry.authentik.ui.theme.AuthentikTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class OperationalStateComponentsTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun statusLabel_exposesReadableTextWithoutDuplicateIconNode() {
        composeRule.setContent {
            AuthentikTheme {
                StatusLabel(
                    label = "Healthy",
                    tone = StatusTone.SUCCESS,
                    icon = TestIcon,
                )
            }
        }

        composeRule.onNodeWithText("Healthy").assertIsDisplayed()
        composeRule
            .onAllNodesWithText("Healthy", useUnmergedTree = true)
            .assertCountEquals(1)
    }

    @Test
    fun freshnessNotice_exposesRefreshAsButtonWithMinimumTarget() {
        var refreshCount = 0
        composeRule.setContent {
            AuthentikTheme {
                FreshnessNotice(
                    model =
                        FreshnessUiModel(
                            state = FreshnessUiModel.State.STALE,
                            updatedAtLabel = "5 minutes ago",
                        ),
                    onRefresh = { refreshCount += 1 },
                )
            }
        }

        composeRule.onNode(hasText("Data may be out of date")).assertIsDisplayed()
        composeRule
            .onNode(hasText("Refresh") and ButtonRole)
            .assertWidthIsAtLeast(48.dp)
            .assertHeightIsAtLeast(48.dp)
            .performClick()
        composeRule.runOnIdle { assertEquals(1, refreshCount) }
    }

    @Test
    fun errorPanel_exposesRecoveryActionsAsButtons() {
        var retryCount = 0
        var detailsCount = 0
        composeRule.setContent {
            AuthentikTheme {
                ErrorPanel(
                    title = "Could not load users",
                    recovery = "Check the connection and try again.",
                    onRetry = { retryCount += 1 },
                    onShowDetails = { detailsCount += 1 },
                )
            }
        }

        composeRule.onNodeWithText("Check the connection and try again.").assertIsDisplayed()
        composeRule
            .onNode(
                SemanticsMatcher.expectValue(
                    SemanticsProperties.Error,
                    "Check the connection and try again.",
                ),
            ).assertIsDisplayed()
        listOf("Retry", "Show details").forEach { label ->
            composeRule
                .onNode(hasText(label) and ButtonRole)
                .assertWidthIsAtLeast(48.dp)
                .assertHeightIsAtLeast(48.dp)
                .performClick()
        }
        composeRule.runOnIdle {
            assertEquals(1, retryCount)
            assertEquals(1, detailsCount)
        }
    }

    @Test
    fun loadingPane_announcesPoliteLoadingState() {
        composeRule.setContent {
            AuthentikTheme {
                LoadingPane(label = "Loading activity")
            }
        }

        composeRule
            .onNode(
                SemanticsMatcher.expectValue(
                    SemanticsProperties.LiveRegion,
                    LiveRegionMode.Polite,
                ) and
                    SemanticsMatcher.expectValue(
                        SemanticsProperties.StateDescription,
                        "In progress",
                    ),
            ).assertIsDisplayed()
    }

    @Test
    fun operationalPanels_remainReadableAtTwoHundredPercentFontScale() {
        composeRule.setContent {
            val density = LocalDensity.current
            CompositionLocalProvider(
                LocalDensity provides Density(density.density, fontScale = 2f),
            ) {
                AuthentikTheme {
                    ErrorPanel(
                        title = "Could not load activity from this authentik instance",
                        recovery = "Keep the current information visible and try again when the connection returns.",
                        onRetry = {},
                        onShowDetails = {},
                    )
                }
            }
        }

        composeRule.onNodeWithText("Could not load activity from this authentik instance").assertIsDisplayed()
        composeRule.onNodeWithText("Keep the current information visible and try again when the connection returns.").assertIsDisplayed()
        composeRule.onNode(hasText("Retry") and ButtonRole).assertHeightIsAtLeast(48.dp)
        composeRule.onNode(hasText("Show details") and ButtonRole).assertHeightIsAtLeast(48.dp)
    }

    private companion object {
        val ButtonRole =
            SemanticsMatcher.expectValue(
                SemanticsProperties.Role,
                Role.Button,
            )

        val TestIcon =
            ImageVector.Builder(
                name = "TestIcon",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            ).apply {
                path(fill = SolidColor(Color.Black)) {
                    moveTo(4f, 4f)
                    lineTo(20f, 4f)
                    lineTo(20f, 20f)
                    lineTo(4f, 20f)
                    close()
                }
            }.build()
    }
}
