# ADR 0011: Central risk classification for mutations

- Status: Accepted
- Date: 2026-09-08

## Context

Screen-specific ad-hoc confirmation logic drifts and eventually leaves a dangerous action under-protected.

## Decision

Every administrative mutation declares a risk class and uses central policy for confirmation/biometric/screenshot rules.

## Consequences

The policy is domain logic and must be unit-tested.
