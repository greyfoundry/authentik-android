package dev.greyfoundry.authentik.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.layout.PaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import dev.greyfoundry.authentik.R
import dev.greyfoundry.authentik.ui.theme.AuthentikSpacing

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
internal fun AppNavigation(
    modifier: Modifier = Modifier,
    navigationSuiteTypeOverride: NavigationSuiteType? = null,
    paneDirectiveOverride: PaneScaffoldDirective? = null,
    initialTopLevel: AppRoute = AppRoute.Home,
    initialDetail: AppRoute? = null,
) {
    val navigationState = rememberAppNavigationState(initialTopLevel, initialDetail)
    val adaptiveInfo = currentWindowAdaptiveInfoV2()
    val navigationSuiteType =
        navigationSuiteTypeOverride
            ?: NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
    val listDetailStrategy =
        if (paneDirectiveOverride == null) {
            rememberListDetailSceneStrategy<NavKey>()
        } else {
            rememberListDetailSceneStrategy<NavKey>(directive = paneDirectiveOverride)
        }
    val entries = navigationState.toDecoratedEntries(appEntryProvider())
    val navigationTag =
        when (navigationSuiteType) {
            NavigationSuiteType.NavigationBar -> "navigation-bar"
            NavigationSuiteType.NavigationRail -> "navigation-rail"
            NavigationSuiteType.NavigationDrawer -> "navigation-drawer"
            else -> "navigation-suite"
        }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            TopLevelDestination.entries.forEach { destination ->
                item(
                    selected = navigationState.topLevelRoute == destination.route,
                    onClick = { navigationState.selectTopLevel(destination.route) },
                    icon = {
                        Icon(
                            painter = painterResource(destination.icon),
                            contentDescription = null,
                        )
                    },
                    label = { Text(text = stringResource(destination.label)) },
                )
            }
        },
        modifier = modifier.testTag(navigationTag),
        layoutType = navigationSuiteType,
    ) {
        NavDisplay(
            entries = entries,
            onBack = { navigationState.goBack() },
            sceneStrategies = listOf(listDetailStrategy),
            modifier = Modifier.fillMaxSize(),
        )
    }
}

private class AppNavigationState(
    private val startRoute: AppRoute,
    private val topLevelId: MutableState<String>,
    val backStacks: Map<AppRoute, NavBackStack<NavKey>>,
) {
    private val controller =
        AppBackStackController(
            startRoute = startRoute,
            topLevelRoutes = TopLevelDestination.routes,
            currentTopLevel = { TopLevelDestination.fromStableId(topLevelId.value).route },
            setCurrentTopLevel = { route ->
                topLevelId.value = TopLevelDestination.fromRoute(route).stableId
            },
            backStacks = backStacks,
        )

    val topLevelRoute: AppRoute
        get() = controller.topLevelRoute

    fun selectTopLevel(route: AppRoute) = controller.selectTopLevel(route)

    fun navigate(route: AppRoute) = controller.navigate(route)

    fun goBack(): Boolean = controller.goBack()

    @Composable
    fun toDecoratedEntries(
        entryProvider: (NavKey) -> NavEntry<NavKey>,
    ): List<NavEntry<NavKey>> {
        val decoratedEntries =
            backStacks.mapValues { (_, backStack) ->
                rememberDecoratedNavEntries(
                    backStack = backStack,
                    entryDecorators =
                        listOf(
                            rememberSaveableStateHolderNavEntryDecorator<NavKey>(),
                        ),
                    entryProvider = entryProvider,
                )
            }
        val routesInUse =
            if (topLevelRoute == startRoute) {
                listOf(startRoute)
            } else {
                listOf(startRoute, topLevelRoute)
            }
        return routesInUse.flatMap { route -> decoratedEntries.getValue(route) }
    }
}

@Composable
private fun rememberAppNavigationState(
    initialTopLevel: AppRoute,
    initialDetail: AppRoute?,
): AppNavigationState {
    require(initialTopLevel in TopLevelDestination.routes)
    require(initialDetail == null || initialDetail.topLevelParent() == initialTopLevel)

    val initialDestination = TopLevelDestination.fromRoute(initialTopLevel)
    val topLevelId =
        rememberSaveable {
            androidx.compose.runtime.mutableStateOf(initialDestination.stableId)
        }
    val backStacks =
        TopLevelDestination.entries.associate { destination ->
            val initialRoutes =
                if (destination.route == initialTopLevel && initialDetail != null) {
                    arrayOf(destination.route, initialDetail)
                } else {
                    arrayOf(destination.route)
                }
            destination.route to rememberNavBackStack(*initialRoutes)
        }
    return remember(topLevelId, backStacks) {
        AppNavigationState(
            startRoute = AppRoute.Home,
            topLevelId = topLevelId,
            backStacks = backStacks,
        )
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
private fun appEntryProvider(): (NavKey) -> NavEntry<NavKey> =
    entryProvider {
        entry<AppRoute.Home> {
            DestinationPage(
                title = stringResource(R.string.destination_home),
                testTag = "home",
            )
        }
        entry<AppRoute.Directory>(
            metadata =
                ListDetailSceneStrategy.listPane(
                    detailPlaceholder = {
                        DetailPlaceholder(text = stringResource(R.string.navigation_select_user))
                    },
                ),
        ) {
            DestinationPage(
                title = stringResource(R.string.destination_directory),
                testTag = "directory-list",
            )
        }
        entry<AppRoute.UserDetail>(
            metadata = ListDetailSceneStrategy.detailPane(),
        ) {
            DestinationPage(
                title = stringResource(R.string.navigation_user_detail),
                testTag = "user-detail",
            )
        }
        entry<AppRoute.Access> {
            DestinationPage(
                title = stringResource(R.string.destination_access),
                testTag = "access",
            )
        }
        entry<AppRoute.Activity>(
            metadata =
                ListDetailSceneStrategy.listPane(
                    detailPlaceholder = {
                        DetailPlaceholder(text = stringResource(R.string.navigation_select_event))
                    },
                ),
        ) {
            DestinationPage(
                title = stringResource(R.string.destination_activity),
                testTag = "activity-list",
            )
        }
        entry<AppRoute.EventDetail>(
            metadata = ListDetailSceneStrategy.detailPane(),
        ) {
            DestinationPage(
                title = stringResource(R.string.navigation_event_detail),
                testTag = "event-detail",
            )
        }
        entry<AppRoute.More> {
            DestinationPage(
                title = stringResource(R.string.destination_more),
                testTag = "more",
            )
        }
    }

@Composable
private fun DestinationPage(
    title: String,
    testTag: String,
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .safeContentPadding()
                .padding(AuthentikSpacing.md)
                .testTag(testTag),
        contentAlignment = Alignment.TopStart,
    ) {
        Text(
            text = title,
            modifier = Modifier.semantics { heading() },
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Composable
private fun DetailPlaceholder(text: String) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .safeContentPadding()
                .padding(AuthentikSpacing.md),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
