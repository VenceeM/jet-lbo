package com.lbo.mobile.laybare.main.presentation.screen.login_selection

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lbo.mobile.laybare.R

import com.lbo.mobile.laybare.shared.components.ButtonComponent
import com.lbo.mobile.laybare.shared.navigation.navigation_item.NavigationItem
import com.lbo.mobile.laybare.shared.util.LOGIN_BUTTONS_COLOR
import com.lbo.mobile.laybare.shared.util.LOGIN_FACEBOOK_BUTTON_COLOR

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun LoginSelectionScreen(navController: NavController = rememberAnimatedNavController()){

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Image(contentScale = ContentScale.Crop,painter = painterResource(id = R.drawable.login_bg),
            contentDescription = stringResource(id = R.string.login_background_description))
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.login_selection_box_padding_start),
                    end = dimensionResource(id = R.dimen.login_selection_box_padding_end),
                    top = dimensionResource(id = R.dimen.login_selection_box_padding_top),
                    bottom = dimensionResource(id = R.dimen.login_selection_box_padding_bottom)
                )){
                Image(painter = painterResource(id = R.drawable.laybare_logo), contentDescription = stringResource(
                    id = R.string.login_laybare_logo
                ))
            }

            ButtonComponent(modifier = Modifier
                .height(dimensionResource(id = R.dimen.login_selection_button_height))
                .padding(
                    start = dimensionResource(id = R.dimen.login_selection_button_padding_start),
                    end = dimensionResource(id = R.dimen.login_selection_box_padding_end)
                ),text = stringResource(id = R.string.login), color = LOGIN_BUTTONS_COLOR
            ){
                navController.navigate(NavigationItem.LOGIN)
            }
            Spacer(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.login_selection_button_spacer)))
            ButtonComponent(modifier = Modifier
                .height(dimensionResource(id = R.dimen.login_selection_button_height))
                .padding(
                    start = dimensionResource(id = R.dimen.login_selection_button_padding_start),
                    end = dimensionResource(id = R.dimen.login_selection_box_padding_end)
                ),text = stringResource(id = R.string.register), color = LOGIN_BUTTONS_COLOR
            )
            Spacer(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.login_selection_button_spacer)))
            ButtonComponent(modifier = Modifier
                .height(dimensionResource(id = R.dimen.login_selection_button_height))
                .padding(
                    start = dimensionResource(id = R.dimen.login_selection_button_padding_start),
                    end = dimensionResource(id = R.dimen.login_selection_box_padding_end)
                ),text = stringResource(id = R.string.facebook),
                color = LOGIN_FACEBOOK_BUTTON_COLOR, icon = R.drawable.facebook_icon, iconColor = 0xFFFFFFFF)
            Spacer(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.login_selection_button_spacer)))
            ButtonComponent(modifier = Modifier
                .height(dimensionResource(id = R.dimen.login_selection_button_height))
                .padding(
                    start = dimensionResource(id = R.dimen.login_selection_button_padding_start),
                    end = dimensionResource(id = R.dimen.login_selection_box_padding_end)
                ),text = stringResource(id = R.string.guest),
                color = LOGIN_BUTTONS_COLOR
            )
        }

    }

}




