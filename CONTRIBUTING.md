# Contributing

Contributions are welcome. This project values small, testable changes over giant rewrites.

## Before coding

Read `docs/PRODUCT.md`, `docs/ARCHITECTURE.md`, relevant `docs/adr/` decisions, and the subsystem implementation document. If your change modifies an architectural decision, write or amend an ADR before implementation.

## Pull requests

A good PR:

- has one coherent purpose;
- includes tests for meaningful behavior;
- avoids unrelated formatting/refactors;
- updates docs when behavior or architecture changes;
- does not expose real credentials or personal data in fixtures/screenshots;
- notes authentik versions exercised when API behavior changes;
- includes UI evidence for visual changes where practical.

## Development style

- Kotlin-first, Compose-first.
- Prefer immutable state and explicit events.
- Keep platform/framework code at boundaries.
- Avoid generic abstractions until at least two real consumers justify them.
- Keep generated API files out of manual review except when regeneration is the purpose of the change.
- Use ASCII punctuation in tracked files. In particular, use a plain hyphen instead of en or em dashes.

## Security-sensitive changes

Changes involving OAuth, token storage, TLS, biometrics, provider secrets, destructive actions, custom CAs, mTLS, backup/restore, or deep links require explicit security review against `docs/SECURITY_MODEL.md`.
