package com.lbo.mobile.laybare.shared.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lbo.mobile.laybare.shared.components.ButtonComponent

@Preview
@Composable
fun CustomLoadingDialog(modifier: Modifier = Modifier,onDismissRequest:()->Unit = {},title:String = "New Booking",
    description:String = "Logging In",isLoading:Boolean = true,isButtonVisible:Boolean = false,openDialog:Boolean = false,
    onConfirm:()->Unit = {}){

    if(openDialog){
        AlertDialog(modifier = modifier, contentColor = Color.White ,backgroundColor = Color(0xFF689D3A) ,shape = RoundedCornerShape(topStart = 50.dp, bottomEnd = 50.dp),
            onDismissRequest = {onDismissRequest()},
            title = {
                if(isLoading){
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        CircularProgressIndicator()
                    }
                }
            },
            text = {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = description, style = MaterialTheme.typography.subtitle2, fontSize = 16.sp)
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                }
            },

            confirmButton = {
                if(isButtonVisible){
                    Row(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp), horizontalArrangement = Arrangement.Center) {
                        ButtonComponent(text = "Ok", modifier = Modifier.clip(RoundedCornerShape(5.dp)).width(80.dp), color = LOGIN_BUTTONS_COLOR){
                            onConfirm()
                        }
                    }
                }

            }, dismissButton = {})
    }


}
