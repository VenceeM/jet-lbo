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
import kotlinx.coroutines.flow.*
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


    private fun login(password:String,type:String,unique:String){
        val loginInfo = LoginInfo(
            password = password,
            type = type,
            unique = unique
        )
        viewModelScope.launch {
            loginUseCase(loginInfo).collect{result ->
                when(result){
                    is Resource.Success -> {
                        deleteAll()
                        _state.value = LoginState(login = result.data)
                        saveUser(customer = result.data!!.customer)

                    }
                    is Resource.Error -> {
                        _state.value = LoginState(message = result.message,emailOrPhone = state.value.emailOrPhone)
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            loading = true
                        )
                    }
                }
            }
        }

    }

    fun onEvent(event:LoginEvent){
        when(event){
            is LoginEvent.EmailOrPhone -> {
                _state.value = _state.value.copy(
                    emailOrPhone = event.emailOrPhone
                )
            }
            is LoginEvent.Password -> {
                _state.value = _state.value.copy(
                    password = event.password
                )
            }
            is LoginEvent.Login -> {
                if(state.value.emailOrPhone != "" && state.value.password != ""){
                    login(password = _state.value.password, type = "email", unique = _state.value.emailOrPhone)
                }

            }
        }
    }

    private fun saveUser(customer: Customer) = viewModelScope.launch {
        saveUserUseCase.execute(customer)
    }

    private fun deleteAll() = viewModelScope.launch {
        deleteAllUseCase.execute()
    }




}