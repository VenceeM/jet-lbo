package com.lbo.mobile.laybare.main.data.di

import com.lbo.mobile.laybare.main.domain.repository.LboRepository
import com.lbo.mobile.laybare.main.domain.usecase.db.DeleteAllUseCase
import com.lbo.mobile.laybare.main.domain.usecase.login.LoginUseCase
import com.lbo.mobile.laybare.main.domain.usecase.db.SaveUserUseCase
import com.lbo.mobile.laybare.shared.util.ErrorBody
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideLoginUsecase(repository: LboRepository, errorBody: ErrorBody): LoginUseCase {
        return LoginUseCase(repository,errorBody)
    }

    @Provides
    @Singleton
    fun provideSaveUserUseCase(repository: LboRepository): SaveUserUseCase {
        return SaveUserUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteAllUseCase(repository: LboRepository): DeleteAllUseCase {
        return DeleteAllUseCase(repository)
    }

}