package com.lbo.mobile.laybare.main.data.repository.data_source

import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse

interface RemoteDataSource {

    suspend fun login(loginBody:LoginInfo):LoginResponse

}