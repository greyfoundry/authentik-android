# Accessibility

Accessibility is a release requirement, not polish.

## Baseline

- 48dp minimum interactive target where applicable;
- content descriptions for meaningful non-text controls;
- headings/semantics for screen-reader navigation;
- no state conveyed by color alone;
- support large font scales without clipped critical controls;
- correct TalkBack focus order;
- keyboard/D-pad focus for large-screen and external keyboard use;
- predictive back and standard back semantics;
- accessible confirmation dialogs for destructive actions;
- error text associated with the relevant field;
- visible focus indicators.

## Testing

Critical flows require Compose accessibility assertions and periodic manual TalkBack verification:

- onboarding/login;
- instance switching;
- user/session detail;
- destructive confirmation;
- credential reveal/rotation;
- flow/policy editors.
