package com.lbo.mobile.laybare.main.domain.model.login


import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("address")
    val address: Any,
    @SerializedName("apple_id")
    val appleId: Any,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("birthdate_edited")
    val birthdateEdited: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_by")
    val createdBy: Any,
    @SerializedName("custom_id")
    val customId: Any,
    @SerializedName("customer_type_id")
    val customerTypeId: Any,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("email")
    val email: String,
    @SerializedName("email_verified")
    val emailVerified: Int,
    @SerializedName("facebook_id")
    val facebookId: Any,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("gender_edited")
    val genderEdited: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("is_deleted_by_customer")
    val isDeletedByCustomer: Any,
    @SerializedName("is_login")
    val isLogin: Int,
    @SerializedName("is_plc")
    val isPlc: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("loyalty_points")
    val loyaltyPoints: Int,
    @SerializedName("middle_name")
    val middleName: String,
    @SerializedName("pending_update_info")
    val pendingUpdateInfo: Int,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("phone_verified")
    val phoneVerified: Int,
    @SerializedName("platform")
    val platform: Int,
    @SerializedName("plc_progress")
    val plcProgress: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)