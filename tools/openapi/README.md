# authentik OpenAPI generation

The committed transport sources are generated from authentik's official OpenAPI
schema. They are not edited by hand and are never used directly by UI or
repository code.

## Pinned inputs

- authentik release: `2026.8.1`
- authentik commit: `b4de7336e903ef51febf42c0ff3b57c484866cdc`
- schema SHA-256: `67e8bbc516b3a7862b233d997c53e80bd075f9edf735d86b8c5a9a1d2d1b168f`
- OpenAPI Generator: `7.25.0`
- generator: Kotlin `jvm-retrofit2`
- serialization: kotlinx.serialization
- API style: coroutines with Retrofit `Response<T>` wrappers

The schema URL and checksum live in `schema.properties`. The checksum is verified
before generation. The schema file itself is downloaded into
`api-generated/build/` and is not committed.

`schema.properties` also records the reviewed upcoming schema snapshot. That
snapshot is used by compatibility CI and is not the source of the shipping
transport.

## Regenerate

Windows:

```powershell
.\tools\openapi\generate.ps1 current
```

Linux and macOS:

```bash
./tools/openapi/generate.sh current
```

Use `upcoming` instead of `current` to test the reviewed development snapshot.
Upcoming output is temporary and must not be committed as the shipping transport.

Run the current command twice and verify that the second run leaves
`api-generated/src/main/kotlin` unchanged. Generated diffs are reviewed as
transport changes. App behavior changes require separate compatibility adapter
and contract-test changes.

## Project-owned transport policy

The generator's authentication helpers and `ApiClient` are omitted from the
committed output. The app supplies the OkHttp client so authorization, redirect,
TLS, logging, and credential-redaction rules remain under project control.

OpenAPI free-form object values map to `JsonElement`. This keeps unknown JSON
data readable without exposing untyped generated values across the compatibility
boundary.

OpenAPI Generator 7.25.0 can emit an extra invocation after some generated
`HashMap` constructors. The sync task applies one narrow, deterministic
replacement for that known generator defect. Remove the workaround after
[OpenAPI Generator issue 22049](https://github.com/OpenAPITools/openapi-generator/issues/22049)
is fixed in the pinned stable generator.
