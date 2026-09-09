# ADR 0002: Generated OpenAPI transport behind a handwritten gateway

- Status: Accepted
- Date: 2026-09-08
- Amended: 2026-09-09

## Context

authentik itself treats generated OpenAPI clients as its API contract, while runtime/schema mismatches are still possible. Generation gives coverage; a gateway prevents upstream churn from infecting the app.

## Decision

Generate authentik transport code from a pinned upstream OpenAPI schema. Generated code may change whenever the schema changes, but generated DTOs, enums, endpoint names, response wrappers, and serialization details do not cross the compatibility boundary.

Handwritten adapters map generated transport into project-owned stable models and domain errors. Use a shared default adapter and add a version-specific adapter only when a documented upstream behavior difference requires one. Do not create one adapter per authentik release by convention.

Repositories and UI depend only on stable handwritten contracts. Additive fields and unknown JSON properties are tolerated. Missing required capabilities become an explicit unavailable/unsupported result. A breaking upstream change requires adapter and contract-test work before release rather than a user-facing behavior change.

## Consequences

Generated files are never hand-edited. Real-server contract tests remain required across supported releases, and scheduled generation against the upcoming schema provides early warning. Existing domain/repository contract tests must remain stable across schema-only churn.
