# Source References

Research snapshot: 2026-09-11.

## authentik

- Upstream project: https://github.com/goauthentik/authentik
- Documentation: https://docs.goauthentik.io/
- OAuth2/OIDC provider and PKCE guidance: https://docs.goauthentik.io/add-secure-apps/providers/oauth2/
- API reference root: https://docs.goauthentik.io/docs/developer-docs/api/reference/authentik
- Version endpoint: https://docs.goauthentik.io/docs/developer-docs/api/reference/admin-version-retrieve
- Root capabilities endpoint: https://docs.goauthentik.io/docs/developer-docs/api/reference/root-config-retrieve
- Users API: https://docs.goauthentik.io/docs/developer-docs/api/reference/core-users-list
- Events API: https://docs.goauthentik.io/docs/developer-docs/api/reference/events-events-list
- RBAC overview: https://docs.goauthentik.io/users-sources/access-control/
- Blueprints: https://docs.goauthentik.io/customize/blueprints
- Outposts: https://docs.goauthentik.io/add-secure-apps/outposts
- 2026.5 release notes: https://docs.goauthentik.io/releases/2026.5/
- 2026.8 release notes: https://docs.goauthentik.io/releases/2026.8/
- 2026.8.1 source tag: https://github.com/goauthentik/authentik/releases/tag/version%2F2026.8.1

## Android

- Compose docs: https://developer.android.com/develop/ui/compose
- AndroidX versions: https://developer.android.com/jetpack/androidx/versions
- Navigation 3: https://developer.android.com/jetpack/androidx/releases/navigation3
- Material 3 Adaptive: https://developer.android.com/jetpack/androidx/releases/compose-material3-adaptive
- Android Gradle Plugin: https://developer.android.com/build/releases/about-agp
- Android Studio releases: https://developer.android.com/studio/releases

## Kotlin / networking / OAuth

- Kotlin releases: https://kotlinlang.org/docs/releases.html
- Retrofit: https://github.com/square/retrofit
- Retrofit releases: https://github.com/square/retrofit/releases
- OpenAPI Generator Kotlin client: https://openapi-generator.tech/docs/generators/kotlin/
- OpenAPI Generator releases: https://github.com/OpenAPITools/openapi-generator/releases
- OpenAPI Generator 7.25.0: https://github.com/OpenAPITools/openapi-generator/releases/tag/v7.25.0
- OpenAPI Generator issue 22049: https://github.com/OpenAPITools/openapi-generator/issues/22049
- AppAuth-Android: https://github.com/openid/AppAuth-Android
- AppAuth Maven Central: https://central.sonatype.com/artifact/net.openid/appauth

## Transport decision note

Ktor was evaluated, but the generated transport uses Retrofit/OkHttp because OpenAPI Generator's documented `jvm-ktor` template still targets Ktor 1.6.7, while its Retrofit path has better current schema feature support. Dependency decisions must be refreshed from official documentation and release notes during implementation.
