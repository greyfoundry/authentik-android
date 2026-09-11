package dev.greyfoundry.authentik.compat

import dev.greyfoundry.authentik.domain.model.AuthenticationExpired
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.Conflict
import dev.greyfoundry.authentik.domain.model.MalformedServerResponse
import dev.greyfoundry.authentik.domain.model.NetworkUnavailable
import dev.greyfoundry.authentik.domain.model.NotFound
import dev.greyfoundry.authentik.domain.model.PermissionDenied
import dev.greyfoundry.authentik.domain.model.RateLimited
import dev.greyfoundry.authentik.domain.model.ServerCapability
import dev.greyfoundry.authentik.domain.model.ServerEdition
import dev.greyfoundry.authentik.domain.model.ServerError
import dev.greyfoundry.authentik.domain.model.ServerProfile
import dev.greyfoundry.authentik.domain.model.TlsFailure
import dev.greyfoundry.authentik.generated.model.Config
import dev.greyfoundry.authentik.generated.model.Version
import dev.greyfoundry.authentik.network.AuthentikApiClient
import java.io.IOException
import javax.net.ssl.SSLException
import kotlinx.serialization.SerializationException
import retrofit2.Response

class DefaultAuthentikGateway(
    private val client: AuthentikApiClient,
) : AuthentikGateway {
    override suspend fun serverProfile(): ServerProfile {
        val version = request { client.adminApi.adminVersionRetrieve() }
        val config = request { client.rootApi.rootConfigRetrieve() }
        return version.toServerProfile(config)
    }

    private suspend fun <T> request(call: suspend () -> Response<T>): T {
        val response = try {
            call()
        } catch (failure: SSLException) {
            throw TlsFailure(failure)
        } catch (failure: IOException) {
            throw NetworkUnavailable(failure)
        } catch (failure: SerializationException) {
            throw MalformedServerResponse(failure)
        }

        if (!response.isSuccessful) {
            response.errorBody()?.close()
            throw when (response.code()) {
                401 -> AuthenticationExpired()
                403 -> PermissionDenied()
                404 -> NotFound()
                409 -> Conflict()
                429 -> RateLimited()
                else -> ServerError(response.code())
            }
        }
        return response.body() ?: throw MalformedServerResponse()
    }

    private fun Version.toServerProfile(config: Config): ServerProfile {
        val stableCapabilities = config.capabilities
            .map(String::trim)
            .filter(String::isNotEmpty)
            .map(::ServerCapability)
            .toSet()
        return ServerProfile(
            versionCurrent = versionCurrent,
            versionLatest = versionLatest
                .trim()
                .takeIf { versionLatestValid && it.isNotEmpty() },
            buildHash = buildHash.trim().ifEmpty { null },
            outdated = outdated,
            outpostOutdated = outpostOutdated,
            capabilities = stableCapabilities,
            edition = if (ENTERPRISE_CAPABILITY in stableCapabilities) {
                ServerEdition.ENTERPRISE
            } else {
                ServerEdition.COMMUNITY
            },
            compatibilityLevel = compatibilityLevel(versionCurrent),
        )
    }

    private fun compatibilityLevel(version: String): CompatibilityLevel {
        val match = VERSION_PREFIX.find(version) ?: return CompatibilityLevel.UNKNOWN
        val release = match.groupValues[1].toInt() to match.groupValues[2].toInt()
        return when (release) {
            in SUPPORTED_RELEASES -> CompatibilityLevel.SUPPORTED
            DEGRADED_RELEASE -> CompatibilityLevel.DEGRADED
            else -> if (release.isOlderThan(DEGRADED_RELEASE)) {
                CompatibilityLevel.UNSUPPORTED
            } else {
                CompatibilityLevel.UNKNOWN
            }
        }
    }

    private fun Pair<Int, Int>.isOlderThan(other: Pair<Int, Int>): Boolean =
        first < other.first || (first == other.first && second < other.second)

    private companion object {
        val ENTERPRISE_CAPABILITY = ServerCapability("is_enterprise")
        val VERSION_PREFIX = Regex("^(\\d{4})\\.(\\d+)")
        val SUPPORTED_RELEASES = setOf(2026 to 5, 2026 to 8)
        val DEGRADED_RELEASE = 2026 to 2
    }
}
