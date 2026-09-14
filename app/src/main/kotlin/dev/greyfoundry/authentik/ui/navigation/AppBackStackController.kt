package dev.greyfoundry.authentik.ui.navigation

import androidx.navigation3.runtime.NavKey

internal class AppBackStackController(
    private val startRoute: AppRoute,
    private val topLevelRoutes: Set<AppRoute>,
    private val currentTopLevel: () -> AppRoute,
    private val setCurrentTopLevel: (AppRoute) -> Unit,
    private val backStacks: Map<AppRoute, MutableList<NavKey>>,
) {
    init {
        require(startRoute in topLevelRoutes)
        require(backStacks.keys == topLevelRoutes)
        require(backStacks.all { (route, stack) -> stack.firstOrNull() == route })
    }

    val topLevelRoute: AppRoute
        get() = currentTopLevel()

    val currentBackStack: List<NavKey>
        get() = currentStack()

    fun selectTopLevel(route: AppRoute) {
        require(route in topLevelRoutes) { "Not a top-level route: $route" }
        setCurrentTopLevel(route)
    }

    fun navigate(route: AppRoute) {
        if (route in topLevelRoutes) {
            selectTopLevel(route)
            return
        }

        val parent = route.topLevelParent()
        require(parent == topLevelRoute) {
            "Route $route does not belong to the selected destination $topLevelRoute"
        }

        currentStack().apply {
            removeAll { key -> (key as? AppRoute)?.topLevelParent() == parent }
            add(route)
        }
    }

    fun goBack(): Boolean {
        val stack = currentStack()
        if (stack.size > 1) {
            stack.removeLastOrNull()
            return true
        }
        if (topLevelRoute != startRoute) {
            setCurrentTopLevel(startRoute)
            return true
        }
        return false
    }

    private fun currentStack(): MutableList<NavKey> =
        checkNotNull(backStacks[topLevelRoute]) {
            "Missing back stack for $topLevelRoute"
        }
}

internal fun AppRoute.topLevelParent(): AppRoute? =
    when (this) {
        is AppRoute.UserDetail -> AppRoute.Directory
        is AppRoute.EventDetail -> AppRoute.Activity
        else -> null
    }
