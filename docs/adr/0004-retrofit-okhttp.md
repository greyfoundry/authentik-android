# ADR 0004: Generated Retrofit transport with OkHttp

- Status: Accepted
- Date: 2026-09-08

## Context

OpenAPI Generator has a stable Kotlin Retrofit client path with coroutine and kotlinx.serialization support, including stronger oneOf/anyOf support than its documented jvm-ktor template. Retrofit 3 remains forward binary-compatible with generated Retrofit 2.x interfaces, while OkHttp is the single underlying transport.

## Decision

Generate Retrofit service/client transport from OpenAPI using the Kotlin `jvm-retrofit2` template, `kotlinx_serialization`, coroutines, and a project-supplied OkHttp client. Pin OpenAPI Generator 7.24.0 and Retrofit 3.0.0 at the application level.

## Consequences

Non-idempotent retries remain disabled unless explicitly safe.
