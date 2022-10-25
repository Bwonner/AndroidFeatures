package com.example.navigation

import androidx.navigation.NavController

class Navigator {

    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) =
        when (navigationFlow) {
            NavigationFlow.HomeFlow -> navController.navigate(MainNavGraphDirections.actionGlobalHomeFlow())
            is NavigationFlow.DashboardFlow -> navController.navigate(
                MainNavGraphDirections.actionGlobalDashboardFlow(
                    navigationFlow.msg
                )
            )
        }
}