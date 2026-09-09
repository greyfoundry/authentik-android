# authentik Companion for Android

> Unofficial, open-source Android companion for [authentik](https://goauthentik.io/), built by Greyfoundry.

`authentik Companion` is a native Android client for operating, administering, and eventually authenticating against self-hosted authentik instances. The project is intentionally Android-first and self-hosted-first. It does not require a Greyfoundry backend, Firebase, or Google Play Services for core operation.

## Why this exists

authentik is powerful, but its Admin interface remains primarily desktop-oriented. A phone is a good place for fast operational workflows: inspect security events, review sessions, disable a compromised account, terminate sessions, check outposts, review access requests, and manage identity infrastructure when a laptop is not available.

The long-term goal is broader than a dashboard. One Android app should eventually cover three related surfaces:

1. **Admin** - native authentik administration and incident response.
2. **User** - application launcher, account settings, sessions, credentials, and self-service.
3. **Authenticator** - device enrollment and, if upstream capabilities permit, native approval flows.

The app complements authentik. It does not blindly reproduce the web Admin interface screen-for-screen.

## Core principles

- **Self-hosted-first.** The app talks directly to the user's authentik instance.
- **No required cloud relay.** A server-side companion may exist later only for features that genuinely require one, such as push delivery.
- **Stable behavior across schema evolution.** Generated transport may change with authentik's OpenAPI schema, but compatibility adapters absorb that churn before it reaches handwritten domain models, repositories, or UI.
- **Permission-aware.** Feature visibility and actions depend on server version, capabilities, and the current user's permissions.
- **Read broadly, write deliberately.** Administrative writes are risk-classified and protected according to impact.
- **Online-first.** Cached reads are allowed; administrative writes are never queued for later execution.
- **Android-native.** Compose, Material 3, adaptive layouts, predictive back, accessibility, biometrics, App Links, and platform security APIs are first-class.
- **KISS/YAGNI.** Future-proof boundaries, not speculative abstractions.

## Technology baseline

The baseline selected on 2026-09-08 is:

- Kotlin 2.4.20
- Android Gradle Plugin 9.4.0
- Gradle 9.6.0
- JDK 17
- compileSdk 37 / targetSdk 37
- minSdk 28
- Compose BOM 2026.08.00 (maps core Compose to 1.12.0 and Material 3 to 1.4.0)
- Jetpack Compose UI 1.12.0
- Material 3 1.4.0
- Material 3 Adaptive 1.3.0
- Navigation 3 1.1.7 stable
- Retrofit 3.0.0 with OkHttp 4.12.x-compatible transport
- kotlinx.serialization
- AppAuth-Android 0.11.1
- DataStore
- Android Keystore + AES-GCM
- BiometricPrompt
- Room only when persistent offline-readable data has a concrete use
- WorkManager only when background work has a concrete use
- Manual dependency injection initially

All dependency versions must live in `gradle/libs.versions.toml` once implementation begins. Dynamic versions are forbidden.

## Repository shape

The intended initial code shape is deliberately small:

```text
app/
  src/main/kotlin/dev/greyfoundry/authentik/
    app/
    auth/
    compat/
    data/
    domain/
    network/
    security/
    ui/
api-generated/
  # generated OpenAPI Retrofit transport only; never hand-edit
build-logic/          # add only if repeated build configuration actually appears

docs/
  adr/
  implementation/
```

Do not split features into separate Gradle modules until there is demonstrated build-time, ownership, or dependency-boundary value.

## First implementation sequence

1. Scaffold project and CI.
2. Establish generated OpenAPI transport and compatibility gateway.
3. Implement instance profiles and capability/version detection.
4. Implement OIDC Authorization Code + PKCE using AppAuth.
5. Add Keystore-backed credential storage and optional biometric app lock.
6. Implement Home, Activity, Users, Sessions, Applications, and Outposts as read paths.
7. Add risk-classified actions: terminate session, enable/disable user.
8. Expand into Directory, RBAC, providers/sources, flows/policies, blueprints, infrastructure, and self-service.

See [`ROADMAP.md`](ROADMAP.md), [`docs/ARCHITECTURE.md`](docs/ARCHITECTURE.md), and [`docs/implementation/00-foundation.md`](docs/implementation/00-foundation.md).

## Non-goals

- Reimplementing authentik's backend.
- Shipping a mandatory Greyfoundry SaaS.
- Using a WebView for authentik login.
- Storing authentik passwords.
- Providing an "ignore TLS errors" switch.
- Queuing administrative writes offline.
- Creating a plugin system before a real extension use case exists.
- Supporting iOS or Kotlin Multiplatform merely because they exist.

## License

Apache License 2.0. See [`LICENSE`](LICENSE).

## Trademark and affiliation

This project is not affiliated with or endorsed by Authentik Security, Inc. `authentik` is the upstream product name and is always written lowercase. The repository name is descriptive so users can find the project; branding should remain clearly unofficial.
