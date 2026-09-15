package dev.greyfoundry.authentik.data.instance

import dev.greyfoundry.authentik.compat.AuthentikGateway
import dev.greyfoundry.authentik.compat.DefaultAuthentikGateway
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.ConnectedInstance
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.repository.InstanceConnectionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import dev.greyfoundry.authentik.network.ApiClientFactory

class DefaultInstanceConnectionRepository internal constructor(
    private val instanceRepository: InstanceRepository,
    private val gatewayFactory: (InstanceProfile) -> AuthentikGateway,
) : InstanceConnectionRepository {
    constructor(
        instanceRepository: InstanceRepository,
        apiClientFactory: ApiClientFactory = ApiClientFactory(),
    ) : this(
        instanceRepository = instanceRepository,
        gatewayFactory = { instance ->
            DefaultAuthentikGateway(apiClientFactory.create(instance))
        },
    )

    override suspend fun connect(baseUrl: String): ConnectedInstance {
        val candidate = InstanceProfile.create(
            InstanceDraft(baseUrl = baseUrl, displayName = null),
        )
        val server = gatewayFactory(candidate).serverProfile()
        if (server.compatibilityLevel == CompatibilityLevel.UNSUPPORTED) {
            return ConnectedInstance(candidate, server)
        }

        val persisted = instanceRepository.getByBaseUrl(candidate.baseUrl)
            ?: instanceRepository.add(
                InstanceDraft(
                    baseUrl = candidate.baseUrl,
                    displayName = candidate.displayName,
                ),
            )
        return ConnectedInstance(persisted, server)
    }
}
