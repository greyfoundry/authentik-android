# Home Page Contract

Read `../MASTER.md` and `design-references/patterns/operations-activity.md` first. This file contains only Home-specific constraints.

## Priority

```text
instance health -> urgent security events -> session/user summaries -> outpost warnings -> recent activity
```

- Lead with the selected instance, compatibility state, freshness, and health.
- Urgent events use severity text and an icon, include time and source, and lead to evidence or containment where permission allows.
- Keep summaries compact and actionable. They do not become decorative metric cards.
- Surface outpost warnings before routine activity.
- Keep the last trustworthy content visible during refresh and mark it stale or offline.
- Do not add a welcome hero, carousel, promotional message, ornamental chart, or celebratory state.
- A user without administrative capabilities receives useful self-service content rather than empty admin containers.
