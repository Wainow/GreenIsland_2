package com.wainow.greenisland.di

import com.wainow.greenisland.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Сетевой модуль в хилте
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /**
     * Базовый юрл
     */
    private val BASE_URL = "https://api.exchangerate.host/"

    /**
     * Ретрофит билдер для создания сущности апи сервиса
     */
    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    /**
     * Апи сервис акций
     */
    private val apiService: ApiService by lazy {
        retrofitBuilder.build().create(ApiService::class.java)
    }

    /**
     * Провайд апи сервиса в хилте
     *
     * @return апи сервис
     */
    @Provides
    fun apiService() = apiService

}