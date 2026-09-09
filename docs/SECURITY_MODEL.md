# Security Model

## Assets

Sensitive assets include:

- OAuth access and refresh tokens;
- ID tokens containing identity claims;
- app-generated encryption keys;
- imported custom CAs and client identities;
- provider secrets or private key material if future features expose them;
- session metadata and IP/geolocation data;
- user/group/role data;
- blueprints/configuration containing secrets;
- administrative mutation authority.

## Trust boundaries

1. Android OS / app sandbox
2. Android Keystore
3. external browser used for OAuth
4. authentik instance
5. network path / reverse proxy / VPN
6. generated OpenAPI code
7. local persistent storage
8. imported files/blueprints/certificates

## Credential storage

Use Android Keystore to create a non-exportable AES-256 key where supported, with AES-GCM for encrypting serialized OAuth state and other credential blobs stored in private app storage.

Do not treat biometrics as encryption by themselves. Biometrics authorize use of selected keys/actions; they do not replace secure storage.

Per-instance credential envelopes must include the intended `InstanceId` and issuer/base-URL binding so a token cannot be silently used against a different instance.

## App lock

Optional app lock:

- biometric/device credential via Android platform APIs;
- configurable lock-after-background interval;
- immediate lock option;
- no custom PIN database unless a future requirement cannot be served safely by platform credentials.

## Administrative action policy

Every mutation declares risk:

| Risk | Example | Default protection |
|---|---|---|
| READ | view user/session | none |
| WRITE | edit display name | contextual confirmation only when ambiguity exists |
| SENSITIVE_WRITE | disable account, terminate session | confirmation; optional/global biometric policy |
| DESTRUCTIVE | delete user/provider/role | explicit typed/strong confirmation where impact warrants; biometric when enabled |
| CREDENTIAL | reveal/rotate/replace secret | biometric; screenshot protection; clipboard restrictions; aggressive redaction |

The policy is centralized and unit-tested.

## Screenshots and recents

Provide a security preference for sensitive-content protection. Credential screens must force protection regardless of global preference. General administrative screens may follow the preference so users can still take useful support screenshots when appropriate.

## Clipboard

- avoid copying secrets by default;
- mark sensitive clipboard content using Android APIs where available;
- clear app-owned sensitive clipboard after a short user-visible interval when practical;
- never read clipboard opportunistically.

## OAuth redirect security

- prefer verified HTTPS App Links;
- bind authorization response to AppAuth-managed `state`/PKCE/nonce;
- validate issuer/configuration;
- do not accept arbitrary untrusted redirect destinations;
- never embed authorization in WebView.

## TLS

- system trust store by default;
- explicit per-instance custom CA import;
- custom trust applies only to the selected instance;
- optional mTLS later;
- no hostname-verification bypass;
- no global trust-all mode;
- no default certificate pinning for self-hosted servers.

## HTTP mutation safety

Retries for GET/HEAD may be conservative and bounded. Non-idempotent mutations are never automatically retried after an ambiguous transport failure unless the API offers an idempotency key or the operation is proven idempotent.

After an ambiguous mutation:

1. report uncertainty;
2. re-read the target resource;
3. reconcile actual server state;
4. allow the user to retry only after state is known or risk is explained.

## Diagnostics

Diagnostic bundles may contain:

- app version/build;
- Android version/device model;
- authentik server version/build hash;
- enabled capabilities;
- request endpoint names and status classes;
- timing and exception categories.

They must not contain:

- Authorization headers;
- cookies;
- access/refresh/ID tokens;
- provider/client secrets;
- passwords;
- private keys;
- full blueprint secret fields;
- personally identifying data unless the user explicitly previews and includes it.

## Rooted/unlocked devices

The app may warn about materially weakened device security, but must not hard-block rooted devices. Root-detection signals are advisory and bypassable.

## Backups

Credential material is excluded from Auto Backup/device transfer. Non-secret settings may be backed up only if instance URLs and metadata are considered acceptable by the privacy policy.

## Security regression tests

At minimum test:

- cross-instance token isolation;
- no token leakage in logs/exceptions;
- App Link redirect matching;
- wrong-issuer rejection;
- refresh concurrency;
- biometric gate policy;
- TLS custom CA scope;
- no trust-all path;
- ambiguous mutation behavior;
- diagnostics redaction;
- screenshot policy on credential screens.
