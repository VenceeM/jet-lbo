package com.lbo.mobile.laybare.main.domain.usecase.db

import com.lbo.mobile.laybare.main.domain.model.login.Customer
import com.lbo.mobile.laybare.main.domain.repository.LboRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(private val lboRepository: LboRepository){

    suspend fun execute(userInfo:Customer) = lboRepository.saveUser(userInfo)

}