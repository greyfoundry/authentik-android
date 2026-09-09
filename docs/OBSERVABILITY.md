# Diagnostics and Observability

The app should be diagnosable without becoming a telemetry product.

## Default stance

- no analytics SDK;
- no mandatory remote crash reporting;
- structured local logs with strict redaction;
- user-controlled export of a redacted diagnostics bundle.

## Log categories

- app lifecycle
- instance connection
- OAuth state transitions without token contents
- API endpoint name/status class/timing
- compatibility-rule activation
- cache freshness
- mutation result class

Never log full request/response bodies for credential-bearing or user-sensitive endpoints by default.

## Optional future telemetry

Any remote telemetry must be opt-in, documented, minimal, and separable from core functionality. F-Droid builds must remain possible without proprietary telemetry dependencies.
