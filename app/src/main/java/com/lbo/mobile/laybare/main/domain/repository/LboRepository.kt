package com.lbo.mobile.laybare.main.domain.repository

import com.lbo.mobile.laybare.main.data.database.login.UserInformation
import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse
import okhttp3.RequestBody
import retrofit2.Response

interface LboRepository {

    suspend fun login(loginBody:LoginInfo):LoginResponse

    // Local database
    suspend fun saveUser(userInfo:UserInformation)
    suspend fun deleteAll()

}