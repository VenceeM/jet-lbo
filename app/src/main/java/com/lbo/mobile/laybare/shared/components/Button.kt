package com.lbo.mobile.laybare.shared.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun ButtonComponent(modifier:Modifier = Modifier,text:String = "LOG IN",color:Long = 0xFFFFFFF, icon:Int? = null,iconColor:Long = 0xFFFFFFFF,
    height:Dp = 45.dp,onClick:()->Unit = {}){
    Button(modifier = modifier
        .fillMaxWidth()
        .height(height), shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(color)),
        onClick = onClick ) {
        if(icon != null){
            Icon(modifier = Modifier.height(22.dp).width(15.dp), painter = painterResource(id = icon), contentDescription = "Icon", tint = Color(iconColor))
            Spacer(modifier = Modifier.padding(4.dp))
        }

        ButtonText(text = text)
    }
}

@Preview
@Composable
fun ButtonText(text:String = "LOG IN"){
    Text(text = text, fontSize = 16.sp ,style = MaterialTheme.typography.labelMedium ,color = Color.White)
}