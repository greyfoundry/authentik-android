# Testing Strategy

## Test pyramid

### Unit tests

Use pure Kotlin tests for:

- domain mapping;
- stable model snapshots across generated schema revisions;
- version parsing;
- feature/capability gates;
- permission interpretation;
- action-risk decisions;
- redaction;
- stale-cache logic;
- navigation state reducers.

### Transport tests

Use OkHttp `MockWebServer` for:

- request construction;
- response parsing/mapping;
- error translation;
- auth header attachment;
- refresh behavior integration boundaries;
- redirect/header stripping behavior;
- pagination.

### Android instrumented tests

Use for:

- Keystore;
- encrypted credential persistence;
- App Link handling;
- BiometricPrompt boundary behavior;
- screenshot/FLAG_SECURE policy;
- custom CA configuration;
- process recreation.

### Compose UI tests

Cover:

- top-level navigation;
- list/detail adaptive behavior;
- search/filter;
- loading/error/empty/stale states;
- destructive confirmations;
- accessibility semantics.

### Real authentik contract tests

Run critical flows against containerized authentik versions.

Suggested matrix:

- current stable;
- previous stable release line;
- previous-previous line where supported;
- optional scheduled run against upstream next/nightly.

Seed deterministic fixtures through blueprints/API.

### Schema evolution tests

For every pinned schema update:

1. regenerate the transport from the supported schema;
2. regenerate from the current upstream stable schema;
3. regenerate from the upcoming schema when upstream publishes one;
4. compile the compatibility layer against each generated variant;
5. run the same domain mapping, error, capability, and repository contract suite;
6. compare stable model snapshots and feature decisions;
7. require a narrow adapter plus a documented fixture for every intentional difference.

Generated source diffs are expected. Existing stable model/repository behavior diffs are release blockers unless an upstream capability was removed or fundamentally changed and the compatibility documentation explains the user impact.

## Mutation test cases

Every high-impact mutation should cover:

1. success;
2. 400 validation failure;
3. 401 expired auth;
4. 403 permission denial;
5. 404 stale resource;
6. 409/conflict where applicable;
7. connection failure before request dispatch;
8. timeout after possible request dispatch;
9. re-read/reconciliation after ambiguous outcome;
10. unsupported-server guard.

## CI gates

A pull request should eventually gate on:

- Gradle build;
- unit tests;
- Android lint;
- formatting/static analysis;
- dependency vulnerability scan;
- generated-code consistency;
- OpenAPI diff report;
- stable-contract matrix against pinned, current, and upcoming schemas;
- selected real-authentik contract tests;
- instrumented tests on a supported API level;
- release build smoke test.
