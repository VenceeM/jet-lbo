package com.lbo.mobile.laybare.main.data.repository.data_source

import com.lbo.mobile.laybare.main.domain.model.login.Customer

interface LocalDataSource {

    suspend fun saveUser(userInfo:Customer)
    suspend fun deleteAll()

}