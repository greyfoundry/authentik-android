# Privacy

Core operation is designed to remain between the Android device and user-configured authentik instances.

## Default data behavior

The app does not require a Greyfoundry account and does not require analytics or a remote crash-reporting service.

The app may locally process identity-administration data returned by the user's authentik instance, including usernames, email addresses, group/role membership, session metadata, IP addresses, security events, application/provider configuration, and other resources the authenticated user is authorized to view.

## Local storage

- OAuth/API credentials are stored only in Keystore-backed encrypted storage.
- Non-secret preferences and instance metadata may use DataStore.
- Structured read caches may use Room when implemented.
- Credential material is excluded from device backup/transfer.

## Network communication

The app communicates with the authentik instances and OAuth endpoints configured by the user. Optional external documentation links or update checks must be explicit. A future optional push integration will require a separate privacy review and documentation before release.

## Diagnostics

Diagnostic export is user-initiated and must be previewable/redacted. Tokens, passwords, cookies, provider secrets, and private keys are never included.
