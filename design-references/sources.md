# UI Reference Source Registry

Last reviewed: 2026-09-12.

This registry defines how each source may be used. A link does not grant redistribution rights. Current service terms and repository licenses control access and retention.

## Tier 1: official Android guidance and source

| Source | Canonical URL | License or terms | Access | Reviewed | Permitted local treatment | Purpose |
|---|---|---|---|---|---|---|
| Material 3 for Compose | https://developer.android.com/develop/ui/compose/designsystems/material3 | https://developer.android.com/license | Public | 2026-09-12 | Link and project-authored notes | Components, tokens, theming, states |
| Adaptive navigation | https://developer.android.com/develop/adaptive-apps/guides/build-adaptive-navigation | https://developer.android.com/license | Public | 2026-09-12 | Link and project-authored notes | Compact and expanded navigation |
| Material 3 Adaptive | https://developer.android.com/develop/ui/compose/layouts/adaptive | https://developer.android.com/license | Public | 2026-09-12 | Link and project-authored notes | Window adaptation, panes, posture |
| Navigation 3 | https://developer.android.com/guide/navigation/navigation-3 | https://developer.android.com/license | Public | 2026-09-12 | Link and project-authored notes | Typed keys, back stacks, scenes |
| Compose state | https://developer.android.com/develop/ui/compose/state | https://developer.android.com/license | Public | 2026-09-12 | Link and project-authored notes | State hoisting and lifecycle-aware collection |
| Compose accessibility | https://developer.android.com/develop/ui/compose/accessibility | https://developer.android.com/license | Public | 2026-09-12 | Link and project-authored notes | Semantics, labels, traversal, testing |
| android/compose-samples | https://github.com/android/compose-samples | https://github.com/android/compose-samples/blob/main/LICENSE | Public Git repository | 2026-09-12 | Ignored shallow clone at locked commit | Adaptive layouts and focused Compose patterns |
| android/nowinandroid | https://github.com/android/nowinandroid | https://github.com/android/nowinandroid/blob/main/LICENSE | Public Git repository | 2026-09-12 | Ignored shallow clone at locked commit | State-driven UI, adaptive navigation, preview and test structure |
| android/nav3-recipes | https://github.com/android/nav3-recipes | https://github.com/android/nav3-recipes/blob/main/LICENSE | Public Git repository | 2026-09-12 | Ignored shallow clone at locked commit | Navigation 3 scenes and multiple top-level stacks |
| android/adaptive-apps-samples | https://github.com/android/adaptive-apps-samples | https://github.com/android/adaptive-apps-samples/blob/main/LICENSE.md | Public Git repository | 2026-09-12 | Ignored shallow clone at locked commit | Canonical adaptive layout behavior |

## Tier 2: permissively licensed community specimens

| Source | Canonical URL | License | Access | Reviewed | Permitted local treatment | Purpose |
|---|---|---|---|---|---|---|
| Kiwi.com Orbit Compose | https://github.com/kiwicom/orbit-compose | https://github.com/kiwicom/orbit-compose/blob/main/license.md | Public archived Git repository | 2026-09-12 | Ignored shallow clone at locked commit; written observations only | Dense component anatomy and catalog organization |
| ComposeCookBook | https://github.com/Gurupreet/ComposeCookBook | https://github.com/Gurupreet/ComposeCookBook/blob/master/LICENSE | Public Git repository | 2026-09-12 | Ignored shallow clone at locked commit; verify APIs against current Android docs | Isolated layout and widget techniques |
| Andromeda | https://github.com/aldefy/Andromeda | https://github.com/aldefy/Andromeda/blob/main/license.md | Public Git repository | 2026-09-12 | Ignored shallow clone at locked commit; written observations only | Token taxonomy and component-state organization |

Tier 2 sources are specimens only. Their architecture, dependencies, navigation, branding, and component libraries are not adopted.

## Tier 3: shipped product flow libraries

| Source | Canonical URL | Terms | Access | Reviewed | Permitted local treatment | Purpose |
|---|---|---|---|---|---|---|
| Mobbin | https://mobbin.com/ | https://mobbin.com/terms | Free and paid account tiers; MCP is account and credit gated | 2026-09-12 | Links and written observations only when permitted; no cached gallery content | Authentication, settings, account security, and destructive flow comparison |
| Refero | https://refero.design/ | https://refero.design/terms | Browser access; MCP requires a paid plan and authorization | 2026-09-12 | Links and written observations only; no committed screenshots or exports | Cross-product flow and pattern comparison |
| Page Flows | https://pageflows.com/ | https://pageflows.com/terms | Browser and paid features | 2026-09-12 | Stable flow links and written observations only | Onboarding, account management, recovery, settings |
| UX Archive | https://uxarchive.com/ | https://uxarchive.com/terms | Browser access | 2026-09-12 | Stable flow links and written observations only | Authentication, permissions, confirmations, search |
| Screenlane | https://screenlane.com/ | https://screenlane.com/terms | Browser and paid features | 2026-09-12 | Stable screen links and written observations only | Mobile composition and component placement |

Tier 3 records what shipped products do. It does not establish correctness, accessibility, security, or Android-native behavior. No paid connector or account is required for implementation.
