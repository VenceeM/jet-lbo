package com.lbo.mobile.laybare.main.presentation.screen.register

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lbo.mobile.laybare.R
import com.lbo.mobile.laybare.shared.components.BackArrowButton
import com.lbo.mobile.laybare.shared.components.InputTextFieldComponent

@Preview
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RegisterScreen(navController: NavController = rememberAnimatedNavController()){
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop,painter = painterResource(id = R.drawable.login_bg),
            contentDescription = stringResource(id = R.string.login_background_description))

        Column(modifier = Modifier.fillMaxSize()) {
            BackArrowButton(navController = navController)





            LazyColumn{
                item {

                    // Lay bare logo
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 15.dp,
                            bottom = dimensionResource(id = R.dimen.login_box_padding_bottom)
                        )){
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
                        ) {
                            Image(modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),painter = painterResource(id = R.drawable.laybare_logo), contentDescription = stringResource(
                                id = R.string.login_laybare_logo
                            ))
                        }
                    }
                    // Form
                    // First name
                    RegistrationForm(placeholder = "Given Name")
                    RegistrationForm(placeholder = "Middle Name")
                    RegistrationForm(placeholder = "Last Name")
                    RegistrationForm(placeholder = "Email")
                    RegistrationForm(placeholder = "Sex by Birth")
                    RegistrationForm(placeholder = "Birthdate")
                    RegistrationForm(placeholder = "09*********")
                    RegistrationForm(placeholder = "Password")
                    RegistrationForm(placeholder = "Confirm Password")

                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationForm(placeholder:String = "", text:String = "", onValueChange:(String)->Unit = {}){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 76.dp, end = 76.dp, bottom = 16.dp)) {

        InputTextFieldComponent(modifier = Modifier
            .height(50.dp)
            .clip(RoundedCornerShape(7.dp)),
        backgroundColor = 0xFF99FFFFFF, placeholder = placeholder, onValueChange = {onValueChange(it)},
        text = text, placeHolderColor = 0xFFFFFFFF, textColor = 0xFFFFFFFF, fontSize = 16.sp)
    }

}

