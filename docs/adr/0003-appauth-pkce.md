# ADR 0003: AppAuth Authorization Code with PKCE

- Status: Accepted
- Date: 2026-09-08

## Context

Native public clients cannot safely keep a client secret. AppAuth follows RFC 8252 and avoids WebView credential capture.

## Decision

Use AppAuth-Android, external browser/Custom Tabs, Authorization Code + PKCE, OIDC discovery, and refresh tokens where configured.

## Consequences

App Link redirect is preferred; API-token login is an Advanced fallback only.
