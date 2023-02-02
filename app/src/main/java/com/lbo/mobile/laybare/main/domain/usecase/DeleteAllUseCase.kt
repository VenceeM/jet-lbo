package com.lbo.mobile.laybare.main.domain.usecase

import com.lbo.mobile.laybare.main.domain.repository.LboRepository
import javax.inject.Inject

class DeleteAllUseCase @Inject constructor(private val lboRepository: LboRepository) {

    suspend fun execute() = lboRepository.deleteAll()

}