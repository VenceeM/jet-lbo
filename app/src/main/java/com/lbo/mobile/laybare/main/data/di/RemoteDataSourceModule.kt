package com.lbo.mobile.laybare.main.data.di

import com.lbo.mobile.laybare.main.data.core.LaybareOnlineApi
import com.lbo.mobile.laybare.main.data.repository.data_source.RemoteDataSource
import com.lbo.mobile.laybare.main.data.repository.data_source_impl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(api:LaybareOnlineApi):RemoteDataSource{
        return RemoteDataSourceImpl(api)
    }

}