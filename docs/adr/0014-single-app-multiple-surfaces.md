# ADR 0014: Single app for admin, user, and future authenticator surfaces

- Status: Accepted
- Date: 2026-09-08

## Context

Separate APKs would duplicate auth, networking, instance management, security, and design system logic.

## Decision

Keep one Android application whose visible features are permission/capability-driven.

## Consequences

If authenticator isolation later needs a separate process/module for security, decide it with a new ADR rather than splitting the product preemptively.
