package com.lbo.mobile.laybare.main.data.database

import androidx.room.RoomDatabase
import com.lbo.mobile.laybare.main.data.database.login.UserInformation
import com.lbo.mobile.laybare.main.data.database.login.UserInformationDao

@androidx.room.Database(entities = [UserInformation::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun userInfoDao(): UserInformationDao

}