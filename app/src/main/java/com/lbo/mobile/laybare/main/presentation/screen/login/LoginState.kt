package com.lbo.mobile.laybare.main.presentation.screen.login

import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse
import retrofit2.Response

data class LoginState(
    var loading:Boolean = false,
    var login:LoginResponse? = null,
    var message:String? = "",
    var password:String = "",
    var emailOrPhone:String = ""
)
