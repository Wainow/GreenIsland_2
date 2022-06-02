package com.wainow.greenisland.data.api

import com.wainow.greenisland.data.entity.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Апи сервис акций
 */
interface ApiService {

    /**
     * Получение последний котировок акций
     *
     * @param baseValue валюта акций
     *
     * @return сущность ответа с акциями
     */
    @GET("/latest")
    suspend fun getStocks(
        @Query("base") baseValue: String
    ): ResponseDto
}