# Operations and Activity

## Pattern: Scannable operational activity

- Problem: Present security events, instance health, freshness, severity, and recovery actions at useful administrative density without hiding uncertainty.
- Project constraints: Stable app models own severity and freshness; capability absence is graceful; cached identity data exposes staleness; permissions control available actions; sensitive actions pass through the central action policy.
- Sources reviewed: [Material 3](https://developer.android.com/develop/ui/compose/designsystems/material3), [Compose accessibility](https://developer.android.com/develop/ui/compose/accessibility), locked `nowinandroid/app/src/main/kotlin/com/google/samples/apps/nowinandroid/ui/NiaApp.kt`, its state-driven feed structure under `feature/foryou/impl`, and the Tier 3 observation boundaries in `../sources.md`.
- Observed pattern: Dense feeds remain scannable when primary identity, time, severity, and status have consistent positions; filter and recovery controls remain near the collection; loading, empty, stale, and failed states preserve context instead of replacing the whole screen without explanation.
- Adopt: Order the home surface by operational importance, use severity text with a supporting icon, display freshness explicitly, keep filters discoverable, retain the last trustworthy content during recoverable refresh, and expose redacted technical details on demand.
- Reject: Marketing heroes, decorative analytics, color-only severity, endless unlabeled icon rows, fabricated precision for device or location data, auto-refresh that steals focus, and copied commercial-gallery layouts.
- Compose translation: Render sealed immutable UI states with Material 3 list items, assist chips, banners, and progress indicators; use stable lazy keys, derived display values, lifecycle-aware flow collection, and event callbacks; keep transport errors and generated enums below the repository boundary.
- Accessibility checks: Severity and freshness spoken as text, headings and collection semantics, 48dp filter and retry targets, logical reading order, focus retention after refresh, live-region use only for actionable changes, high contrast, and 200 percent font-scale reflow.
- Validation: Reducer tests cover loading, content, empty, stale, permission-denied, and unsupported states; Compose tests cover semantics, stable filtering, retry, and retained context; repository tests prove error and freshness mapping.
