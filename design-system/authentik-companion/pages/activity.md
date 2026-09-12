# Activity Page Contract

Read `../MASTER.md` and `design-references/patterns/operations-activity.md` first. This file contains only Activity-specific constraints.

## Priority

```text
severity/time/source filters -> reverse-chronological events -> selected event evidence -> related resource links
```

- Keep severity, time range, source, and active filter state visible and accessible.
- Present events in reverse chronological order with stable identifiers.
- A row exposes severity text and icon, event identity, source, and locale-aware time without fabricating precision.
- Preserve filters, selection, and scroll position across list-detail adaptation.
- Event detail separates server evidence from app interpretation and exposes redacted technical details only on demand.
- Related users, sessions, applications, outposts, and other resources use typed in-app destinations when supported.
- Refresh retains trustworthy events and marks freshness. New background events do not steal focus.
- Containment actions use the central policy and reconcile ambiguous outcomes before allowing another mutation.
