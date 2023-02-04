package com.lbo.mobile.laybare.shared.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.lbo.mobile.laybare.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InputTextFieldComponent(modifier:Modifier = Modifier,text:String = "",onValueChange:(String)->Unit = {},label:String = "Email",
    placeholder:String = "Email or Mobile Number",placeHolderColor:Long = 0xFFFFFFF,keyboardOptions: KeyboardOptions = KeyboardOptions(),keyboardActions: KeyboardActions = KeyboardActions(),
    backgroundColor:Long = 0xFFFFFFFF,textColor:Long = 0xFFFFFF,isPassword:Boolean = false,
    fontWeight: FontWeight = FontWeight.Normal,fontSize:TextUnit = 16.sp
){

    TextField(modifier = modifier
        .fillMaxWidth(),value = text, onValueChange = {  onValueChange(it) },
        placeholder = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text(text = placeholder, fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium, color = Color(placeHolderColor))
            }
        } ,
        colors = TextFieldDefaults.textFieldColors(containerColor = Color(backgroundColor), focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color(textColor)),
        textStyle = TextStyle(textDecoration = TextDecoration.None, fontWeight = fontWeight, fontSize = fontSize), keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions)

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InputPasswordFieldComponent(modifier:Modifier = Modifier,text:String = "",onValueChange: (String) -> Unit = {},label:String = "Email",
                            placeholder:String = "Email or Mobile Number",placeHolderColor:Long = 0xFFFFFFF,keyboardOptions: KeyboardOptions = KeyboardOptions(),keyboardActions: KeyboardActions = KeyboardActions(),
                            backgroundColor:Long = 0xFFFFFFFF,textColor:Long = 0xFFFFFF,isPassword:Boolean = true,
                                fontWeight: FontWeight = FontWeight.Normal,fontSize:TextUnit = 16.sp){

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    var icons by remember {
        mutableStateOf(R.drawable.baseline_visibility_24)
    }

    TextField(modifier = modifier
        .fillMaxWidth(),value = text, onValueChange = { onValueChange(it)},
        placeholder = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text(text = placeholder, fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium, color = Color(placeHolderColor))
            }
        } ,
        colors = TextFieldDefaults.textFieldColors(containerColor = Color(backgroundColor), focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color(textColor)),
        textStyle = TextStyle(textDecoration = TextDecoration.None,fontWeight = fontWeight, fontSize = fontSize), keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions, visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
                icons = if(icons == R.drawable.baseline_visibility_off_24){
                    R.drawable.baseline_visibility_24
                }else{
                    R.drawable.baseline_visibility_off_24
                }

            }) {
                PasswordVisible(currentIcon = icons)
            }

        })
}

@Composable
fun PasswordVisible(currentIcon:Int){
    Icon(painter = painterResource(id = currentIcon), contentDescription = "Password visible")
}
