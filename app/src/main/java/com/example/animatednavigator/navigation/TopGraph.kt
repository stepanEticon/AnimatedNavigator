package com.example.animatednavigator.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.animatednavigator.screens.FiltersScreen.FiltersScreen
import com.example.animatednavigator.screens.MainScreen.MainScreen
import com.example.animatednavigator.screens.SplashScreen.SplashScreen

val TopNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TopGraph() {
    NavHost(navController = TopNavController.current, startDestination = AppRoutes.slashScreenPath) {
        composable(route = AppRoutes.slashScreenPath) {
            SplashScreen()
        }
        composable(route = AppRoutes.mainScreenPath, enterTransition = {
            fadeIn(
                animationSpec = tween(
                    150, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(150, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(150, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            },
            popEnterTransition = {
                fadeIn(
                    animationSpec = tween(
                        150, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(150, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            },
            popExitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(150, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            MainScreen()
        }
        composable(route = AppRoutes.filtersScreenPath, enterTransition = {
            fadeIn(
                animationSpec = tween(
                    150, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(150, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        }, exitTransition = {
            fadeOut(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideOutOfContainer(
                animationSpec = tween(150, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End
            )
        }, popEnterTransition = {
            fadeIn(
                animationSpec = tween(
                    150, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(150, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        },
            popExitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(150, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }) {
            FiltersScreen()
        }
    }
}

