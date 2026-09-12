package dev.greyfoundry.authentik.auth

import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthStateCodecTest {
    private val profile = InstanceProfile(
        id = InstanceId("63092430-1f67-4ed4-983e-02977526b91a"),
        baseUrl = "https://auth.example.com/",
        displayName = "Example",
    )

    @Test
    fun `round trips app-owned binding and AppAuth state`() {
        val encoded = AuthStateCodec.encode(
            profile = profile,
            issuer = "https://auth.example.com/application/o/authentik-android/",
            authStateJson = "{\"authorized\":true}",
        )

        val decoded = AuthStateCodec.decode(profile, encoded)

        assertEquals("https://auth.example.com/application/o/authentik-android/", decoded.issuer)
        assertEquals("{\"authorized\":true}", decoded.authStateJson)
    }

    @Test
    fun `rejects state copied to another instance`() {
        val encoded = AuthStateCodec.encode(
            profile = profile,
            issuer = "https://auth.example.com/application/o/authentik-android/",
            authStateJson = "{}",
        )
        val otherProfile = profile.copy(
            id = InstanceId("f070772f-782b-43bf-8420-8bbf38f5cfa8"),
        )

        assertThrows(AuthStateBindingException::class.java) {
            AuthStateCodec.decode(otherProfile, encoded)
        }
    }

    @Test
    fun `rejects state after instance URL changes`() {
        val encoded = AuthStateCodec.encode(
            profile = profile,
            issuer = "https://auth.example.com/application/o/authentik-android/",
            authStateJson = "{}",
        )
        val changedProfile = profile.copy(baseUrl = "https://replacement.example.com/")

        assertThrows(AuthStateBindingException::class.java) {
            AuthStateCodec.decode(changedProfile, encoded)
        }
    }

    @Test
    fun `tolerates additive stored fields`() {
        val encoded = AuthStateCodec.encode(
            profile = profile,
            issuer = "https://auth.example.com/",
            authStateJson = "{}",
        )
        val withUnknownField = encoded.decodeToString()
            .replaceFirst("{", "{\"future_field\":true,")
            .encodeToByteArray()

        assertTrue(AuthStateCodec.decode(profile, withUnknownField).authStateJson.isNotEmpty())
    }
}
