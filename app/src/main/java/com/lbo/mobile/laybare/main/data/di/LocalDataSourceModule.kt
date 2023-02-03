package com.lbo.mobile.laybare.main.data.di

import com.lbo.mobile.laybare.main.data.database.user_information.UserInformationDao
import com.lbo.mobile.laybare.main.data.repository.data_source.LocalDataSource
import com.lbo.mobile.laybare.main.data.repository.data_source_impl.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(dao:UserInformationDao):LocalDataSource{
        return LocalDataSourceImpl(dao)
    }

}