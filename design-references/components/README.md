# Component Reference Policy

This directory indexes project-owned authentik Companion previews and component-state coverage. Each future entry should list the component, supported states, light and dark behavior, font-scale checks, interaction semantics, and the production source path.

Only project-owned output or explicitly redistributable assets with a recorded license may be committed. Upstream sample images and commercial gallery material remain outside the repository.

Compose previews are authoring tools. They do not replace semantic, interaction, and accessibility tests. Compose Preview Screenshot Testing is currently experimental and alpha, so it is not installed. Roborazzi is not adopted merely because a reference project uses it.

Before any screenshot dependency is accepted, ADR 0015 must select and pin one framework and define fixed fonts, density, locale, theme, device size, Linux rendering parity, failure diffs, baseline review ownership, protection against unreviewed regeneration, and storage-cost limits. Approved goldens must live in the applicable test source set and be indexed here.
