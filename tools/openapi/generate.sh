#!/usr/bin/env sh
set -eu

tool_directory=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
repository_root=$(CDPATH= cd -- "$tool_directory/../.." && pwd)

# shellcheck disable=SC1091
. "$tool_directory/schema.properties"

schema_channel=${1:-current}
case "$schema_channel" in
    current)
        selected_version=$release
        selected_url=$url
        selected_hash=$sha256
        ;;
    upcoming)
        selected_version=$upcomingVersion
        selected_url=$upcomingUrl
        selected_hash=$upcomingSha256
        ;;
    *)
        echo "Schema channel must be current or upcoming." >&2
        exit 2
        ;;
esac

schema_directory="$repository_root/api-generated/build/openapi/schema"
schema_path="$schema_directory/authentik-$selected_version.yml"
mkdir -p "$schema_directory"
curl --fail --location --silent --show-error "$selected_url" --output "$schema_path"
printf '%s  %s\n' "$selected_hash" "$schema_path" | sha256sum --check --status

"$repository_root/gradlew" :api-generated:generateAuthentikApi \
    "-PauthentikSchemaPath=$schema_path" \
    --no-daemon
