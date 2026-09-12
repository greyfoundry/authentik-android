# Resource List and Detail

## Pattern: Adaptive resource list-detail

- Problem: Browse a large authentik resource collection and inspect one selected item across phones, tablets, foldables, and desktop-class windows.
- Project constraints: Navigation 3 owns typed back stacks; Material 3 Adaptive scenes arrange panes; screen ViewModels expose immutable state; generated transport models never reach the UI; permissions, capabilities, and freshness remain visible.
- Sources reviewed: [adaptive layout guidance](https://developer.android.com/develop/ui/compose/layouts/adaptive), [Navigation 3](https://developer.android.com/guide/navigation/navigation-3), locked `compose-samples/Reply/app/src/main/java/com/example/reply/ui/ReplyApp.kt`, `nowinandroid/app/src/main/kotlin/com/google/samples/apps/nowinandroid/ui/NiaApp.kt`, `nav3-recipes/app/src/main/java/com/example/nav3recipes/material/listdetail/MaterialListDetailActivity.kt`, `nav3-recipes/app/src/main/java/com/example/nav3recipes/multiplestacks/NavigationState.kt`, and `adaptive-apps-samples/AdaptiveNavigationSample/app/src/main/java/com/google/sample/adaptivenavigationsample/MainActivity.kt`.
- Observed pattern: A stable collection remains available beside its selected detail when space permits, while compact windows present the same entries sequentially. Selection and pane arrangement are derived from the same navigation state.
- Adopt: Preserve selection, query, filters, scroll position, and each top-level stack while switching details or window modes. Use stable item keys and retain one list and one detail implementation.
- Reject: Separate phone and tablet screen trees, a second navigator, width checks scattered through feature composables, source-specific branding, imported component systems, and experimental APIs outside an accepted ADR.
- Compose translation: Use `NavigationSuiteScaffold`, typed `NavKey` entries, the stable Material 3 Adaptive list-detail scene strategy, one list composable, one detail composable, stable lazy keys, lifecycle-aware immutable state collection, and callbacks that update the Navigation 3 back stack.
- Accessibility checks: 48dp targets, logical semantics and traversal order, non-color selection, scalable labels, predictable Back, pane titles, and no redundant detail back affordance when list and detail are both visible.
- Validation: Compact and expanded Compose UI tests prove selection, Back behavior, retained list state, semantics, and 200 percent font-scale operation; navigation unit tests prove independent top-level stack restoration.
