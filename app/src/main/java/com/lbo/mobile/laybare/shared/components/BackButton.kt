package com.lbo.mobile.laybare.shared.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BackButtonComponent(modifier:Modifier = Modifier,iconTint:Long = 0xFFFFFFFF,onClick:()->Unit = {}){
    IconButton(onClick = { onClick() }) {

        Icon(modifier = modifier,imageVector = Icons.Default.ArrowBack,
            contentDescription = "Arrow Back",
            tint = Color(iconTint)
        )
        
    }
}