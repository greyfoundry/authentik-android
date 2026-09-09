# ADR 0012: Gate features by version, capability, and permission

- Status: Accepted
- Date: 2026-09-08

## Context

Version checks alone are insufficient because Enterprise/preview/features and RBAC alter availability.

## Decision

Build a `ServerProfile` and derive feature availability from server version, capability flags, and user authorization.

## Consequences

403 remains an expected authorization result, not a generic server failure.
