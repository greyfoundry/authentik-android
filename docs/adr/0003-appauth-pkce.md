# ADR 0003: AppAuth Authorization Code with PKCE

- Status: Accepted
- Date: 2026-09-08

## Context

Native public clients cannot safely keep a client secret. AppAuth follows RFC 8252 and avoids WebView credential capture.

Android App Links can only be verified for domains controlled by the app
publisher. An authentik companion can connect to arbitrary self-hosted domains,
so those instance hosts cannot all be declared and verified in one APK. Routing
every sign-in through a hosted callback service would also conflict with the
direct-connect product boundary.

## Decision

Use AppAuth-Android, external browser/Custom Tabs, Authorization Code + PKCE,
OIDC discovery, and refresh tokens where configured.

The initial universal callback is the exact package-scoped URI
`dev.greyfoundry.authentik://oauth2redirect/callback`. The manifest matches the
scheme, host, and path. AppAuth generates and validates authorization state,
nonce, and an S256 PKCE challenge. The callback then enters an unexported app
activity through a one-shot explicit `PendingIntent`.

A verified HTTPS App Link remains preferred when Greyfoundry has a controlled
callback domain, stable release signing fingerprints, and a design that does
not proxy authorization codes or create a required service dependency.

AppAuth owns the OAuth discovery and token-exchange HTTP channel. This is the
narrow protocol-library exception to the generated Retrofit plus project
OkHttp rule. authentik API calls and token revocation continue to use the
project-supplied OkHttp configuration. A future custom-CA implementation must
provide equivalent per-instance trust to both channels.

## Consequences

- Each authentik instance needs the same public-client application setup.
- The custom callback can be claimed by another installed application, so
  AppAuth state validation and PKCE are mandatory rather than optional defense.
- Local logout removes encrypted state before optional remote revocation.
- API-token login is an Advanced fallback only.
