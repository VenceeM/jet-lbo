package com.lbo.mobile.laybare.main.presentation.screen.login

sealed class LoginEvent{
    data class EmailOrPhone(val emailOrPhone:String):LoginEvent()
    data class Password(val password:String):LoginEvent()
    object Login:LoginEvent()


}
