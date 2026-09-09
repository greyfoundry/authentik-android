# Authentication Implementation Plan

## Goal

Add safe multi-instance OIDC authorization using AppAuth and Keystore-backed persistence.

## Deliverables

- OIDC discovery from configured authentik application issuer
- Authorization Code + PKCE
- verified App Link redirect handling
- encrypted `AuthState` storage per instance
- single-flight token refresh
- local logout and optional remote end-session/revocation
- API-token Advanced fallback design only after threat review
- biometric app-lock policy foundation

## Acceptance

A real authentik test instance can authenticate, survive process restart, refresh tokens without races, log out locally, and never emit token contents in logs.
