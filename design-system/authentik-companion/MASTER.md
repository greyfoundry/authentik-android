# authentik Companion Design Contract

This contract defines the product-wide visual and interaction system for authentik Companion. Page files may add constraints but cannot weaken this contract, project specifications, security rules, or accepted ADRs.

## Product profile

```text
platform: native Android
product: identity administration and incident response companion
audience: self-hosters, administrators, on-call operators, and authentik users
style: restrained, professional, operational, content-first Material 3
variance: 3
motion: 3
density: 7
```

The app is built by Greyfoundry and is not an official authentik application. It should feel related to authentik without reproducing the web interface or another product's identity.

## Foundation

- Use Compose, Material 3, Material 3 Adaptive, and stable Navigation 3 APIs.
- Use one content implementation across phones, tablets, foldables, and resizable windows.
- Keep screen state immutable and owned by screen ViewModels. Reusable composables receive state and callbacks.
- Keep generated transport types, server versions, and compatibility decisions outside UI code.
- Prefer familiar Android components over custom controls.

## Color

The official authentik orange `#FD4B2D` is the brand seed and may appear as a non-text highlight. It is not a universal background for white text.

- Light primary: `#9C250E` with `#FFFFFF` content.
- Dark primary: `#FFB4A4` with `#5F1608` content.
- Brand highlight: `#FD4B2D` with black content when the color carries text or a meaningful icon.
- Use Material semantic roles instead of page-local color constants.
- Dynamic color may theme general chrome when enabled by the user.
- Success, warning, error, information, stale, and risk roles remain app-owned so their meaning is stable under dynamic color.
- Every status uses text and an icon or shape. Color alone never communicates state.
- Light and dark themes must expose the same hierarchy, states, and actions.

All text-bearing color pairs require at least 4.5:1 contrast. Meaningful icons, focus indicators, and component boundaries require at least 3:1 against adjacent colors.

## Typography

- Use Material 3 type roles with `FontFamily.Default` and system font scaling.
- Do not bundle a brand or web font.
- Use sentence case for headings, labels, actions, and navigation.
- Use title roles for screen and section hierarchy, body roles for content, and label roles for controls or compact metadata.
- Do not create body text below 12sp.
- Prefer short, concrete labels that remain useful at 200 percent font scale.

## Spacing and size

Use a 4dp base and an 8dp primary rhythm:

| Token | Value | Use |
|---|---:|---|
| `xxs` | 4dp | tight internal separation |
| `xs` | 8dp | related controls and metadata |
| `sm` | 12dp | compact component padding |
| `md` | 16dp | phone gutter and standard section spacing |
| `lg` | 24dp | expanded gutter and section separation |
| `xl` | 32dp | major content separation |
| `xxl` | 48dp | large structural separation |

- Interactive targets are at least 48dp in both dimensions.
- Adjacent interactive targets retain at least 8dp separation where their expanded touch bounds could conflict.
- Text-heavy content uses a maximum readable width of 840dp inside larger panes.
- Spacing may expand with available room but information order must not change by device class.

## Shape and elevation

- Use Material 3 shapes and elevation tokens.
- Reserve elevated containers for temporary, selected, or layered content.
- Prefer tonal separation and dividers for dense operational lists.
- Avoid decorative shadows, glow, blur, glass effects, and nested card grids.

## Information hierarchy

- Place operational state, urgent risk, and the current task before summaries or decoration.
- Each screen or modal surface has at most one visually primary action.
- Secondary actions use tonal, outlined, text, menu, or inline treatments based on frequency and risk.
- Keep resource identity and freshness visible while a user evaluates or changes it.
- Use progressive disclosure for rare and advanced fields, not for safety-critical effects or errors.
- Empty, loading, stale, offline, permission-denied, unsupported, and failed states are designed states, not placeholders.

## Navigation and adaptive layout

- Top-level destinations are Home, Directory, Access, Activity, and More.
- Compact windows use bottom navigation when appropriate. Expanded windows promote the same destinations to a rail or drawer.
- Navigation 3 owns typed back stacks and predictive Back behavior.
- Material 3 Adaptive arranges list, detail, and supporting panes without parallel tablet screens.
- Preserve the selected resource, list query, filters, scroll position, and each top-level stack across window changes.
- Do not place width checks throughout feature composables.

## Lists and data density

- Use compact Material list anatomy while preserving 48dp targets and readable text.
- Large collections use lazy layouts with stable keys and content types.
- Primary identity, status, time, and supporting metadata retain consistent positions.
- Search and high-value filters remain discoverable. Filtering and sorting occur outside item composition.
- Selection is visible through semantics and shape or icon treatment as well as color.
- Do not imply certainty that the server data does not provide.

## Forms

- Labels remain visible when fields contain values.
- Show required, optional, inherited, read-only, and secret states explicitly.
- Put helper and validation text next to the relevant field.
- Preserve non-secret drafts through recreation where practical.
- Never prefill a secret with a server placeholder or retain secret input longer than necessary.
- Validate known local rules before dispatch and preserve actionable server validation.
- Long forms use sections and progressive disclosure with predictable focus order.

## Errors and recovery

- State what failed, what is known, and what the user can do next.
- Keep useful content visible during recoverable refresh failures.
- Provide a redacted technical-detail path without exposing credentials, cookies, tokens, or private server data.
- Distinguish network unavailability, TLS trust, expired sign-in, permission denial, conflicts, unsupported capability, malformed data, and ambiguous mutation outcomes.
- Never describe an ambiguous mutation as success or invite a blind retry before reconciliation.

## Sensitive actions

- Every action uses the central risk classification and policy.
- Confirmations name the target, effect, and relevant uncertainty.
- Destructive actions are not hidden behind tiny or unlabeled controls.
- Screens do not add their own biometric, confirmation, or screenshot-protection rules.
- Disabled and unavailable actions explain why when that helps recovery or permission understanding.

## Motion

- Use platform Material motion only when it explains navigation, hierarchy, or state change.
- Respect reduced-motion preferences and provide a stable final state.
- Avoid entrance choreography, scroll reveals, pulsing live indicators, celebratory effects, and ornamental transitions in frequent workflows.

## Accessibility and input

- Supply accessible names for every meaningful non-text control.
- Use headings, selected, expanded, disabled, error, and live-region semantics intentionally.
- Keep reading and focus order aligned with the visual task order.
- Support TalkBack, keyboard, D-pad, switch access, RTL, and 200 percent font scale.
- Do not steal focus during refresh or announce non-actionable background churn.
- Keep focus indicators visible and predictably restore focus after dialogs and pane changes.

## Content and localization

- Put every user-visible string in Android resources.
- Use locale-aware dates, times, numbers, and relative-time descriptions.
- Do not concatenate translated fragments.
- Use plain language first, with protocol terms only where they improve accuracy.
- Refer to the upstream product as lowercase `authentik`.

## Avoid

- Cyberpunk, terminal, matrix green, OLED-only, or neon styling.
- Hero carousels, marketing dashboards, ornamental charts, and decorative status cards.
- Glass surfaces, heavy gradients, glow, blur, or web landing-page composition.
- WebView authentication, password collection, permanent TLS bypass, or trust-all controls.
- Web animation libraries, web icon packs, bundled web fonts, and emoji as structural icons.
- Page-local theme systems, alternate navigators, parallel tablet screens, and custom component libraries without a current accepted need.
