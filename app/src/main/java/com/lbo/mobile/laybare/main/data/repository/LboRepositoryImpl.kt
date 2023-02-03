package com.lbo.mobile.laybare.main.data.repository

import com.lbo.mobile.laybare.main.data.repository.data_source.LocalDataSource
import com.lbo.mobile.laybare.main.data.repository.data_source.RemoteDataSource
import com.lbo.mobile.laybare.main.domain.model.login.Customer
import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse
import com.lbo.mobile.laybare.main.domain.repository.LboRepository
import javax.inject.Inject


class LboRepositoryImpl @Inject constructor(
    private val localDataSource:LocalDataSource,
    private val remoteDataSource: RemoteDataSource):LboRepository {
    override suspend fun login(loginBody: LoginInfo): LoginResponse {
        return remoteDataSource.login(loginBody)
    }

    override suspend fun saveUser(userInfo: Customer) {
        return localDataSource.saveUser(userInfo)
    }

    override suspend fun deleteAll() {
        localDataSource.deleteAll()
    }

}