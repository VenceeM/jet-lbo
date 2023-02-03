package com.lbo.mobile.laybare.main.presentation.screen.login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lbo.mobile.laybare.main.domain.model.login.Customer
import com.lbo.mobile.laybare.main.domain.model.login.LoginInfo
import com.lbo.mobile.laybare.main.domain.usecase.db.DeleteAllUseCase
import com.lbo.mobile.laybare.main.domain.usecase.login.LoginUseCase
import com.lbo.mobile.laybare.main.domain.usecase.db.SaveUserUseCase
import com.lbo.mobile.laybare.shared.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val deleteAllUseCase: DeleteAllUseCase
):ViewModel() {

    private val _state:MutableState<LoginState> = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    init {
        Log.d("VIEWMODELOF", "FROMVIEWMODEL OF LOGIN: OKAY")
    }

    fun login(password:String,type:String,unique:String){
        val loginInfo = LoginInfo(
            password = password,
            type = type,
            unique = unique
        )
        loginUseCase(loginInfo).onEach {result ->
            when(result){
                is Resource.Success -> {
                    _state.value = LoginState(login = result.data)
                }
                is Resource.Error -> {
                    _state.value = LoginState(message = result.message)
                }
                is Resource.Loading -> {
                    _state.value = LoginState(loading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


    fun saveUser(customer: Customer) = viewModelScope.launch {

        saveUserUseCase.execute(customer)
    }

    fun deleteAll() = viewModelScope.launch {
        deleteAllUseCase.execute()
    }




}