# Roadmap

This roadmap describes capability generations, not artificial deadlines. Releases may combine or split generations based on upstream authentik changes and implementation evidence.

## G0 - Foundation

- Android project scaffold and version catalog
- Compose/Material 3 design system
- Navigation 3 and Material 3 Adaptive shell
- generated authentik OpenAPI transport
- handwritten compatibility/domain gateway
- server profile: version, build hash, capabilities, permissions
- multi-instance model
- generated Retrofit/OkHttp client factory
- redacted diagnostics
- Keystore-backed secure storage
- AppAuth OIDC bootstrap
- App Link redirect handling
- test harness and CI

## G1 - Operations

- Home/instance overview
- server version and outpost mismatch state
- security/activity event feed
- event filtering and AKQL support where available
- authenticated sessions
- terminate-session action
- user lookup and enable/disable action
- applications and outposts read views
- freshness indicators and pull-to-refresh

## G2 - Directory

- users: complete lifecycle
- groups and nested groups
- service accounts
- agent accounts where supported
- invitations
- roles
- global permissions
- object permissions
- application entitlements
- permission graph visualization

## G3 - Access

- applications create/edit/delete
- OAuth2/OIDC providers
- SAML providers
- proxy providers
- LDAP providers
- RADIUS providers
- RAC providers
- SCIM providers
- backchannel providers
- sources: OAuth/OIDC, SAML, LDAP, SCIM, Kerberos, supported social sources
- certificates used by providers
- launch and access-test tooling

## G4 - Credentials and self-service

- user-facing application dashboard
- account/profile settings
- own sessions
- credentials inventory
- TOTP/WebAuthn/authenticator management where upstream APIs permit
- recovery flows and invitation handling where safe
- service-account tokens/app passwords with credential-grade protections

## G5 - Policy engine

- policy inventory
- bindings
- execution/evaluation detail
- expression policy editing with validation
- password policy
- reputation/event-aware policy surfaces where available
- relationship visualization

## G6 - Flow engine

- flows
- stages
- stage bindings
- policy bindings
- adaptive visual flow editor
- reusable stage editors
- execution/test tooling where upstream supports it

## G7 - Infrastructure

- outposts create/edit/delete
- service connections
- integrations
- endpoints/connectors/agents
- certificates and keys metadata
- outpost health/version mismatches
- per-instance network diagnostics
- custom CA and mTLS client identity support

## G8 - Configuration

- brands
- tenants
- property mappings
- transports
- notification rules/transports
- system/admin settings
- files/media metadata where safe
- task/system status surfaces

## G9 - Config as code

- blueprint inventory
- import/export
- validation
- dry-run where supported
- structured diff
- atomic apply
- trusted-source warnings
- configuration comparison across instances
- drift detection

## G10 - Access requests and modern authentik features

- access requests (2026.8+)
- request rules
- review/approve/deny workflows
- time-limited grants
- account lockdown where API/licensing permits
- conditional-access visibility where available
- new capabilities discovered through schema diffing

## G11 - Android integration

- home-screen widgets
- deep links into users/events/sessions/resources
- Quick Settings read-only/security shortcuts
- safe share/import flows
- optional Wear OS read-only critical surfaces
- notification categories and privacy controls

## G12 - Authenticator

- device enrollment foundation
- challenge retrieval
- native approval only if upstream protocol/support is robust enough
- number matching / context display
- optional self-hosted push-delivery integration
- no mandatory Greyfoundry relay

## G13 - Power tools

- global search across resource classes
- command palette that resolves into normal confirmation flows
- schema-backed advanced editor for low-frequency resources
- diagnostics bundle with aggressive redaction
- cross-instance comparison
- import/export of safe app configuration

## Continuous work

Every generation also includes:

- accessibility
- localization
- API compatibility coverage
- real-server contract testing
- security review
- performance profiling
- dependency maintenance
- release reproducibility
- documentation updates
