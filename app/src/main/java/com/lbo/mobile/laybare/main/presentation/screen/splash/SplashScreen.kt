package com.lbo.mobile.laybare.main.presentation.screen.splash

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.lbo.mobile.laybare.shared.util.Constants
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(){
    Surface(modifier = Modifier.fillMaxHeight(), color = Color(0xFFA8DC67)) {
        Splash()
    }

}
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
fun Splash(){

    val videoPath = Constants.SPLASH_VIDEO
    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build()
    val playerView = PlayerView(context)
    val mediaItem = MediaItem.fromUri(videoPath)

    val playWhenReady by rememberSaveable() {
        mutableStateOf(true)
    }
    val useController by remember {
        mutableStateOf(false)
    }

    player.setMediaItem(mediaItem)
    playerView.hideController()
    playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
    playerView.useController = useController
    playerView.player = player


    LaunchedEffect(player){
        player.prepare()
        player.playWhenReady = playWhenReady

        // Temporary
        delay(2000L)

        Log.d("PLAYING", "Splash: DONE")

    }

    AndroidView(factory = {
        playerView
    })
}
