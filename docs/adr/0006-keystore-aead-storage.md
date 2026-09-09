# ADR 0006: Keystore-backed AEAD credential storage

- Status: Accepted
- Date: 2026-09-08

## Context

OAuth state contains long-lived authority and must not be stored in plaintext. Deprecated AndroidX encrypted-preference wrappers should not define the foundation.

## Decision

Encrypt persistent credential blobs with an AES-GCM key managed by Android Keystore.

## Consequences

Biometric gating may authorize selected key use but does not replace encryption.
