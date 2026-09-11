# Dependency Baseline

Snapshot date: 2026-09-11.

These are the selected stable baselines for initial implementation, subject to compatibility verification during scaffold creation.

| Component | Version / policy |
|---|---|
| Kotlin | 2.4.20 |
| Android Gradle Plugin | 9.4.0 |
| Gradle | 9.6.0 |
| JDK | 17 |
| compileSdk | 37 |
| targetSdk | 37 |
| minSdk | 28 |
| Compose BOM | 2026.08.00 |
| Compose UI/runtime/foundation | 1.12.0 (via BOM) |
| Material 3 | 1.4.0 |
| Material 3 Adaptive | 1.3.0 |
| Navigation 3 | 1.1.7 stable |
| Retrofit | 3.0.0 |
| OkHttp | 5.5.0 |
| kotlinx.serialization JSON | 1.11.0 |
| OpenAPI Generator | 7.25.0 |
| AppAuth-Android | 0.11.1 |

Additional AndroidX dependencies such as Lifecycle, DataStore, Biometric, Paging, and Room must use the latest compatible stable release at implementation time and be pinned in `libs.versions.toml`.

## Dependency acceptance test

Before adding any dependency:

1. prove the platform/current stack does not already solve the requirement;
2. inspect current official documentation and release notes;
3. inspect maintenance activity and license;
4. check Android minSdk/consumer rules;
5. add only the narrow artifact(s) required;
6. include a test proving the integration boundary.

## Preview dependencies

Do not use alpha/beta/RC libraries in production unless an ADR records the reason and exit plan. Stable Navigation 3 and Material 3 Adaptive exist, so previews are unnecessary for the foundation.
