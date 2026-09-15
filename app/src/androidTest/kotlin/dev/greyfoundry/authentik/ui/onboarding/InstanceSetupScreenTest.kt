package dev.greyfoundry.authentik.ui.onboarding

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHeightIsAtLeast
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.ConnectedInstance
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.ServerCapability
import dev.greyfoundry.authentik.domain.model.ServerProfile
import dev.greyfoundry.authentik.ui.theme.AuthentikTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class InstanceSetupScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun initialForm_hasVisibleUrlGuidanceAndOnePrimaryAction() {
        setScreen(InstanceSetupUiState())

        composeRule.onNodeWithText("Connect an authentik instance").assertIsDisplayed()
        composeRule.onNodeWithText("Instance URL", useUnmergedTree = true).assertIsDisplayed()
        composeRule.onNodeWithText(
            "Use an HTTPS address, for example https://auth.example.com",
            useUnmergedTree = true,
        ).assertIsDisplayed()
        composeRule.onNode(
            SemanticsMatcher.expectValue(SemanticsProperties.ImeAction, ImeAction.Done),
        ).assertIsDisplayed()
        composeRule.onAllNodesWithTag("primary-action").assertCountEquals(1)
        composeRule.onNode(hasTestTag("primary-action"))
            .assertHeightIsAtLeast(48.dp)
            .assertIsNotEnabled()
        composeRule.onNodeWithText("Password").assertDoesNotExist()
    }

    @Test
    fun urlError_isAssociatedWithTheFieldSemantics() {
        setScreen(
            InstanceSetupUiState(
                baseUrl = "http://auth.example.com",
                baseUrlError = InstanceUrlError.HTTPS_REQUIRED,
            ),
        )

        composeRule.onNode(
            SemanticsMatcher.expectValue(
                SemanticsProperties.Error,
                "Use an HTTPS instance URL.",
            ),
        ).assertIsDisplayed()
        composeRule.onNodeWithText("Use an HTTPS instance URL.", useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun checkingState_announcesProgressAndDisablesDuplicateSubmit() {
        setScreen(
            InstanceSetupUiState(
                baseUrl = "https://auth.example.com",
                connection = ConnectionState.Checking,
            ),
        )

        composeRule.onNode(
            SemanticsMatcher.expectValue(
                SemanticsProperties.LiveRegion,
                LiveRegionMode.Polite,
            ),
        ).assertIsDisplayed()
        composeRule.onNode(hasTestTag("primary-action")).assertIsNotEnabled()
        composeRule.onAllNodesWithTag("primary-action").assertCountEquals(1)
    }

    @Test
    fun verifiedInstance_explainsBrowserHandoffBeforeSignIn() {
        var signInCalls = 0
        setScreen(
            state =
                InstanceSetupUiState(
                    baseUrl = "https://auth.example.com/",
                    connection = ConnectionState.Ready(connectedInstance()),
                ),
            onSignIn = { signInCalls += 1 },
        )

        composeRule.onNodeWithText("Instance verified").assertIsDisplayed()
        composeRule.onNodeWithText("auth.example.com").assertIsDisplayed()
        composeRule.onNode(hasTestTag("verified-instance-url")).assertIsDisplayed()
        composeRule.onNodeWithText("2026.8.1").assertIsDisplayed()
        composeRule.onNodeWithText("Supported").assertIsDisplayed()
        composeRule.onNodeWithText("2 available").assertIsDisplayed()
        composeRule.onNodeWithText(
            "Sign-in opens in your browser and returns here when authentik finishes authentication. This app never asks for your authentik password.",
        ).assertIsDisplayed()
        composeRule.onNodeWithText("Sign in in browser").performClick()
        composeRule.runOnIdle { assertEquals(1, signInCalls) }
    }

    @Test
    fun formRemainsUsableAtTwoHundredPercentFontScale() {
        composeRule.setContent {
            val density = LocalDensity.current
            CompositionLocalProvider(
                LocalDensity provides Density(density.density, fontScale = 2f),
            ) {
                AuthentikTheme {
                    InstanceSetupScreen(
                        state = InstanceSetupUiState(),
                        onBaseUrlChanged = {},
                        onBaseUrlFocusChanged = {},
                        onContinue = {},
                        onRetry = {},
                        onEditInstance = {},
                        onSignIn = {},
                        onOpenAdvancedTls = null,
                    )
                }
            }
        }

        composeRule.onNodeWithText("Connect an authentik instance").assertIsDisplayed()
        composeRule.onNode(hasTestTag("primary-action")).assertHeightIsAtLeast(48.dp)
    }

    private fun setScreen(
        state: InstanceSetupUiState,
        onSignIn: () -> Unit = {},
    ) {
        composeRule.setContent {
            AuthentikTheme {
                InstanceSetupScreen(
                    state = state,
                    onBaseUrlChanged = {},
                    onBaseUrlFocusChanged = {},
                    onContinue = {},
                    onRetry = {},
                    onEditInstance = {},
                    onSignIn = onSignIn,
                    onOpenAdvancedTls = null,
                )
            }
        }
    }

    private fun connectedInstance() = ConnectedInstance(
        instance =
            InstanceProfile(
                id = InstanceId("3f3d5ad4-0e2d-48f8-b2b7-01e3dbc1ef45"),
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
                capabilities = setOf(
                    ServerCapability("activity"),
                    ServerCapability("users"),
                ),
                compatibilityLevel = CompatibilityLevel.SUPPORTED,
            ),
    )
}
