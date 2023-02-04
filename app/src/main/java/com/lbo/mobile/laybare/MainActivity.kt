package com.lbo.mobile.laybare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lbo.mobile.laybare.shared.navigation.Navigation
import com.lbo.mobile.laybare.ui.theme.LayBareAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            LayBareAppTheme {

                val navController = rememberAnimatedNavController()
                MyApp(navController = navController)

            }
        }
    }
}

@Composable
fun MyApp(navController: NavHostController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Navigation(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LayBareAppTheme {

    }
}