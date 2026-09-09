# Release and Distribution Policy

## Channels

Planned channels:

- GitHub Releases
- F-Droid
- Obtainium-friendly GitHub artifacts
- Google Play optionally, without making Play Services a runtime requirement

## Versioning

Use Semantic Versioning for the Android application.

Before 1.0, minor releases may introduce substantial UI/API changes but migration of stored credentials and instance profiles must remain explicit and tested.

## Artifacts

Each release should provide:

- signed APK;
- AAB when Play distribution is used;
- checksums;
- SBOM;
- changelog;
- supported-authentik compatibility summary;
- source tag.

## Reproducibility

Release builds must remain suitable for F-Droid reproducibility checks:

- pin Gradle, AGP, Kotlin, dependencies, GitHub Actions, the OpenAPI generator, and the upstream schema checksum;
- omit AGP dependency metadata from APKs and bundles;
- retain symbols in prebuilt native libraries so host-dependent stripping cannot change the APK;
- build the unsigned release APK in pull-request CI;
- keep signing outside the repository and apply it only in the protected release workflow.

F-Droid metadata validation, signed release publication, checksums, SBOM generation, and provenance attestation are release-foundation work. They become required before the first distributable version rather than being simulated against the development version.

## Signing

Signing keys are never stored in the repository. CI release signing must use protected secret storage and limited release permissions.
