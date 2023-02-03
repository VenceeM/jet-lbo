package com.lbo.mobile.laybare.main.domain.repository

import com.lbo.mobile.laybare.main.domain.model.login.Customer
import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse

interface LboRepository {

    suspend fun login(loginBody:LoginInfo):LoginResponse

    // Local database
    suspend fun saveUser(userInfo:Customer)
    suspend fun deleteAll()

}