# Security Policy

`authentik Companion` is an identity-administration client. Security bugs can affect account access, active sessions, OAuth credentials, provider configuration, and other high-impact resources. Treat reports accordingly.

## Reporting a vulnerability

Do **not** open a public issue for suspected vulnerabilities.

Until a dedicated security mailbox is published, use GitHub private vulnerability reporting on the repository. Maintainers should enable **Security → Private vulnerability reporting** before the first public release.

A useful report includes:

- affected app version/commit;
- Android version/device class;
- authentik version;
- attack prerequisites;
- reproduction steps;
- expected vs actual behavior;
- whether credentials or server-side changes are involved;
- suggested mitigation, if known.

Do not include real access tokens, refresh tokens, passwords, private keys, provider secrets, cookies, or production personal data.

## Supported versions

Before 1.0, only the latest released version receives security fixes. After 1.0, support policy will be documented in `docs/RELEASES.md` and will retain at least the latest stable release line.

## Security invariants

The following are project-level invariants:

1. The app never collects authentik passwords.
2. OAuth authorization uses a system browser/Custom Tab, not WebView.
3. Public-client OAuth uses Authorization Code + PKCE.
4. Long-lived local encryption keys are non-exportable Android Keystore keys where platform support permits.
5. Tokens, cookies, credentials, and secret fields never appear in logs.
6. Administrative writes are never queued offline.
7. TLS verification cannot be globally disabled.
8. Custom CAs are explicit and scoped per instance.
9. Cross-instance credentials and caches are logically isolated.
10. Destructive and credential operations use the central risk policy.
11. Backup configuration must not export credential material.
12. A 401 triggers re-auth/refresh logic; a 403 is treated as authorization denial, not retried as a different privilege path.
13. An ambiguous network failure after a mutation is **not** automatically replayed unless idempotency can be proven.
14. Generated OpenAPI code is not trusted as a security boundary; domain validation remains explicit.

## Threat model summary

Primary threats include:

- stolen/unlocked device;
- malicious app attempting to read clipboard/screenshots/logs;
- compromised or hostile network;
- rogue/self-signed CA accidentally trusted too broadly;
- token theft from storage or diagnostics;
- OAuth redirect hijacking;
- cross-instance token confusion;
- replay of destructive requests after uncertain network failure;
- compromised authentik instance returning malformed or adversarial data;
- low-privilege authentik account receiving UI for actions it cannot perform;
- upstream API drift causing the app to invoke the wrong operation;
- malicious blueprint/config import;
- supply-chain compromise in Android dependencies or generated code.

Full controls are in `docs/SECURITY_MODEL.md`.

## Dependency and supply-chain policy

- Pin dependency versions.
- Prefer stable official libraries.
- Run dependency vulnerability scanning in CI.
- Generate an SBOM for releases.
- Sign release artifacts.
- Preserve reproducible-build goals where practical.
- Review OpenAPI generator upgrades separately from generated schema changes.

## Disclosure handling

Security fixes should receive a dedicated advisory, affected-version range, mitigation, and patched release. Do not publish exploit details before a fix is available unless coordinated disclosure requirements demand it.
