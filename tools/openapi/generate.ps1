param(
    [ValidateSet("current", "upcoming")]
    [string] $SchemaChannel = "current"
)

$ErrorActionPreference = "Stop"

$toolDirectory = Split-Path -Parent $MyInvocation.MyCommand.Path
$repositoryRoot = Split-Path -Parent (Split-Path -Parent $toolDirectory)
$schema = ConvertFrom-StringData (Get-Content -LiteralPath "$toolDirectory\schema.properties" -Raw)
$selectedVersion = $schema.release
$selectedUrl = $schema.url
$selectedHash = $schema.sha256
if ($SchemaChannel -eq "upcoming") {
    $selectedVersion = $schema.upcomingVersion
    $selectedUrl = $schema.upcomingUrl
    $selectedHash = $schema.upcomingSha256
}
$schemaDirectory = "$repositoryRoot\api-generated\build\openapi\schema"
$schemaPath = "$schemaDirectory\authentik-$selectedVersion.yml"

New-Item -ItemType Directory -Force -Path $schemaDirectory | Out-Null
curl.exe --fail --location --silent --show-error $selectedUrl --output $schemaPath

$actualHash = (Get-FileHash -Algorithm SHA256 -LiteralPath $schemaPath).Hash.ToLowerInvariant()
if ($actualHash -ne $selectedHash) {
    throw "authentik schema checksum mismatch: expected $selectedHash, got $actualHash"
}

& "$repositoryRoot\gradlew.bat" :api-generated:generateAuthentikApi `
    "-PauthentikSchemaPath=$schemaPath" `
    --no-daemon
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}
