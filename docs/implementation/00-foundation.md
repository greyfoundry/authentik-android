# Foundation Implementation Plan

## Goal

Produce a buildable Android project with stable navigation/design foundations, generated API isolation, instance modeling, and CI.

## Deliverables

- `:app` and `:api-generated` modules
- version catalog with pinned stable dependencies
- Compose Material 3 theme and adaptive navigation shell
- `InstanceId`, `InstanceProfile`, `ServerProfile`
- generated Retrofit/OkHttp client factory without auth first
- generated transport task using a pinned authentik schema and generator
- compatibility mapping boundary
- unit/MockWebServer test infrastructure
- CI build/test/lint/generated-diff checks and an unsigned F-Droid-compatible release build

## Acceptance

A clean checkout builds with a JDK 17-compatible toolchain and the Gradle wrapper, unit tests pass, generated code can be reproduced from the pinned schema, the unsigned release APK is F-Droid-compatible, and the app launches to an empty-instance onboarding screen on API 28+.
