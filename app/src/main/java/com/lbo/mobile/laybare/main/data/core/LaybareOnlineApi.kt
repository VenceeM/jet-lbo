package com.lbo.mobile.laybare.main.data.core

import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface LaybareOnlineApi {

    @POST("api/customer/login")
    suspend fun login(@Body loginBody:LoginInfo): LoginResponse

}