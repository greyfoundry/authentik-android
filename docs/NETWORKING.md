# Networking and Self-Hosted Connectivity

## Client

Retrofit generated service/client code with one project-supplied OkHttp client is the only general HTTP stack.

Per-instance `OkHttpClient`/generated API configuration should be created by a small factory so credentials, trust settings, headers, and diagnostics cannot leak across instances.

## Per-instance connection profile

Future-capable model:

```text
ConnectionProfile
- baseUrl
- requestTimeout
- customHeaders
- customCaReferences
- clientIdentityReference
- proxyMode (only if a real requirement appears)
```

## Custom headers

Support per-instance headers for reverse proxies and access gateways. Secret header values must be encrypted like credentials and redacted from logs.

Headers that can alter routing/authentication require an explicit warning and must not be exported in plaintext.

## Redirects

Cross-origin redirects must not forward Authorization or sensitive custom headers automatically. Test this behavior.

## TLS

- system trust by default;
- optional per-instance custom CA bundle;
- optional mTLS client certificate later;
- hostname validation remains enabled;
- no trust-all switch;
- no default pinning.

## Timeouts

Set finite connect/request/socket timeouts. Long-running log/stream endpoints may use separate profiles. Infinite timeouts are not the default.

## Retry policy

- bounded retry for safe/idempotent reads only;
- respect `Retry-After` where meaningful;
- no blind mutation retry;
- surface ambiguous mutation outcomes.

## Offline

Network unavailability is a first-class UI state. Cached reads may remain visible with clear freshness labels. Writes remain disabled until connectivity returns.
