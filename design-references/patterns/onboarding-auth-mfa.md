# Onboarding, Authentication, and MFA

## Pattern: Instance-first external authentication

- Problem: Connect a self-hosted authentik instance, transfer control to its authorization flow, and recover clearly from discovery, browser, callback, or MFA failure.
- Project constraints: AppAuth owns Authorization Code with PKCE; authorization uses an external browser; the app never collects authentik passwords; credentials use Keystore-backed encryption; capability and issuer checks occur before sign-in; the callback must match the registered redirect exactly.
- Sources reviewed: [authentik OAuth2 provider documentation](https://docs.goauthentik.io/add-secure-apps/providers/oauth2/), [AppAuth-Android](https://github.com/openid/AppAuth-Android), [Material accessibility](https://developer.android.com/develop/ui/compose/accessibility), locked `compose-samples/Jetcaster/mobile/src/main/java/com/example/jetcaster/ui/JetcasterApp.kt`, and the Tier 3 access boundaries in `../sources.md`.
- Observed pattern: Trust improves when instance selection, connection verification, browser handoff, return progress, and recoverable errors are distinct states with one clear next action. External authorization should remain visibly separate from local setup.
- Adopt: Show the normalized instance identity before sign-in, explain that authentication continues in the browser, retain non-secret setup state, announce progress and errors, and provide retry or instance-edit actions without exposing protocol details by default.
- Reject: Embedded WebViews, password fields, silent redirects, copied gallery language or visuals, success inferred only from browser dismissal, and an MFA UI that impersonates the server-owned flow.
- Compose translation: Hoist immutable setup state from the screen ViewModel, collect it with `collectAsStateWithLifecycle`, render state-specific Material 3 content, use explicit event callbacks, and keep the AppAuth launch and callback boundary outside reusable child composables.
- Accessibility checks: Visible labels, 48dp targets, focus moved to the new status heading, progress and failure announcements, no color-only state, large-text reflow, clear browser-return instructions, and TalkBack-readable instance identity.
- Validation: Unit tests cover the state reducer and redacted errors; Compose tests cover loading, failure, retry, and browser-handoff semantics; instrumented tests cover callback routing, process recreation, and no embedded password or WebView path.
