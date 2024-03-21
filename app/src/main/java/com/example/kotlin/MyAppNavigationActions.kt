package com.example.kotlin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class MyAppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: MyAppTopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

data class MyAppTopLevelDestination(
    val route: String,
    val selectedIcon: Int,
    val iconTextId: Int
)



val TOP_LEVEL_DESTINATIONS = listOf(
    MyAppTopLevelDestination(
        route = MyAppRoute.HOME,
        selectedIcon = R.drawable.house ,
        iconTextId = R.string.home,
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.CALENDAR,
        selectedIcon = R.drawable.calendar ,
        iconTextId = R.string.calendar,
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.FRIENDS,
        selectedIcon = R.drawable.address_book ,
        iconTextId = R.string.friends,
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.GROUP,
        selectedIcon = R.drawable.user_group ,
        iconTextId = R.string.groups,
    )

)

object MyAppRoute {
    const val HOME = "home"
    const val CALENDAR = "calendar"
    const val FRIENDS = "friends"
    const val GROUP = "group"
}