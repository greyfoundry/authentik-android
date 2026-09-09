# ADR 0010: No required Greyfoundry backend

- Status: Accepted
- Date: 2026-09-08

## Context

A mandatory cloud service would weaken self-hosting, privacy, F-Droid compatibility, and reliability.

## Decision

Core functionality communicates directly between Android and the user-selected authentik instance.

## Consequences

A future optional push relay/integration may be added only for a feature that technically requires it.
