# Onboarding Page Contract

Read `../MASTER.md` and `design-references/patterns/onboarding-auth-mfa.md` first. This file contains only onboarding-specific constraints.

## Priority

```text
instance URL -> connection result -> OIDC explanation -> external-browser sign-in
```

- Begin with one labeled instance URL field and one primary Continue action.
- Explain HTTPS expectations and custom CA handling without offering TLS bypass.
- Show the normalized instance identity and verified server result before sign-in.
- Treat validation, discovery, network, TLS, unsupported-version, and malformed-response failures as distinct recoverable states.
- Explain that sign-in continues in the browser and returns to the app. Never render a password or server MFA field.
- Keep the instance identity visible during browser launch and callback processing.
- Persist only non-secret draft and progress state. Clear transient authorization state after completion or cancellation.
- Make Edit instance, Retry, Continue in browser, and Cancel unambiguous. Only the current forward action is visually primary.
