package dev.greyfoundry.authentik.domain.model

data class ServerProfile(
    val versionCurrent: String,
    val versionLatest: String?,
    val buildHash: String?,
    val outdated: Boolean,
    val outpostOutdated: Boolean,
    val capabilities: Set<ServerCapability> = emptySet(),
    val edition: ServerEdition = ServerEdition.UNKNOWN,
    val compatibilityLevel: CompatibilityLevel = CompatibilityLevel.UNKNOWN,
    val supportedFeatures: Set<SupportedFeature> = emptySet(),
    val currentUserPermissions: Set<ServerPermission> = emptySet(),
)

@JvmInline
value class ServerCapability(val value: String) {
    init {
        require(value.isNotBlank()) { "ServerCapability must not be blank." }
    }
}

@JvmInline
value class SupportedFeature(val value: String) {
    init {
        require(value.isNotBlank()) { "SupportedFeature must not be blank." }
    }
}

@JvmInline
value class ServerPermission(val value: String) {
    init {
        require(value.isNotBlank()) { "ServerPermission must not be blank." }
    }
}

enum class ServerEdition {
    COMMUNITY,
    ENTERPRISE,
    UNKNOWN,
}

enum class CompatibilityLevel {
    SUPPORTED,
    DEGRADED,
    UNSUPPORTED,
    UNKNOWN,
}
