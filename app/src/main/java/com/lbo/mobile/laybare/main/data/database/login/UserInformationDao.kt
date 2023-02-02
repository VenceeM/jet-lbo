package com.lbo.mobile.laybare.main.data.database.login

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserInformationDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(userInfo:UserInformation)

    @Query("DELETE FROM user_info")
    suspend fun deleteAll()
}
