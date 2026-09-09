# Directory and RBAC Implementation Plan

## Goal

Provide complete native management of users, groups, service/agent accounts, roles, permissions, invitations, and entitlements.

## Deliverables

- create/edit/deactivate/delete user flows
- nested groups and membership management
- service-account-specific UX
- agent-account support where server version permits
- invitations
- roles and permissions
- object-permission assignment
- permission relationship graph
- application entitlements

## Acceptance

Every write is permission-aware, risk-classified, contract-tested, and resilient to stale resource state.
