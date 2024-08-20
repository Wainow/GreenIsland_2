package com.wainow.greenisland.domain

import com.wainow.greenisland.domain.entity.Stock
import kotlinx.coroutines.flow.Flow

/**
 * Interface for stock use cases
 */
interface StockUseCase {
    /**
     * Retrieves the latest list of stocks
     *
     * @param baseValue the currency of the stocks
     *
     * @return a flow of the list of stocks
     */
    suspend fun getLatestStocks(baseValue: String): Flow<List<Stock>>

    /**
     * Sorts the list of stocks by name
     *
     * @param baseValue the currency of the stocks
     * @param isAscending flag indicating whether to sort in ascending/descending order
     *
     * @return a flow of the sorted list of stocks
     */
    suspend fun sortByName(baseValue: String, isAscending: Boolean): Flow<List<Stock>>

    /**
     * Sorts the list of stocks by value
     *
     * @param baseValue the currency of the stocks
     * @param isAscending flag indicating whether to sort in ascending/descending order
     *
     * @return a flow of the sorted list of stocks
     */
    suspend fun sortByValue(baseValue: String, isAscending: Boolean): Flow<List<Stock>>

    /**
     * Saves a favorite stock to the database
     *
     * @param stock the favorite stock
     */
    suspend fun saveFavorite(stock: Stock)

    /**
     * Retrieves the list of favorite stocks from the database
     *
     * @return the list of favorite stocks
     */
    suspend fun getFavorites(): List<Stock>

    /**
     * Removes a stock from the list of favorites
     *
     * @param stock the stock to be removed
     */
    suspend fun deleteFavorite(stock: Stock)

    /**
     * Updates the list of favorite stocks
     *
     * @param stocks the list of favorite stocks
     */
    suspend fun updateFavorites(stocks: List<Stock>)
}