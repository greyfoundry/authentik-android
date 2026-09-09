# Operations Implementation Plan

## Goal

Deliver the first complete operational experience.

## Deliverables

- server profile/version capability view
- Home summary
- Activity/events list/detail/filter
- Users list/search/detail
- Sessions list/detail
- Applications read view
- Outposts read view
- terminate session action
- enable/disable user action
- action-risk confirmation policy
- pull-to-refresh and freshness indicators

## Acceptance

All read and mutation paths pass MockWebServer tests and the supported authentik contract matrix. Ambiguous mutation failures reconcile by re-reading server state.
