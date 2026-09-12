# Authentication Implementation Plan

## Goal

Add safe multi-instance OIDC authorization using AppAuth and Keystore-backed persistence.

## Deliverables

- OIDC discovery from configured authentik application issuer
- Authorization Code + PKCE
- exact package-scoped redirect handling, with verified App Links as the future
  upgrade path described by ADR 0003
- encrypted `AuthState` storage per instance
- single-flight token refresh
- local logout and optional remote end-session/revocation
- API-token Advanced fallback design only after threat review
- biometric app-lock policy foundation

## Acceptance

A real authentik test instance can authenticate, survive process restart, refresh tokens without races, log out locally, and never emit token contents in logs.

## Provider convention

The first release uses one fixed authentik OAuth2/OIDC provider contract:

- application slug: `authentik-android`
- public client ID: `dev.greyfoundry.authentik`
- redirect URI: `dev.greyfoundry.authentik://oauth2redirect/callback`
- scopes: `openid profile email offline_access goauthentik.io/api`

Instance-specific client secrets are not accepted or stored. See
[`docs/AUTHENTIK_SETUP.md`](../AUTHENTIK_SETUP.md) for server configuration.
