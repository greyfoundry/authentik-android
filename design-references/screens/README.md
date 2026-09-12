# Screen Capture Policy

This directory may index or contain only project-owned authentik Companion screen captures and explicitly redistributable assets with a recorded license. Commercial gallery images, upstream sample screenshots, device identifiers, server names, user data, secrets, and local account details are prohibited.

Manual captures support design review but are not automated regression protection.

No screenshot-testing framework is approved today. Compose Preview Screenshot Testing remains experimental and alpha, and Roborazzi is not adopted by default. A future ADR 0015 must establish deterministic fonts, density, locale, theme, device size, Linux CI parity, failure diffs, baseline review ownership, unreviewed-regeneration protection, and storage limits before any framework or golden is added.

Until that gate passes, use Compose previews for authoring and semantic or instrumented Compose tests for behavior and accessibility.
