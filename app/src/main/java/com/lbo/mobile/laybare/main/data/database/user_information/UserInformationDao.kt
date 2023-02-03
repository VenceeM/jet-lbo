package com.lbo.mobile.laybare.main.data.database.user_information

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lbo.mobile.laybare.main.domain.model.login.Customer

@Dao
interface UserInformationDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(userInfo:Customer)

    @Query("DELETE FROM user_info")
    suspend fun deleteAll()
}
