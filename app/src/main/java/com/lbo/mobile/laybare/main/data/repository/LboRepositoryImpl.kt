package com.lbo.mobile.laybare.main.data.repository

import com.lbo.mobile.laybare.main.data.core.LaybareOnlineApi
import com.lbo.mobile.laybare.main.data.database.login.UserInformation
import com.lbo.mobile.laybare.main.data.database.login.UserInformationDao
import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.model.login.LoginResponse
import com.lbo.mobile.laybare.main.domain.repository.LboRepository
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject


class LboRepositoryImpl @Inject constructor(private val api:LaybareOnlineApi, private val userInfoDao:UserInformationDao):LboRepository {
    override suspend fun login(loginBody: LoginInfo): LoginResponse {
        return api.login(loginBody)
    }

    override suspend fun saveUser(userInfo: UserInformation) {
        return userInfoDao.saveUser(userInfo)
    }

    override suspend fun deleteAll() {
        userInfoDao.deleteAll()
    }

}