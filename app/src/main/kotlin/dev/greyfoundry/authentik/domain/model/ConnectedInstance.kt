package dev.greyfoundry.authentik.domain.model

data class ConnectedInstance(
    val instance: InstanceProfile,
    val server: ServerProfile,
)
