package com.lbo.mobile.laybare.main.data.repository.data_source_impl

import com.lbo.mobile.laybare.main.data.core.LaybareOnlineApi
import com.lbo.mobile.laybare.main.data.repository.data_source.RemoteDataSource
import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api:LaybareOnlineApi): RemoteDataSource {
    override suspend fun login(loginBody: LoginInfo): LoginResponse {
        return api.login(loginBody)
    }
}