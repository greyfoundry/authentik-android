# UI Reference Infrastructure

This directory records evidence used to design authentik Companion. It is a research index, not a build input or a source of product assets.

## Evidence order

1. Project specifications, security rules, and accepted ADRs.
2. Current official Android documentation.
3. Relevant source files in the locked upstream repositories.
4. Written observations of shipped product flows where their terms permit access.
5. Design synthesis checked against the sources above.
6. The project design contract.

Later items cannot override earlier items. References may inform hierarchy, density, interaction, spacing, state treatment, and component structure. They do not replace Material 3, Material 3 Adaptive, Navigation 3, or app-owned domain boundaries.

## Storage boundaries

- `.upstream/` contains shallow clones of public, permissively licensed repositories. It is ignored, disposable, and rebuildable from `upstream-sources.lock.json`.
- `.licensed/` is ignored and local-only. Use it only within the applicable service terms, and never store credentials, cookies, access tokens, or authorization codes there.
- `screens/`, `flows/`, and `components/` accept only project-owned authentik Companion outputs or redistributable assets whose license is recorded next to the asset.
- Commercial gallery screenshots, recordings, exports, proprietary copy, and distinctive trade dress are not committed.

## Review workflow

Before a materially new screen family, destructive workflow, or adaptive relationship is implemented:

1. Confirm the binding project constraints.
2. Refresh the applicable entries in `sources.md`.
3. Verify the relevant clone commit against `upstream-sources.lock.json`.
4. Add or update one project-authored note under `patterns/`.
5. Record adopted and rejected lessons separately in `reference-map.md`.
6. Translate the accepted result into existing Compose and Material primitives.

Repository clones and licensed material must remain untracked. Update the lock file when a reviewed commit changes.
