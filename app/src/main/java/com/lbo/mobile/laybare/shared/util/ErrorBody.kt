package com.lbo.mobile.laybare.shared.util

import org.json.JSONObject
import retrofit2.HttpException

class ErrorBody {

    fun GetErrorBody(e:HttpException,jsonField:String):String{
        val error = e.response()?.errorBody()?.string()?.let { JSONObject(it) }

        return error!!.getString(jsonField)
    }

}