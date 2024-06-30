package com.example.animatednavigator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.animatednavigator.navigation_animations.MainEnterAnimation
import com.example.animatednavigator.navigation_animations.MainExitAnimation
import com.example.animatednavigator.screens.CatalogScreen.CatalogScreen
import com.example.animatednavigator.screens.MapScreen.MapScreen
import com.example.animatednavigator.screens.SettingsScreen.SettingsScreen


val MainNavController = compositionLocalOf<NavHostController> {
    error("No MainNavController provided")
}

@Composable
fun MainGraph() {
    NavHost(navController = MainNavController.current, startDestination = AppRoutes.catalogScreenPath) {
        composable(
            route = AppRoutes.catalogScreenPath,
            enterTransition = {
                MainEnterAnimation()
            },
            exitTransition = {
                MainExitAnimation()
            },
            popEnterTransition = {
                MainEnterAnimation()
            },
            popExitTransition = {
                MainExitAnimation()
            }
        ) {
            CatalogScreen()
        }
        composable(route = AppRoutes.mapScreenPath, enterTransition = {
            MainEnterAnimation()
        },
            exitTransition = {
                MainExitAnimation()
            },
            popEnterTransition = {
                MainEnterAnimation()
            },
            popExitTransition = {
                MainExitAnimation()
            }) {
            MapScreen()
        }
        composable(route = AppRoutes.settingsScreenPath, enterTransition = {
            MainEnterAnimation()
        },
            exitTransition = {
                MainExitAnimation()
            },
            popEnterTransition = {
                MainEnterAnimation()
            },
            popExitTransition = {
                MainExitAnimation()
            }) {
            SettingsScreen()
        }
    }
}