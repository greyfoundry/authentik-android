package dev.greyfoundry.authentik.domain.repository

import dev.greyfoundry.authentik.domain.model.ConnectedInstance

interface InstanceConnectionRepository {
    suspend fun connect(baseUrl: String): ConnectedInstance
}
