package dev.greyfoundry.authentik.domain.repository

import dev.greyfoundry.authentik.domain.model.AccessToken
import dev.greyfoundry.authentik.domain.model.AuthSessionState
import dev.greyfoundry.authentik.domain.model.InstanceId
import kotlinx.coroutines.flow.StateFlow

interface AuthSessionRepository {
    val session: StateFlow<AuthSessionState>

    suspend fun authorize(instanceId: InstanceId)

    suspend fun logout(instanceId: InstanceId, revokeRemote: Boolean)

    suspend fun accessToken(instanceId: InstanceId): AccessToken
}
