package dev.greyfoundry.authentik.auth

import android.net.Uri
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues

object AuthConfiguration {
    const val APPLICATION_SLUG = "authentik-android"
    const val CLIENT_ID = "dev.greyfoundry.authentik"
    const val REDIRECT_URI = "dev.greyfoundry.authentik://oauth2redirect/callback"
    const val SCOPES = "openid profile email offline_access goauthentik.io/api"

    fun discoveryUrl(profile: InstanceProfile): Uri = Uri.parse(
        "${profile.baseUrl}application/o/$APPLICATION_SLUG/.well-known/openid-configuration",
    )
}

object AuthorizationRequestFactory {
    fun create(
        profile: InstanceProfile,
        serviceConfiguration: AuthorizationServiceConfiguration,
    ): AuthorizationRequest {
        validate(profile, serviceConfiguration)

        return AuthorizationRequest.Builder(
            serviceConfiguration,
            AuthConfiguration.CLIENT_ID,
            ResponseTypeValues.CODE,
            Uri.parse(AuthConfiguration.REDIRECT_URI),
        )
            .setScope(AuthConfiguration.SCOPES)
            .build()
    }

    fun validate(
        profile: InstanceProfile,
        serviceConfiguration: AuthorizationServiceConfiguration,
    ) {
        requireSameOrigin(profile, serviceConfiguration.authorizationEndpoint)
        requireSameOrigin(profile, serviceConfiguration.tokenEndpoint)
        serviceConfiguration.endSessionEndpoint?.let { requireSameOrigin(profile, it) }
    }

    private fun requireSameOrigin(profile: InstanceProfile, endpoint: Uri) {
        val base = Uri.parse(profile.baseUrl)
        require(endpoint.scheme == "https") { "OIDC endpoints must use HTTPS." }
        require(endpoint.userInfo == null) { "OIDC endpoints must not include user information." }
        require(endpoint.fragment == null) { "OIDC endpoints must not include fragments." }
        require(endpoint.host.equals(base.host, ignoreCase = true)) {
            "OIDC endpoints must use the configured instance host."
        }
        require(effectivePort(endpoint) == effectivePort(base)) {
            "OIDC endpoints must use the configured instance port."
        }
    }

    private fun effectivePort(uri: Uri): Int = if (uri.port == -1) 443 else uri.port
}
