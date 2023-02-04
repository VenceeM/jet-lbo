package com.lbo.mobile.laybare.shared.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lbo.mobile.laybare.shared.util.LOGIN_BUTTONS_COLOR

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

@Composable
fun BackArrowButton(navController: NavController){
    Column(modifier = Modifier.padding(top = 40.dp)) {
        BackButtonComponent(modifier = Modifier
            .height(25.dp)
            .width(30.dp)
            .padding(start = 5.dp), iconTint = LOGIN_BUTTONS_COLOR
        ){
            navController.popBackStack()
        }
    }
}