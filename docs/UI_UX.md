# UI and UX System

## Design language

Use Material 3 as the interaction foundation while retaining a restrained authentik-compatible visual identity. Do not clone the upstream web UI pixel-for-pixel.

## Evidence and design review

UI decisions follow the repository evidence order. Start with project specifications and accepted ADRs, verify implementation guidance against current official Android documentation, inspect only relevant files at the locked commits in `design-references/upstream-sources.lock.json`, and use shipped-product research only as an observation source under its applicable terms. Design synthesis may combine these inputs but cannot override them.

Read `design-references/sources.md`, `design-references/reference-map.md`, and the relevant project-owned pattern note before adding a materially new screen family, destructive workflow, or adaptive relationship. Local reference clones and licensed research are not dependencies or product assets.

## Navigation

Phone:

- Home
- Directory
- Access
- Activity
- More

Large screens/foldables:

- navigation rail or drawer as appropriate;
- list-detail scene strategies for resource collections;
- supporting panes for editors/inspectors;
- no duplicated tablet-only screen implementations.

## Density

Identity administration needs useful information density, but minimum touch targets and font scaling remain non-negotiable.

Prefer:

- compact `ListItem` patterns;
- persistent search/filter controls on large collections;
- secondary metadata in subdued typography;
- clear status chips/icons with text equivalents;
- progressive disclosure for rarely used fields.

## Home

Home prioritizes:

1. instance health/version state;
2. security events;
3. session/user summaries;
4. outpost warnings;
5. recent administrative activity.

No welcome hero, marketing carousel, or ornamental dashboard cards that hide operational information.

## Resource detail pattern

Use consistent tabs/sections where applicable:

- Overview
- Relationships
- Activity
- Access/Permissions
- Advanced

Only show sections that make sense for that resource.

## Forms

- preserve unsaved state through rotation/process recreation where practical;
- validate locally when rules are known;
- preserve server validation errors verbatim enough to be actionable;
- distinguish required, optional, secret, and inherited values;
- reveal advanced fields progressively;
- never prefill a secret field with a server-returned placeholder and then accidentally overwrite it.

## Destructive flows

Do not use tiny overflow actions for dangerous operations. Show effect, target, and uncertainty clearly.

## Errors

Translate low-level failures into actionable messages:

- cannot reach instance;
- certificate not trusted;
- sign-in expired;
- permission denied;
- resource changed/conflict;
- unsupported server capability;
- unknown result after network interruption.

Always preserve a redacted technical-detail path for debugging.

## Motion

Use platform-consistent navigation and state transitions. Avoid ornamental motion on high-frequency admin workflows.

## Theming

- system/light/dark;
- dynamic color optional;
- semantic severity colors controlled by the app so warning/error meaning remains consistent;
- do not encode status solely by color.

## Visual validation

Use Compose previews to author component states and use semantic or instrumented Compose tests to protect behavior and accessibility. Manual screen captures support review but do not provide automated regression protection.

No screenshot framework is currently approved. Compose Preview Screenshot Testing remains experimental and alpha, and no project adopts Roborazzi or another golden stack by precedent alone. ADR 0015 is required before adding a framework and must define deterministic rendering inputs, Linux CI parity, failure diffs, baseline ownership, regeneration controls, and storage limits.
