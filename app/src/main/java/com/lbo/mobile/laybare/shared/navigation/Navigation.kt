package com.lbo.mobile.laybare.shared.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.lbo.mobile.laybare.main.presentation.screen.login.LoginScreen
import com.lbo.mobile.laybare.main.presentation.screen.login_selection.LoginSelectionScreen
import com.lbo.mobile.laybare.main.presentation.screen.register.RegisterScreen
import com.lbo.mobile.laybare.main.presentation.screen.splash.SplashScreen
import com.lbo.mobile.laybare.shared.navigation.navigation_item.NavigationItem

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(navController:NavHostController){

    AnimatedNavHost(navController = navController, startDestination = NavigationItem.LOGIN_SELECTION){

        composable(NavigationItem.SPLASH){
            SplashScreen()

        }
        composable(NavigationItem.LOGIN_SELECTION,enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(300))
        } ,exitTransition = {
            slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, tween(300))
        }){
            LoginSelectionScreen(navController = navController)

        }

        composable(NavigationItem.LOGIN, enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
        },exitTransition = {
            slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, tween(300))
        }){
            LoginScreen(navController = navController)
        }

        composable(NavigationItem.REGISTER, enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
        }, exitTransition = {
            slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(300))
        }){
            RegisterScreen(navController = navController)
        }


    }


}