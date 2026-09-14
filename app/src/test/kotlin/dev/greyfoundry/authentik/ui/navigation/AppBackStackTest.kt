package dev.greyfoundry.authentik.ui.navigation

import androidx.navigation3.runtime.NavKey
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppBackStackTest {
    @Test
    fun `starts at home with one root per top-level destination`() {
        val fixture = NavigationFixture()

        assertEquals(AppRoute.Home, fixture.controller.topLevelRoute)
        TopLevelDestination.entries.forEach { destination ->
            assertEquals(
                listOf(destination.route),
                fixture.stacks.getValue(destination.route),
            )
        }
    }

    @Test
    fun `each top-level destination can be selected without resetting its stack`() {
        val fixture = NavigationFixture()

        TopLevelDestination.entries.forEach { destination ->
            fixture.controller.selectTopLevel(destination.route)

            assertEquals(destination.route, fixture.controller.topLevelRoute)
            assertEquals(listOf(destination.route), fixture.controller.currentBackStack)
        }
    }

    @Test
    fun `switching top-level destinations preserves each history`() {
        val fixture = NavigationFixture()

        fixture.controller.selectTopLevel(AppRoute.Directory)
        fixture.controller.navigate(AppRoute.UserDetail("user-1"))
        fixture.controller.selectTopLevel(AppRoute.Activity)
        fixture.controller.navigate(AppRoute.EventDetail("event-1"))
        fixture.controller.selectTopLevel(AppRoute.Directory)

        assertEquals(AppRoute.Directory, fixture.controller.topLevelRoute)
        assertEquals(
            listOf(AppRoute.Directory, AppRoute.UserDetail("user-1")),
            fixture.controller.currentBackStack,
        )
    }

    @Test
    fun `opening another detail replaces the current detail`() {
        val fixture = NavigationFixture()
        fixture.controller.selectTopLevel(AppRoute.Directory)

        fixture.controller.navigate(AppRoute.UserDetail("user-1"))
        fixture.controller.navigate(AppRoute.UserDetail("user-2"))

        assertEquals(
            listOf(AppRoute.Directory, AppRoute.UserDetail("user-2")),
            fixture.controller.currentBackStack,
        )
    }

    @Test
    fun `back closes detail before returning to home`() {
        val fixture = NavigationFixture()
        fixture.controller.selectTopLevel(AppRoute.Activity)
        fixture.controller.navigate(AppRoute.EventDetail("event-1"))

        assertTrue(fixture.controller.goBack())
        assertEquals(listOf(AppRoute.Activity), fixture.controller.currentBackStack)
        assertEquals(AppRoute.Activity, fixture.controller.topLevelRoute)

        assertTrue(fixture.controller.goBack())
        assertEquals(AppRoute.Home, fixture.controller.topLevelRoute)
        assertFalse(fixture.controller.goBack())
    }

    @Test
    fun `recreating the controller does not reset restored state`() {
        val fixture = NavigationFixture()
        fixture.controller.selectTopLevel(AppRoute.Directory)
        fixture.controller.navigate(AppRoute.UserDetail("user-1"))

        val restored = fixture.recreateController()

        assertEquals(AppRoute.Directory, restored.topLevelRoute)
        assertEquals(
            listOf(AppRoute.Directory, AppRoute.UserDetail("user-1")),
            restored.currentBackStack,
        )
    }

    private class NavigationFixture {
        var selected: AppRoute = AppRoute.Home
        val stacks: Map<AppRoute, MutableList<NavKey>> =
            TopLevelDestination.entries.associate { destination ->
                destination.route to mutableListOf<NavKey>(destination.route)
            }

        val controller: AppBackStackController = recreateController()

        fun recreateController() =
            AppBackStackController(
                startRoute = AppRoute.Home,
                topLevelRoutes = TopLevelDestination.routes,
                currentTopLevel = { selected },
                setCurrentTopLevel = { selected = it },
                backStacks = stacks,
            )
    }
}
