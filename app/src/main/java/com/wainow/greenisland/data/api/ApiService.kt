package com.wainow.greenisland.data.api

import com.wainow.greenisland.data.entity.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API service for stocks
 */
interface ApiService {

    /**
     * Retrieves the latest stock quotes
     *
     * @param baseValue the currency of the stocks
     *
     * @return the response entity with stock data
     */
    @GET("/latest")
    suspend fun getStocks(
        @Query("base") baseValue: String
    ): ResponseDto
}