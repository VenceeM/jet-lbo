package com.lbo.mobile.laybare.shared.SystemUiController

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController

//@Composable
//fun HideSystemNavigationBar(systemUiController: SystemUiController){
//    systemUiController.isNavigationBarVisible = false
//}
//@Composable
//fun ChangeSystemNavigationBarColor(systemUiController: SystemUiController){
//    val useDarkIcons = !isSystemInDarkTheme()
//    DisposableEffect(systemUiController, useDarkIcons){
//        systemUiController.setNavigationBarColor(color = Color.Black,
//            darkIcons = useDarkIcons)
//        onDispose {}
//    }
//}
//@Composable
//fun ChangeStatusBarColor(systemUiController: SystemUiController){
//    val useDarkIcons = !isSystemInDarkTheme()
//    DisposableEffect(systemUiController, useDarkIcons){
//        systemUiController.setSystemBarsColor(color = Color(0xFF1791D4),
//            darkIcons = useDarkIcons)
//        onDispose {}
//    }
//}