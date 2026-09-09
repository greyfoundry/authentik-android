# ADR 0001: Native Android with Kotlin and Compose

- Status: Accepted
- Date: 2026-09-08

## Context

Android is the target platform; native APIs matter for biometrics, Keystore, App Links, adaptive UI, widgets, and future authenticator surfaces. Flutter/KMP would add portability we do not currently need.

## Decision

Use a native Android application written in Kotlin with Jetpack Compose.

## Consequences

Do not introduce cross-platform abstractions unless product scope changes through a new ADR.
