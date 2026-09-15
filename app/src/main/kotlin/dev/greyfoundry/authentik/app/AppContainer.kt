package dev.greyfoundry.authentik.app

import dev.greyfoundry.authentik.domain.repository.AuthSessionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceConnectionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceRepository

interface AppContainer {
    val instanceRepository: InstanceRepository
    val instanceConnectionRepository: InstanceConnectionRepository
    val authSessionRepository: AuthSessionRepository
}
