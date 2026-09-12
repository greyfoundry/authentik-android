package dev.greyfoundry.authentik.auth

import android.net.Uri
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import net.openid.appauth.AuthorizationServiceConfiguration
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthorizationRequestFactoryTest {
    private val profile = InstanceProfile(
        id = InstanceId("a7fa04ab-0044-44e6-9b9f-4dcf321acef7"),
        baseUrl = "https://auth.example.com/",
        displayName = "Example",
    )
    private val serviceConfiguration = AuthorizationServiceConfiguration(
        Uri.parse("https://auth.example.com/application/o/authorize/"),
        Uri.parse("https://auth.example.com/application/o/token/"),
    )

    @Test
    fun usesAuthentikPublicClientConfigurationAndRequiredScopes() {
        val request = AuthorizationRequestFactory.create(profile, serviceConfiguration)

        assertEquals(AuthConfiguration.CLIENT_ID, request.clientId)
        assertEquals(AuthConfiguration.REDIRECT_URI, request.redirectUri.toString())
        assertEquals("code", request.responseType)
        assertEquals(AuthConfiguration.SCOPES, request.scope)
    }

    @Test
    fun keepsAppAuthGeneratedStateNonceAndPkce() {
        val request = AuthorizationRequestFactory.create(profile, serviceConfiguration)

        assertFalse(request.state.isNullOrBlank())
        assertFalse(request.nonce.isNullOrBlank())
        assertFalse(request.codeVerifier.isNullOrBlank())
        assertEquals("S256", request.codeVerifierChallengeMethod)
        assertNotNull(request.codeVerifierChallenge)
        assertTrue(request.codeVerifierChallenge!!.isNotBlank())
    }

    @Test
    fun buildsAuthentikApplicationDiscoveryUrl() {
        assertEquals(
            "https://auth.example.com/application/o/authentik-android/.well-known/openid-configuration",
            AuthConfiguration.discoveryUrl(profile).toString(),
        )
    }

    @Test
    fun rejectsCrossHostAuthorizationConfiguration() {
        val crossHost = AuthorizationServiceConfiguration(
            Uri.parse("https://attacker.example/application/o/authorize/"),
            Uri.parse("https://auth.example.com/application/o/token/"),
        )

        assertThrows(IllegalArgumentException::class.java) {
            AuthorizationRequestFactory.create(profile, crossHost)
        }
    }
}
