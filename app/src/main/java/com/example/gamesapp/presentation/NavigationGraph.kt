package com.example.gamesapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gamesapp.presentation.games.Home

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            Home(navController)
        }
        composable(BottomNavItem.Hot.screen_route) {
            Home(navController)
        }
        composable(BottomNavItem.Discover.screen_route) {
            Home(navController)
        }
        composable(BottomNavItem.Profile.screen_route) {
            Home(navController)
        }
    }
}