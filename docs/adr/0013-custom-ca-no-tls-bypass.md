# ADR 0013: Per-instance custom CA support without TLS bypass

- Status: Accepted
- Date: 2026-09-08

## Context

Self-hosted users legitimately use private PKI, while disabling verification would turn convenience into credential interception.

## Decision

Use system trust by default and allow explicit per-instance custom CA trust; never add trust-all or hostname-verification bypass.

## Consequences

mTLS may be added later using the same per-instance trust boundary.
