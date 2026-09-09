# Compatibility Matrix

Initial implementation target as of 2026-09-08:

| authentik line | Goal | Notes |
|---|---|---|
| 2026.8 | Primary | Current stable release line; includes access requests and newer OAuth/token-exchange capabilities. |
| 2026.5 | Supported | Previous release line; upstream explicitly documents mobile/tablet Admin UI improvements here. |
| 2026.2 | Best-effort / contract baseline | Useful compatibility floor during early development, but upstream security support normally covers only the two most recently released versions. |

This table records test intent, not a promise that every future app feature exists on every line. Individual capabilities are gated by version, server capabilities, and permissions.

All supported lines feed the same project-owned domain and repository contracts. A schema difference is not itself a user-visible behavior difference. Version-specific adapters are recorded here only when contract evidence proves that behavior differs.

CI should update this file from actual real-server test results before each release.
