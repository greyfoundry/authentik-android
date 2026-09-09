# Product Specification

## Product statement

A native Android client for authentik that makes identity operations, administration, self-service, and eventually device authentication safe and efficient on phones, tablets, and foldables.

## Primary users

1. self-hosters running authentik for personal/homelab infrastructure;
2. administrators responsible for users, sessions, providers, applications, flows, policies, and outposts;
3. on-call operators who need rapid containment and inspection from a phone;
4. ordinary authentik users who want a native application dashboard and account/security controls.

## Jobs to be done

- “I received a security alert. Show me what happened and let me contain it safely.”
- “I need to disable a user or kill a session without opening a laptop.”
- “Show me whether my authentik instance and outposts are healthy and current.”
- “Let me inspect and manage identity configuration with a UI designed for Android.”
- “Let me access my applications, sessions, and credentials as a normal user.”
- “Let me operate multiple authentik instances without mixing credentials or state.”

## Product modes

The UI is permission-driven rather than split into separate apps.

### User mode

- application dashboard
- profile/account
- own sessions
- own credentials/authenticators
- self-service access requests where supported

### Admin mode

- overview and activity
- directory
- RBAC
- applications/providers/sources
- flows/policies/stages
- outposts/infrastructure
- configuration/blueprints
- access-request review

### Authenticator mode

Future capability. Must not be invented as a proprietary protocol if authentik upstream does not provide a sound integration contract.

## Navigation

Phone top-level destinations:

- Home
- Directory
- Access
- Activity
- More

Adaptive layouts may promote this to rail/drawer navigation. Detail-heavy resources use Material 3 Adaptive list-detail/supporting-pane patterns.

## Product quality bar

The app should feel like an Android application, not a browser wrapper:

- fast cold/warm navigation;
- useful density without tiny targets;
- predictive back;
- edge-to-edge;
- proper dark/light theming;
- dynamic color optional, not mandatory;
- accessible labels and scalable text;
- clear stale/offline state;
- error messages with actionable causes;
- confirmations proportional to risk;
- consistent resource detail layouts;
- no celebratory animation for administrative actions.

## Success criteria

The project is succeeding when an authentik administrator can perform common on-the-go tasks faster and more safely in the app than through the mobile web Admin UI, without sacrificing compatibility with self-hosted networking setups.
