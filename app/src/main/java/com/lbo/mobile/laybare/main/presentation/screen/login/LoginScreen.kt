package com.lbo.mobile.laybare.main.presentation.screen.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lbo.mobile.laybare.R
import com.lbo.mobile.laybare.shared.components.*
import com.lbo.mobile.laybare.shared.util.CustomLoadingDialog
import com.lbo.mobile.laybare.shared.util.LOGIN_BUTTONS_COLOR

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun LoginScreen(navController: NavController = rememberAnimatedNavController(), loginViewModel: LoginViewModel = hiltViewModel()){
    val focusManager = LocalFocusManager.current
    val state = loginViewModel.state.value


    var password by remember {
        mutableStateOf("")
    }
    val type by remember {
        mutableStateOf("email")
    }
    var unique by remember {
        mutableStateOf("")
    }
    var openDialog by remember {
        mutableStateOf(false)
    }


    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Image(modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop,painter = painterResource(id = R.drawable.login_bg),
            contentDescription = stringResource(id = R.string.login_background_description)
        )
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {

            BackArrowButton(navController = navController)

            // Lay bare logo
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.login_box_padding_top),
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

            // Email or mobile number
            InputTextFieldComponent(modifier = Modifier
                .height(dimensionResource(id = R.dimen.login_input_height))
                .padding(
                    start = dimensionResource(id = R.dimen.login_input_padding_start),
                    end = dimensionResource(id = R.dimen.login_input_padding_end)
                )
                .clip(RoundedCornerShape(7.dp)), text = unique, onValueChange = {value -> unique = value}, backgroundColor = 0xFF99FFFFFF, placeHolderColor = 0xFFFFFFFF,
                textColor = 0xFFFFFFFF, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down)}),
                fontSize = 16.sp, fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            // Password
            InputPasswordFieldComponent(modifier = Modifier
                .height(dimensionResource(id = R.dimen.login_input_height))
                .padding(
                    start = dimensionResource(id = R.dimen.login_input_padding_start),
                    end = dimensionResource(id = R.dimen.login_input_padding_end)
                )
                .clip(RoundedCornerShape(7.dp)), text = password, onValueChange = {value -> password = value}, backgroundColor = 0xFF99FFFFFF, placeHolderColor = 0xFFFFFFFF, placeholder = "Password",
                textColor = 0xFFFFFFFF,fontSize = 16.sp, fontWeight = FontWeight.Bold,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus(true)
                })
            )

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            // Login Button
            ButtonComponent(modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.login_button_padding_start),
                end = dimensionResource(id = R.dimen.login_button_padding_end)),
                text = "LOG IN", color = LOGIN_BUTTONS_COLOR, height = 45.dp){
                loginViewModel.login(password = password,type = type,unique = unique)

            }

            if(state.loading == true){
                openDialog = true
                CustomLoadingDialog(openDialog = openDialog,onDismissRequest = {openDialog = false},
                description = "Logging In")
            }else if(state.login != null){
                openDialog = false
                loginViewModel.deleteAll()
                loginViewModel.saveUser(state.login?.customer!!)
            } else if(state.message != null){
                CustomLoadingDialog(openDialog = openDialog,onDismissRequest = {openDialog = false},
                    description = state.message!!, isLoading = false, isButtonVisible = true, onConfirm = {openDialog = false})
            }

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            // Forgot email or password?
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { }){
                    Text(modifier = Modifier.padding(start = 6.dp, end = 6.dp), text = "Forgot email or password?", fontSize = 15.sp, style = MaterialTheme.typography.labelMedium,
                        color = Color.White)
                }

            }

        }
        
    }
}
