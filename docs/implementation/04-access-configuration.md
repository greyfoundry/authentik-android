# Access Configuration Implementation Plan

## Goal

Manage applications, provider types, and source types without reproducing raw Swagger forms.

## Deliverables

- handcrafted editors for high-frequency provider/source types
- relationship-aware application/provider UX
- certificate selection metadata
- safe secret-field behavior
- schema-backed Advanced editor for uncommon fields only after handcrafted flows are stable

## Acceptance

Common OAuth2/OIDC, SAML, proxy, LDAP, RADIUS, RAC, SCIM provider workflows and major source types can be created/edited with server validation preserved and no accidental secret overwrite.
