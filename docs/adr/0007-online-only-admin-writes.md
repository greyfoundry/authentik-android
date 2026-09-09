# ADR 0007: Administrative writes are online-only

- Status: Accepted
- Date: 2026-09-08

## Context

Identity state becomes dangerous when stale, and delayed destructive actions are difficult to reason about safely.

## Decision

Never queue authentik administrative mutations for later replay. Cached reads may be available offline with explicit freshness.

## Consequences

Ambiguous mutation outcomes are reconciled with a read instead of blindly retried.
