# Architecture

## Overview

The architecture isolates five volatile boundaries:

1. authentik API schema and version drift;
2. OAuth/OIDC authorization lifecycle;
3. Android credential storage/security APIs;
4. network/TLS differences between self-hosted environments;
5. adaptive UI/navigation behavior.

Everything else should remain ordinary Kotlin application code.

The central compatibility invariant is:

> Upstream API evolution is absorbed at the transport and compatibility boundary. Existing user-facing behavior remains stable unless authentik removes or fundamentally changes the underlying capability.

```text
Compose UI
   ↓ events / UiState
ViewModel
   ↓
Repository
   ↓
Domain gateway
   ↓
Compatibility adapters
   ↓
Generated authentik transport
   ↓
Retrofit + OkHttp
   ↓
authentik instance
```

The same boundary viewed from upstream to UI is:

```text
authentik schema
   ↓
generated client
   ↓
version-specific adapter when behavior differs
   ↓
stable internal models
   ↓
stable repositories
   ↓
Compose UI
```

Generated DTOs, enums, endpoint names, serialization annotations, and upstream field naming never cross the compatibility boundary. Generated-code churn is expected; app behavior churn is not.

## Initial Gradle modules

### `:app`

Owns Android UI, domain/repository logic, security integration, navigation, and app lifecycle.

### `:api-generated`

Owns generated OpenAPI transport models and endpoint interfaces. It must have no UI dependency and must never be hand-edited.

Do not create additional Gradle modules until one of these becomes true:

- build performance measurably benefits;
- generated code needs stricter isolation;
- a reusable Android/Wear component becomes real;
- dependency rules cannot be enforced cleanly by package boundaries;
- independent ownership/release cadence appears.

## Package layout

```text
dev.greyfoundry.authentik
├── app
├── auth
├── compat
├── data
│   ├── instance
│   ├── preferences
│   └── cache
├── domain
│   ├── model
│   ├── action
│   └── repository
├── network
├── security
└── ui
    ├── components
    ├── home
    ├── directory
    ├── access
    ├── activity
    ├── infrastructure
    ├── configuration
    ├── account
    └── settings
```

Packages follow product responsibility, not Clean Architecture ceremony.

## Core interfaces

These names are intentionally stable so feature work can build around them.

```kotlin
interface InstanceRepository {
    val activeInstance: StateFlow<InstanceProfile?>
    val instances: StateFlow<List<InstanceProfile>>
    suspend fun get(instanceId: InstanceId): InstanceProfile?
    suspend fun add(draft: InstanceDraft): InstanceProfile
    suspend fun update(profile: InstanceProfile)
    suspend fun remove(instanceId: InstanceId)
    suspend fun setActive(instanceId: InstanceId)
}

interface AuthSessionRepository {
    val session: StateFlow<AuthSessionState>
    suspend fun authorize(instanceId: InstanceId)
    suspend fun logout(instanceId: InstanceId, revokeRemote: Boolean)
    suspend fun accessToken(instanceId: InstanceId): AccessToken
}

interface SecureCredentialStore {
    suspend fun put(instanceId: InstanceId, value: ByteArray)
    suspend fun get(instanceId: InstanceId): ByteArray?
    suspend fun remove(instanceId: InstanceId)
}

interface AuthentikGateway {
    suspend fun serverProfile(): ServerProfile
    suspend fun currentUser(): User
    suspend fun listUsers(query: UserQuery): Page<User>
    suspend fun listSessions(query: SessionQuery): Page<Session>
    suspend fun listEvents(query: EventQuery): Page<Event>
}
```

`DataStoreInstanceRepository` persists only instance identifiers, normalized
base URLs, display names, and the active instance identifier. Its edits are
atomic, preserve insertion order, and clear active selection when that profile
is removed. OAuth state, access tokens, refresh tokens, passwords, and other
credentials are not part of this storage contract.

`AndroidKeystoreCredentialStore` implements the credential boundary with an
Android Keystore AES-256 key and per-instance AES-GCM envelopes in no-backup
private storage. The binary envelope is bounded and versioned, authenticates its
instance identifier as additional data, and is replaced atomically. Callers see
only stable unavailable or unreadable failures, not provider-specific crypto
errors.

`AppAuthSessionRepository` is the stable OAuth lifecycle boundary. AppAuth
request, response, discovery, and token types do not escape it. Stored AppAuth
JSON is wrapped in an app-owned versioned record that binds it to the exact
`InstanceId`, normalized base URL, and same-origin issuer before encryption.
Access tokens use a redacted app-owned value type, and concurrent callers share
one refresh operation per instance.

OAuth discovery and token exchange use AppAuth's protocol implementation.
Remote token revocation uses the project OkHttp configuration with automatic
redirects and retries disabled. Local logout removes encrypted state before any
optional remote request, so an unavailable server cannot keep the device signed
in.

Do not force every future endpoint into one god-interface. Split `AuthentikGateway` by coherent resource groups once implementation size demands it, while keeping the compatibility layer as the only consumer of generated transport.

## Stable internal contracts

Core resource models such as `User`, `Session`, `Application`, `Event`, and `Outpost` belong to this project. Their names, nullability, enums, and semantics are changed only for a product/domain reason, never merely to mirror a generated schema revision.

Repository and gateway contracts return these internal models and stable domain errors. They must not expose:

- generated DTO or enum types;
- generated endpoint/service names;
- raw HTTP response wrappers;
- schema-version conditionals;
- upstream naming inconsistencies.

Mapping is tolerant of additive upstream fields. Optional upstream data remains nullable or receives a documented safe default only when absence has a well-defined meaning. Missing data required for a safe domain interpretation fails explicitly at the mapping boundary as `MalformedServerResponse` or `UnsupportedFeature` rather than leaking a partial object to the UI.

## Compatibility adapters

Use one default adapter for behavior shared by supported authentik releases. Add a narrowly scoped version-specific adapter, such as `Authentik2026_8Adapter`, only when a documented upstream difference changes parsing, endpoint selection, request construction, or capability semantics.

Do not create an adapter for every release preemptively. `CompatibilityRegistry` selects the narrowest applicable behavior from version, capabilities, edition flags, and verified runtime facts. Adapter rules must identify the upstream release, schema diff, issue, or contract-test fixture that justifies them.

When authentik introduces a genuinely new capability, the compatibility layer exposes a new stable domain capability. Feature availability then derives from server support and permission. Older instances omit or explain the unavailable feature; they do not crash and do not receive a broken control.

## Server profile

At connection time, build a stable description of the server:

```text
ServerProfile
- versionCurrent
- versionLatest
- buildHash
- outdated
- outpostOutdated
- capabilities
- edition/capability flags
- compatibilityLevel
- supportedFeatures
- currentUserPermissions
```

The app derives feature availability from **version + capabilities + permissions**, not version alone.

`DefaultAuthentikGateway` reads the version and public configuration endpoints
through a project-owned Retrofit client. The client uses finite timeouts,
disables automatic redirects and connection retries, and tolerates unknown JSON
fields. HTTP, TLS, network, and decoding failures become stable domain failures
before reaching repositories or UI.

## Generated API

The generator is a build tool, not an application dependency. OpenAPI Generator
7.25.0 uses Kotlin `jvm-retrofit2`, `serializationLibrary=kotlinx_serialization`,
coroutine support, and generated response wrappers. Generated Retrofit
2.x-shaped code runs against project-pinned Retrofit 3.0.0 because Retrofit 3
preserves forward binary compatibility with 2.x. The project supplies OkHttp
5.5.0 and omits the generator-owned `ApiClient` and authentication helpers so
authorization, redirects, TLS, logging, and credential redaction stay under
project control.

Rules:

- pin generator version;
- pin the upstream schema revision/checksum;
- generated output is deterministic;
- generated files are formatted consistently;
- generated code changes land in isolated commits when practical;
- domain models do not expose generator-specific annotations/types;
- schema mismatches discovered in real-server tests are handled in compatibility adapters and reported upstream when appropriate.
- unknown JSON fields are ignored so additive schema evolution does not break reads;
- generated enum additions map to an explicit internal unknown/other representation when lossless handling is safe, or fail at the mapping boundary when it is not;
- generated schema changes do not directly alter existing repository or UI behavior;
- breaking upstream changes require adapter and contract-test work before release.

## Error model

Repositories translate transport failures into stable domain errors:

```text
NetworkUnavailable
TlsFailure
AuthenticationExpired
PermissionDenied
NotFound
Conflict
RateLimited
ServerError
UnsupportedServerVersion
UnsupportedFeature
MalformedServerResponse
AmbiguousMutationResult
```

UI never switches directly on Retrofit/OkHttp exceptions or raw HTTP status codes.

## Concurrency

- one credential refresh path per instance at a time;
- per-instance clients must not share Authorization state;
- mutations should serialize only when they target the same resource and ordering matters;
- cancellation must not be mistaken for confirmed server rollback;
- ambiguous post-dispatch failures return `AmbiguousMutationResult` and trigger a server re-read instead of blind replay.
