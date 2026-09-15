package dev.greyfoundry.authentik.domain.repository

import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import kotlinx.coroutines.flow.StateFlow

interface InstanceRepository {
    val activeInstance: StateFlow<InstanceProfile?>
    val instances: StateFlow<List<InstanceProfile>>

    suspend fun get(instanceId: InstanceId): InstanceProfile?

    suspend fun getByBaseUrl(baseUrl: String): InstanceProfile?

    suspend fun add(draft: InstanceDraft): InstanceProfile

    suspend fun update(profile: InstanceProfile)

    suspend fun remove(instanceId: InstanceId)

    suspend fun setActive(instanceId: InstanceId)
}
