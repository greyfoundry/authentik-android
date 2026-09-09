# ADR 0005: Manual dependency injection first

- Status: Accepted
- Date: 2026-09-08

## Context

The project starts with two modules and a manageable object graph. Hilt/Koin would add framework surface before there is evidence they reduce complexity.

## Decision

Use constructor injection and a small application container initially.

## Consequences

Adopt a DI framework later only with an ADR backed by measurable pain.
