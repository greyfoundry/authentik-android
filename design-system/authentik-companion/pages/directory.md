# Directory Page Contract

Read `../MASTER.md` and `design-references/patterns/resource-list-detail.md` first. This file contains only Directory-specific constraints.

## Priority

```text
persistent search/filter -> stable user list -> selected user detail -> permission-aware actions
```

- Preserve query, filters, selection, and scroll state while details change or the window adapts.
- A user row presents identity first, then status and the smallest useful metadata set.
- Use stable user identifiers for lazy keys and typed detail routes.
- Compact windows navigate from list to detail. Expanded windows retain the list beside the selected detail.
- Detail sections appear only when relevant: Overview, Relationships, Activity, Access or Permissions, and Advanced.
- Differentiate active, inactive, service-account, external, and unavailable information with text and semantics, not color alone.
- Show actions only when capability and permission allow them. Explain an unavailable high-value action when that helps the user correct access or server compatibility.
- Disabling, deleting, resetting, or changing access always uses the central action policy.
