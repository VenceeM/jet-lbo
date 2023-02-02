package com.lbo.mobile.laybare.main.data.database.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_info")
data class UserInformation(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "accessToken")
    val accessToken:String? = null,
    @ColumnInfo(name = "refreshToken")
    val refreshToken:String? = null,
    @ColumnInfo("address")
    val address: String? = null,
    @ColumnInfo("apple_id")
    val appleId: String? = null,
    @ColumnInfo("birthdate")
    val birthdate: String? = null,
    @ColumnInfo("birthdate_edited")
    val birthdateEdited: Int? = null,
    @ColumnInfo("created_at")
    val createdAt: String? = null,
    @ColumnInfo("created_by")
    val createdBy: String? = null,
    @ColumnInfo("custom_id")
    val customId: String? = null,
    @ColumnInfo("customer_type_id")
    val customerTypeId: String? = null,
    @ColumnInfo("deleted_at")
    val deletedAt: String? = null,
    @ColumnInfo("email")
    val email: String? = null,
    @ColumnInfo("email_verified")
    val emailVerified: Int? = null,
    @ColumnInfo("facebook_id")
    val facebookId: String? = null,
    @ColumnInfo("first_name")
    val firstName: String? = null,
    @ColumnInfo("full_name")
    val fullName: String? = null,
    @ColumnInfo("gender")
    val gender: String? = null,
    @ColumnInfo("gender_edited")
    val genderEdited: Int? = null,
    @ColumnInfo("user_id")
    val user_id: Int? = null,
    @ColumnInfo("image")
    val image: String? = null,
    @ColumnInfo("is_deleted_by_customer")
    val isDeletedByCustomer: String? = null,
    @ColumnInfo("is_login")
    val isLogin: Int? = null,
    @ColumnInfo("is_plc")
    val isPlc: Int? = null,
    @ColumnInfo("last_name")
    val lastName: String? = null,
    @ColumnInfo("loyalty_points")
    val loyaltyPoints: Int? = null,
    @ColumnInfo("middle_name")
    val middleName: String? = null,
    @ColumnInfo("pending_update_info")
    val pendingUpdateInfo: Int? = null,
    @ColumnInfo("phone")
    val phone: String? = null,
    @ColumnInfo("phone_verified")
    val phoneVerified: Int? = null,
    @ColumnInfo("platform")
    val platform: Int? = null,
    @ColumnInfo("plc_progress")
    val plcProgress: Int? = null,
    @ColumnInfo("updated_at")
    val updatedAt: String? = null


)
