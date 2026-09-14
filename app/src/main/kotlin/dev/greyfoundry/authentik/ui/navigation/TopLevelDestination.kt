package dev.greyfoundry.authentik.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.greyfoundry.authentik.R

enum class TopLevelDestination(
    val route: AppRoute,
    val stableId: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
) {
    HOME(
        route = AppRoute.Home,
        stableId = "home",
        label = R.string.destination_home,
        icon = R.drawable.ic_lucide_house,
    ),
    DIRECTORY(
        route = AppRoute.Directory,
        stableId = "directory",
        label = R.string.destination_directory,
        icon = R.drawable.ic_lucide_users,
    ),
    ACCESS(
        route = AppRoute.Access,
        stableId = "access",
        label = R.string.destination_access,
        icon = R.drawable.ic_lucide_key_round,
    ),
    ACTIVITY(
        route = AppRoute.Activity,
        stableId = "activity",
        label = R.string.destination_activity,
        icon = R.drawable.ic_lucide_activity,
    ),
    MORE(
        route = AppRoute.More,
        stableId = "more",
        label = R.string.destination_more,
        icon = R.drawable.ic_lucide_ellipsis,
    ),
    ;

    companion object {
        val routes: Set<AppRoute> = entries.mapTo(linkedSetOf()) { it.route }

        fun fromStableId(stableId: String): TopLevelDestination =
            entries.firstOrNull { it.stableId == stableId }
                ?: error("Unknown top-level destination: $stableId")

        fun fromRoute(route: AppRoute): TopLevelDestination =
            entries.firstOrNull { it.route == route }
                ?: error("Not a top-level route: $route")
    }
}
