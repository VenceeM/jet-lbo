package com.lbo.mobile.laybare.main.domain.model.login


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_info")
data class Customer(

    @PrimaryKey
    @ColumnInfo("id")
    @SerializedName("id")
    val id: Int?,

    @ColumnInfo("address")
    @SerializedName("address")
    val address: String?,

    @ColumnInfo("apple_id")
    @SerializedName("apple_id")
    val appleId: String?,

    @ColumnInfo("birthdate")
    @SerializedName("birthdate")
    val birthdate: String?,

    @ColumnInfo("birthdate_edited")
    @SerializedName("birthdate_edited")
    val birthdateEdited: Int?,

    @ColumnInfo("created_at")
    @SerializedName("created_at")
    val createdAt: String?,

    @ColumnInfo("created_by")
    @SerializedName("created_by")
    val createdBy: String?,

    @ColumnInfo("custom_id")
    @SerializedName("custom_id")
    val customId: String?,

    @ColumnInfo("customer_type_id")
    @SerializedName("customer_type_id")
    val customerTypeId: String?,

    @ColumnInfo("deleted_at")
    @SerializedName("deleted_at")
    val deletedAt: String?,

    @ColumnInfo("email")
    @SerializedName("email")
    val email: String?,

    @ColumnInfo("email_verified")
    @SerializedName("email_verified")
    val emailVerified: Int?,

    @ColumnInfo("facebook_id")
    @SerializedName("facebook_id")
    val facebookId: String?,

    @ColumnInfo("first_name")
    @SerializedName("first_name")
    val firstName: String?,

    @ColumnInfo("full_name")
    @SerializedName("full_name")
    val fullName: String?,

    @ColumnInfo("gender")
    @SerializedName("gender")
    val gender: String?,

    @ColumnInfo("gender_edited")
    @SerializedName("gender_edited")
    val genderEdited: Int?,

    @ColumnInfo("image")
    @SerializedName("image")
    val image: String?,

    @ColumnInfo("is_deleted_by_customer")
    @SerializedName("is_deleted_by_customer")
    val isDeletedByCustomer: String?,

    @ColumnInfo("is_login")
    @SerializedName("is_login")
    val isLogin: Int?,

    @ColumnInfo("is_plc")
    @SerializedName("is_plc")
    val isPlc: Int?,

    @ColumnInfo("last_name")
    @SerializedName("last_name")
    val lastName: String?,

    @ColumnInfo("loyalty_points")
    @SerializedName("loyalty_points")
    val loyaltyPoints: Int?,

    @ColumnInfo("middle_name")
    @SerializedName("middle_name")
    val middleName: String?,

    @ColumnInfo("pending_update_info")
    @SerializedName("pending_update_info")
    val pendingUpdateInfo: Int?,

    @ColumnInfo("phone")
    @SerializedName("phone")
    val phone: String?,

    @ColumnInfo("phone_verified")
    @SerializedName("phone_verified")
    val phoneVerified: Int?,

    @ColumnInfo("platform")
    @SerializedName("platform")
    val platform: Int?,

    @ColumnInfo("plc_progress")
    @SerializedName("plc_progress")
    val plcProgress: Int?,

    @ColumnInfo("updated_at")
    @SerializedName("updated_at")
    val updatedAt: String?
)