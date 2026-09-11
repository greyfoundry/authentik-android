# Compatibility Matrix

Implementation target as of 2026-09-11:

| authentik line | Goal | Notes |
|---|---|---|
| 2026.8.1 | Primary | Current stable schema pinned for the generated shipping transport. |
| 2026.5 | Supported | Previous release line; upstream explicitly documents mobile/tablet Admin UI improvements here. |
| 2026.2 | Best-effort / contract baseline | Useful compatibility floor during early development, but upstream security support normally covers only the two most recently released versions. |

This table records test intent, not a promise that every future app feature exists on every line. Individual capabilities are gated by version, server capabilities, and permissions.

All supported lines feed the same project-owned domain and repository contracts. A schema difference is not itself a user-visible behavior difference. Version-specific adapters are recorded here only when contract evidence proves that behavior differs.

CI should update this file from actual real-server test results before each release.

The 2026.11.0-rc1 development snapshot is generated and compiled in scheduled
compatibility CI. It is not part of the supported matrix until the stable release
is pinned and real-server contract coverage passes.
