# Localization

English is the source language initially, but strings must be resource-backed from the beginning.

Rules:

- no user-visible hard-coded strings in Composables;
- use locale-aware date/time/number formatting;
- support RTL layouts through Compose/Material defaults;
- avoid concatenating translated fragments;
- protocol/resource names such as OAuth2/OIDC may remain technical terms where translation would reduce clarity.
