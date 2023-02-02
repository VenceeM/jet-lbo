package com.lbo.mobile.laybare.main.data.di

import android.content.Context
import androidx.room.Room
import com.lbo.mobile.laybare.main.data.core.LaybareOnlineApi
import com.lbo.mobile.laybare.main.data.database.Database
import com.lbo.mobile.laybare.main.data.database.login.UserInformationDao
import com.lbo.mobile.laybare.main.data.repository.LboRepositoryImpl
import com.lbo.mobile.laybare.main.domain.repository.LboRepository
import com.lbo.mobile.laybare.main.domain.usecase.LoginUseCase
import com.lbo.mobile.laybare.main.domain.usecase.SaveUserUseCase
import com.lbo.mobile.laybare.shared.util.Constants
import com.lbo.mobile.laybare.shared.util.ErrorBody
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        context = app,
        Database::class.java,
        "user_info"
    ).build()


    @Provides
    @Singleton
    fun provideUserInformationDao(database: Database):UserInformationDao{
        return database.userInfoDao()
    }

    @Provides
    @Singleton
    fun provideLaybareApi():LaybareOnlineApi{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor = interceptor).build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(LaybareOnlineApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLaybareRepository(api: LaybareOnlineApi,userDao:UserInformationDao):LboRepository{
        return LboRepositoryImpl(api,userDao)
    }


    @Provides
    @Singleton
    fun provideErrorBody():ErrorBody{
        return com.lbo.mobile.laybare.shared.util.ErrorBody()
    }

}