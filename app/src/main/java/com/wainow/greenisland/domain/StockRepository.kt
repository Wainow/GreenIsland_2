package com.wainow.greenisland.domain

import com.wainow.greenisland.domain.entity.StockModel
import kotlinx.coroutines.flow.Flow

/**
 * Repository for stocks
 */
interface StockRepository {
    /**
     * Retrieves the latest stocks from the internet
     *
     * @param baseValue the currency of the stock
     *
     * @return a flow of the list of stocks
     */
    suspend fun getLatestStocks(baseValue: String): Flow<List<StockModel>>

    /**
     * Retrieves the latest stocks in a cached format (might be useful if the number of requests is exceeded)
     *
     * @param baseValue the currency of the stock
     *
     * @return a flow of the list of stocks
     */
    suspend fun getMockStocks(baseValue: String): Flow<List<StockModel>>

    /**
     * Saves the current favorite stock to the database
     *
     * @param stock the current favorite stock
     */
    suspend fun saveFavoriteStock(stock: StockModel)

    /**
     * Retrieves the list of favorite stocks from the database
     *
     * @return the list of favorite stocks
     */
    suspend fun getFavoriteStocks(): List<StockModel>

    /**
     * Removes an unwanted stock from the list of favorites
     *
     * @param stock the unwanted stock
     */
    suspend fun deleteFavoriteStock(stock: StockModel)

    /**
     * Updates the list of favorite stocks
     *
     * @param stocks the list of favorite stocks
     */
    suspend fun updateFavorites(stocks: List<StockModel>)
}