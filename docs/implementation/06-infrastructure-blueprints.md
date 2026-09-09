# Infrastructure and Blueprints Implementation Plan

## Goal

Cover outposts, service connections, certificates, agents/endpoints, brands/tenants, and config-as-code workflows.

## Deliverables

- outpost CRUD and health
- integration/service-connection management
- certificate/key metadata and credential protections
- brand/tenant/configuration surfaces
- blueprint import/export/validate/dry-run/apply
- instance diff/drift comparison

## Acceptance

Blueprint apply uses upstream atomic behavior, imports are clearly marked untrusted until reviewed, and cross-instance comparison never performs writes implicitly.
