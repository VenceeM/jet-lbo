package com.lbo.mobile.laybare.main.data.repository.data_source_impl

import com.lbo.mobile.laybare.main.data.database.user_information.UserInformationDao
import com.lbo.mobile.laybare.main.data.repository.data_source.LocalDataSource
import com.lbo.mobile.laybare.main.domain.model.login.Customer
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao:UserInformationDao): LocalDataSource {
    override suspend fun saveUser(userInfo: Customer) {
        return dao.saveUser(userInfo)
    }

    override suspend fun deleteAll() {
        return dao.deleteAll()
    }
}