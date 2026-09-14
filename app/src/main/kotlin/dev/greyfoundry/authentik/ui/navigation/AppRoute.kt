package dev.greyfoundry.authentik.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute : NavKey {
    @Serializable
    data object Home : AppRoute

    @Serializable
    data object Directory : AppRoute

    @Serializable
    data object Access : AppRoute

    @Serializable
    data object Activity : AppRoute

    @Serializable
    data object More : AppRoute

    @Serializable
    data class UserDetail(
        val userId: String,
    ) : AppRoute

    @Serializable
    data class EventDetail(
        val eventId: String,
    ) : AppRoute
}
