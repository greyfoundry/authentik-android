# UI Reference Map

This map connects product problems to ranked evidence and project-owned decisions. Observed patterns are not adopted until they satisfy the security model, accessibility requirements, current Android guidance, and accepted ADRs.

| UX problem | Primary evidence | Secondary evidence | Required project translation |
|---|---|---|---|
| Admin home/dashboard | Material 3; Now in Android state and content patterns | Shipped-product galleries where terms permit; design synthesis | Operational priority instead of marketing cards; accessible compact density |
| Security event feed | Material lists and accessibility; Now in Android feed mechanics | Mobbin, Refero, or Page Flows searches where access and terms permit | Severity text plus icon, freshness, filters, recovery, and stable keys |
| User directory | Compose samples; Material search and list guidance | Shipped directory, contact, and admin patterns | Permission-aware actions, persistent filters, and stable selection |
| Sessions | Material list-detail and confirmation guidance | Shipped account and security flows | Device, time, and location hierarchy without implying certainty the API lacks |
| Destructive confirmations | Material dialogs; central action policy | Shipped account deletion and revocation flows | Target and effect wording, risk tier, biometric and screenshot policy, and ambiguous outcome handling |
| OAuth/provider configuration | Material form guidance; authentik transport and security specifications | Shipped developer and admin configuration flows | Visible labels, helper text, secret boundaries, and no WebView or password collection |
| RBAC and permissions | authentik domain specifications; Material list-detail | Shipped role and team management patterns | Distinguish inherited, direct, and effective access without color-only meaning |
| Adaptive list-detail | Material 3 Adaptive Navigation 3 scenes; Nav3 recipes; adaptive app samples; Reply, Jetcaster, and Now in Android | Community specimens | One screen implementation across windows with predictable Back and selection |
| Settings and long forms | Material components and Compose state guidance | Page Flows, UX Archive, and Screenlane where terms permit | Progressive disclosure, restoration, validation, and unsaved-change handling |
| Authentication and MFA | AppAuth external-browser rules; Material accessibility | Mobbin, Refero, Page Flows, and UX Archive where access and terms permit | Instance-first setup, clear browser handoff, no password capture, and recoverable states |

## Locked implementation observations

- `android/compose-samples`: Reply changes pane arrangement by window width, and Jetcaster obtains current adaptive window information. Adopt the single-content adaptive principle. Reject sample-specific navigation and branding.
- `android/nowinandroid`: the app collects flows with lifecycle awareness, keeps transient UI state saveable, and places one `NavDisplay` inside an adaptive navigation suite. Adopt state-driven structure. Reject its dependency injection, module graph, and test stack as project defaults.
- `android/nav3-recipes`: typed keys, saveable top-level back stacks, and list-detail scene metadata keep navigation state independent from pane arrangement. Adopt only APIs available in the project's stable pinned versions.
- `android/adaptive-apps-samples`: `NavigationSuiteScaffold` selects the navigation presentation while preserving one destination model. Reject examples that require experimental APIs.
- Tier 2 repositories show useful component anatomy and token grouping. Reject their component libraries, visual identity, dependency choices, and architecture.

The current design synthesis reinforces restrained high-contrast hierarchy, semantic tokens, 48dp targets, visible labels, low ornamental motion, and equal light/dark coverage. Web landing-page composition, green palette recommendations, web fonts, browser animation libraries, and event-channel navigation patterns are outside this Android design contract.
