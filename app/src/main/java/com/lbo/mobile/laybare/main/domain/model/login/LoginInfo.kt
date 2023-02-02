package com.lbo.mobile.laybare.main.domain.model.login

import com.google.gson.annotations.SerializedName

data class LoginInfo(
    @SerializedName("password")
    val password:String,

    @SerializedName("type")
    val type:String,

    @SerializedName("unique")
    val unique:String
)
