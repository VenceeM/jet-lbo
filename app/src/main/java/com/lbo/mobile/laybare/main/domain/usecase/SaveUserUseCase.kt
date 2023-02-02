package com.lbo.mobile.laybare.main.domain.usecase

import com.lbo.mobile.laybare.main.data.database.login.UserInformation
import com.lbo.mobile.laybare.main.data.database.login.UserInformationDao
import com.lbo.mobile.laybare.main.domain.repository.LboRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(private val lboRepository: LboRepository){

    suspend fun execute(userInfo:UserInformation) = lboRepository.saveUser(userInfo)

}