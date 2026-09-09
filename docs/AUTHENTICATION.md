# Authentication Design

## Recommended path

Use OAuth 2.0 / OpenID Connect Authorization Code with PKCE through AppAuth-Android.

For authentik API access, the upstream OAuth scope is currently `goauthentik.io/api`. Refresh-token use requires `offline_access` and corresponding provider configuration.

## Onboarding modes

### 1. Existing app registration

User enters instance URL and the configured public client ID. The app discovers the OIDC metadata and begins authorization.

### 2. Blueprint-assisted setup

Provide a reviewed blueprint/template that creates the recommended public OAuth application/provider and scopes. The user applies it in authentik, then scans/imports the client configuration.

### 3. Advanced bootstrap

A privileged API token may be supplied temporarily so the app can create/configure its own public OAuth client if the relevant authentik API supports the required operations safely. The bootstrap token is never retained after setup.

This path is optional and must be separately threat-modeled before implementation.

## Redirect URI

Primary: verified HTTPS App Link owned by Greyfoundry/project infrastructure.

Fallback: custom scheme only if required for deployments that cannot use App Links.

The redirect configuration must be explicit in the setup guide and must not depend on a hidden cloud service.

## Token lifecycle

- AppAuth owns protocol state and PKCE.
- Serialized `AuthState` is encrypted before persistence.
- access tokens are refreshed through the configured token endpoint.
- refresh is single-flight per instance.
- logout clears local credentials even when remote end-session/revocation fails.
- remote logout/revocation outcome is shown separately from local credential destruction.

## Browser policy

Use Custom Tabs/system browser. WebView is forbidden for authorization.

## API-token fallback

Long-lived API token login may be offered under Advanced for compatibility and service-account workflows. It must be clearly identified as less preferable for human sessions and stored with the same Keystore-backed protections.
