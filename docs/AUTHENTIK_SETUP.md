# Connect an authentik Instance

The Android app uses a public OAuth2/OIDC client. Each authentik instance needs
an application and provider with the fixed values below before it can accept a
sign-in from the app.

The app never asks for an authentik password or a client secret. Sign-in opens
the instance in the system browser and returns through an app-specific callback.

## Create the provider

In the authentik Admin interface, create an OAuth2/OpenID provider for the
Android app.

Use these values:

| Field | Value |
| --- | --- |
| Client type | Public |
| Client ID | `dev.greyfoundry.authentik` |
| Redirect URI | `dev.greyfoundry.authentik://oauth2redirect/callback` |
| Redirect matching mode | Strict |
| Signing key | Select an available signing certificate |

Do not create or copy a client secret for this app. Public native clients use
Authorization Code with PKCE instead.

Include the standard `openid`, `profile`, and `email` scope mappings. Add the
`offline_access` mapping if refresh tokens are permitted, and add
`goauthentik.io/api` so the resulting access token can call the authentik API.

Current upstream field descriptions are available in authentik's
[OAuth2/OIDC provider documentation](https://docs.goauthentik.io/add-secure-apps/providers/oauth2/)
and
[provider creation guide](https://docs.goauthentik.io/add-secure-apps/providers/oauth2/create-oauth2-provider/).

## Create the application

Create an authentik application with this slug:

```text
authentik-android
```

Attach the public provider from the previous step. The app discovers its OIDC
configuration at:

```text
https://your-authentik.example/application/o/authentik-android/.well-known/openid-configuration
```

If authentik is served below a path prefix, the discovery path is resolved
below the configured instance base URL.

## Access policy

Bind the application to the users and groups that should be allowed to use the
Android client. authentik remains the authority for sign-in policy, MFA, session
lifetime, and API permissions.

The requested API scope does not grant permissions by itself. The authenticated
user can only perform operations allowed by authentik's own authorization model.
