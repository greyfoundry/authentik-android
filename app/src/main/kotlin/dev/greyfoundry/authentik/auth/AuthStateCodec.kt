package dev.greyfoundry.authentik.auth

import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import java.net.URI
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

data class DecodedAuthState(
    val issuer: String,
    val authStateJson: String,
)

class AuthStateBindingException : Exception("Stored authorization state does not match this instance.")

object AuthStateCodec {
    fun encode(
        profile: InstanceProfile,
        issuer: String,
        authStateJson: String,
    ): ByteArray {
        requireIssuerMatchesProfile(profile, issuer)
        return JSON.encodeToString(
            StoredAuthState(
                instanceId = profile.id.value,
                baseUrl = profile.baseUrl,
                issuer = issuer,
                authStateJson = authStateJson,
            ),
        ).encodeToByteArray()
    }

    fun decode(profile: InstanceProfile, encoded: ByteArray): DecodedAuthState {
        val stored = try {
            JSON.decodeFromString<StoredAuthState>(encoded.decodeToString())
        } catch (error: Exception) {
            throw AuthStateBindingException()
        }
        if (
            stored.formatVersion != FORMAT_VERSION ||
            runCatching { InstanceId(stored.instanceId) }.getOrNull() != profile.id ||
            stored.baseUrl != profile.baseUrl
        ) {
            throw AuthStateBindingException()
        }
        requireIssuerMatchesProfile(profile, stored.issuer)
        return DecodedAuthState(
            issuer = stored.issuer,
            authStateJson = stored.authStateJson,
        )
    }

    private fun requireIssuerMatchesProfile(profile: InstanceProfile, issuer: String) {
        val base = URI(profile.baseUrl)
        val issuerUri = runCatching { URI(issuer) }.getOrNull()
            ?: throw AuthStateBindingException()
        if (
            issuerUri.scheme != "https" ||
            !issuerUri.host.equals(base.host, ignoreCase = true) ||
            effectivePort(issuerUri) != effectivePort(base) ||
            issuerUri.userInfo != null ||
            issuerUri.query != null ||
            issuerUri.fragment != null
        ) {
            throw AuthStateBindingException()
        }
    }

    private fun effectivePort(uri: URI): Int = if (uri.port == -1) 443 else uri.port

    private const val FORMAT_VERSION = 1
    private val JSON = Json {
        ignoreUnknownKeys = true
    }
}

@Serializable
private data class StoredAuthState(
    @SerialName("format_version")
    val formatVersion: Int = 1,

    @SerialName("instance_id")
    val instanceId: String,

    @SerialName("base_url")
    val baseUrl: String,

    @SerialName("issuer")
    val issuer: String,

    @SerialName("auth_state")
    val authStateJson: String,
)
