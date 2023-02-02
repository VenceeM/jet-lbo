package com.lbo.mobile.laybare.shared.util

sealed class Resource<T>(var data:T? = null, var message:String? = null){
    class Success<T>(data: T?):Resource<T>(data = data)
    class Error<T>(data: T? = null,message: String?):Resource<T>(data,message)
    class Loading<T>(data: T? = null):Resource<T>(data)
}
