# authentik Companion for Android

[![Build](https://github.com/greyfoundry/authentik-android/actions/workflows/build.yml/badge.svg)](https://github.com/greyfoundry/authentik-android/actions/workflows/build.yml)
[![License: Apache-2.0](https://img.shields.io/badge/License-Apache--2.0-blue.svg)](LICENSE)
![Platform: Android 9+](https://img.shields.io/badge/Android-9%2B-3DDC84?logo=android&logoColor=white)
![Built with Kotlin and Compose](https://img.shields.io/badge/Kotlin-Compose-7F52FF?logo=kotlin&logoColor=white)

**A native Android companion for your self-hosted
[authentik](https://goauthentik.io/) instance.** The app is being built for jobs
that are awkward from a phone browser: checking security events, reviewing
sessions, responding to account problems, and managing identity infrastructure
when a laptop is not nearby.

It connects directly to authentik. Core operation will not require a Greyfoundry
service, Firebase, Google Play Services, or a hosted relay.

> [!IMPORTANT]
> This project is in early development. The foundation builds and its first
> stable domain contracts are tested, but there is not yet a release for
> everyday use.

## Why this exists

authentik's web interface is powerful and remains the right place for many large
configuration jobs. A native Android app can make smaller, time-sensitive
workflows much better: show the right information at phone and tablet sizes,
keep authentication in the system browser, use Android's security APIs, and put
risky actions behind clear confirmation and authorization.

The goal is one app with three related areas:

- **Admin** for operations, directory management, access configuration, and incident response.
- **User** for application launch, account settings, sessions, credentials, and self-service.
- **Authenticator** for device enrollment and native approval flows where
  authentik provides a safe integration contract.

This is a companion, not a screen-for-screen copy of authentik's Admin interface.

## What matters here

- **Self-hosted first.** The app talks to the user's own authentik instance.
- **Stable across authentik upgrades.** Generated API code can change with the
  upstream schema; app-owned adapters absorb that churn before it reaches
  repositories or screens.
- **Permission aware.** The server version, capabilities, and current user's
  permissions decide which features appear.
- **Careful with writes.** Administrative actions are classified by risk.
  Destructive and credential-related actions receive stronger protection.
- **Android native.** Jetpack Compose, Material 3, adaptive layouts,
  accessibility, App Links, biometrics, and the Android Keystore are first-class
  parts of the product.
- **Private by design.** Passwords are never collected or stored. Credentials
  must stay out of Room, logs, analytics, screenshots, and support bundles.

## Project status

Foundation work is underway:

- the Android and generated-transport modules build on API 28 and later;
- pull requests run unit tests, lint, debug assembly, and an unsigned
  F-Droid-compatible release build;
- instance identities and HTTPS base URL handling have stable, tested domain contracts;
- the pinned authentik 2026.8.1 schema now generates a reproducible Retrofit
  transport behind an enforced app-owned compatibility boundary;
- server profiling maps version, edition, and capability data into stable app
  models while tolerating additive upstream fields and capability values;
- OIDC sign-in, encrypted credential storage, adaptive app shell, and first
  Users/Events read paths are next.

The full delivery order is in [ROADMAP.md](ROADMAP.md). Completed behavior will
be recorded in [CHANGELOG.md](CHANGELOG.md).

## For developers

The project uses Kotlin, Jetpack Compose, Material 3, Material 3 Adaptive, and
Navigation 3. authentik's OpenAPI schema generates a Retrofit transport module,
but generated DTOs and endpoint names stop at the compatibility boundary:

```text
authentik schema
      -> generated client
      -> compatibility adapter
      -> stable app models
      -> repositories
      -> Compose UI
```

That boundary is a release invariant. An additive schema change can regenerate
transport code without changing existing screen behavior. A real upstream
behavior difference gets a focused compatibility adapter and contract tests.

Build the current project with:

```bash
./gradlew :api-generated:compileKotlin :app:testDebugUnitTest :app:lintDebug :app:assembleDebug :app:assembleRelease
```

Dependency versions are pinned in `gradle/libs.versions.toml`. See
[docs/ARCHITECTURE.md](docs/ARCHITECTURE.md),
[docs/SECURITY_MODEL.md](docs/SECURITY_MODEL.md), and
[docs/API_COMPATIBILITY.md](docs/API_COMPATIBILITY.md) before changing an
integration boundary.

## Distribution

GitHub Releases, F-Droid, and Obtainium-friendly artifacts are planned. Release
builds will include checksums, an SBOM, provenance, and a compatibility summary.
Signing credentials will remain outside the repository.

There is no APK to install yet. Releases will appear on the repository's
[Releases page](https://github.com/greyfoundry/authentik-android/releases) when
the first usable slice is ready.

## Contributing

Issues and pull requests are welcome. Start with
[CONTRIBUTING.md](CONTRIBUTING.md) and the relevant architecture decision in
[docs/adr/](docs/adr/). Security-sensitive reports belong in the private channel
described by [SECURITY.md](SECURITY.md).

## License and affiliation

Licensed under the [Apache License 2.0](LICENSE).

This project is built by Greyfoundry and is not affiliated with or endorsed by
Authentik Security, Inc. `authentik` is the upstream product name and is always
written lowercase.
