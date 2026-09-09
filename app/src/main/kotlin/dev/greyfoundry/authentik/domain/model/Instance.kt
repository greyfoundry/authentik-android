package dev.greyfoundry.authentik.domain.model

import java.net.URI
import java.util.UUID

@JvmInline
value class InstanceId(val value: String) {
    init {
        val parsed = runCatching { UUID.fromString(value) }.getOrNull()
        require(parsed?.toString() == value) { "InstanceId must be a canonical lowercase UUID." }
    }

    companion object {
        fun random(): InstanceId = InstanceId(UUID.randomUUID().toString())
    }
}

data class InstanceDraft(
    val baseUrl: String,
    val displayName: String?,
)

data class InstanceProfile(
    val id: InstanceId,
    val baseUrl: String,
    val displayName: String,
) {
    init {
        require(baseUrl == normalizeBaseUrl(baseUrl)) { "Instance baseUrl must be normalized." }
        require(displayName.isNotBlank()) { "Instance displayName must not be blank." }
        require(displayName == displayName.trim()) { "Instance displayName must be trimmed." }
    }

    companion object {
        fun create(
            draft: InstanceDraft,
            id: InstanceId = InstanceId.random(),
        ): InstanceProfile {
            val normalizedBaseUrl = normalizeBaseUrl(draft.baseUrl)
            val host = URI(normalizedBaseUrl).host
                ?: error("Normalized instance URL must have a host.")
            val normalizedDisplayName = draft.displayName
                ?.trim()
                ?.takeIf(String::isNotEmpty)
                ?: host

            return InstanceProfile(
                id = id,
                baseUrl = normalizedBaseUrl,
                displayName = normalizedDisplayName,
            )
        }

        private fun normalizeBaseUrl(value: String): String {
            val uri = runCatching { URI(value.trim()) }
                .getOrElse { throw IllegalArgumentException("Instance baseUrl is not a valid URI.", it) }

            require(!uri.isOpaque) { "Instance baseUrl must be hierarchical." }
            require(uri.scheme.equals("https", ignoreCase = true)) {
                "Instance baseUrl must use HTTPS."
            }
            val host = requireNotNull(uri.host) { "Instance baseUrl must include a host." }
            require(uri.rawUserInfo == null) { "Instance baseUrl must not contain user information." }
            require(uri.rawQuery == null) { "Instance baseUrl must not contain a query." }
            require(uri.rawFragment == null) { "Instance baseUrl must not contain a fragment." }
            require(uri.port == -1 || uri.port in 1..65535) {
                "Instance baseUrl contains an invalid port."
            }

            val normalizedHost = host.lowercase()
            val renderedHost = if (':' in normalizedHost && !normalizedHost.startsWith("[")) {
                "[$normalizedHost]"
            } else {
                normalizedHost
            }
            val renderedPort = if (uri.port == -1 || uri.port == 443) "" else ":${uri.port}"
            val renderedPath = uri.rawPath
                .orEmpty()
                .trimEnd('/')
                .let { path -> if (path.isEmpty()) "/" else "$path/" }

            return "https://$renderedHost$renderedPort$renderedPath"
        }
    }
}
