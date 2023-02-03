package com.lbo.mobile.laybare.main.data.database

import androidx.room.RoomDatabase
import com.lbo.mobile.laybare.main.data.database.user_information.UserInformationDao
import com.lbo.mobile.laybare.main.domain.model.login.Customer

@androidx.room.Database(entities = [Customer::class], version = 2)
abstract class LaybareOnlineDatabase: RoomDatabase() {
    abstract fun userInfoDao(): UserInformationDao

}