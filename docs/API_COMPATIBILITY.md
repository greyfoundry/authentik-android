# authentik API Compatibility

## Principle

The app supports authentik through a generated transport layer plus a handwritten compatibility layer. The generated client gives coverage; the compatibility layer gives stability.

Upstream API evolution must be absorbed at the transport/compatibility boundary. Existing user-facing behavior must remain stable unless authentik removes or fundamentally changes the underlying capability.

```text
authentik schema -> generated client -> compatibility adapter -> stable models -> repositories -> UI
```

The UI and repositories never depend on generated DTOs, generated enums, generated endpoint names, or schema-version-specific field shapes.

## Upstream facts that shape this design

- authentik exposes a bearer-authenticated `/api/v3` API.
- upstream treats generated `schema.yml` as the contract between backend and clients.
- upstream generates Go/Rust/TypeScript clients from that schema.
- upstream has made backward-incompatible API changes within release lines before, so runtime contract tests are mandatory.
- `/api/v3/admin/version/` exposes running/latest version, build hash, outdated status, and outpost mismatch state.
- `/api/v3/root/config/` exposes public capability flags.
- `/api/v3/schema/` exposes the running schema.

## Support policy

Initial target:

- current authentik stable release;
- previous stable release line;
- previous-previous stable release line where practical.

Support expands only when automated contract coverage proves it.

A server outside the tested range is not automatically blocked. It receives one of:

- `SUPPORTED`
- `COMPATIBLE_UNVERIFIED`
- `LIMITED`
- `UNSUPPORTED`

Feature gating may still allow safe read-only functionality on unknown versions.

## Schema workflow

CI jobs should:

1. fetch/pin the latest stable upstream schema;
2. generate transport code with a pinned generator;
3. run formatter and compile tests;
4. run OpenAPI breaking-change diff against the currently pinned schema;
5. run contract tests against supported authentik containers;
6. produce a human-readable compatibility report.
7. fetch and regenerate from the upcoming authentik schema on a non-release-blocking scheduled lane until that release becomes supported;
8. run stable-contract tests that prove existing domain models, errors, feature gates, and repository behavior do not change because generated symbols changed.

Do not auto-merge generated changes that include breaking schema changes.

## Runtime compatibility

`CompatibilityRegistry` maps known version/capability quirks to adapters.

Example conceptual API:

```kotlin
data class CompatibilityContext(
    val version: AuthentikVersion,
    val capabilities: Set<ServerCapability>,
)

interface CompatibilityRule {
    fun appliesTo(context: CompatibilityContext): Boolean
}
```

Rules must be narrow and documented with the upstream issue/release that requires them.

The registry starts with a shared default adapter. A version-named adapter is added only when behavior actually differs; release-number symmetry is not a goal. Several authentik release lines should normally feed the same adapter and the same stable `User`, `Session`, `Application`, `Event`, and `Outpost` models.

When an endpoint or required field is absent, mapping returns `UnsupportedFeature` and feature gating presents the capability as unavailable. Absence is never represented by a generated exception escaping into repository or UI code.

## Permission awareness

A visible feature still may not be authorized. The app should prefer permission discovery where available, then gracefully handle 403 responses without treating them as server failures.

Do not infer administrative privilege solely from `is_superuser`.

## Unknown fields

JSON parsing should tolerate unknown response fields so additive upstream changes do not break the app. Missing fields that the app needs must fail explicitly at the mapping boundary rather than becoming unsafe null defaults.

Generated enum additions must not force UI changes. Map them to a stable internal `Unknown`/`Other` value when the app can preserve safety and meaning; otherwise return a documented compatibility error and add an adapter before release.

## Release invariant

A schema update may change generated files without changing stable domain snapshots, repository contract tests, or established screen workflows. A breaking schema diff blocks release until the compatibility adapter and supported-version contract matrix are updated. A new upstream capability may add UI only behind version, capability, and permission gates; older instances retain their existing experience.

## Schema-backed advanced editor

A future generic editor may use schema metadata for low-frequency resources. It must never replace handcrafted flows for dangerous or common operations. Schema-generated forms still require domain validation and action-risk classification.
