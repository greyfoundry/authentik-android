package dev.greyfoundry.authentik.compat

import dev.greyfoundry.authentik.domain.model.ServerProfile

interface AuthentikGateway {
    suspend fun serverProfile(): ServerProfile
}
