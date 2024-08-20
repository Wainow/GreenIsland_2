package com.wainow.greenisland.domain

import com.wainow.greenisland.domain.entity.StockModel
import com.wainow.greenisland.presentation.util.Constants.DEFAULT_BASE_VALUE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

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
    suspend fun getLatestStocks(baseValue: String?): Flow<List<StockModel>>

    /**
     * Sorts the list of stocks by name
     *
     * @param baseValue the currency of the stocks
     * @param isAscending flag indicating whether to sort in ascending/descending order
     *
     * @return a flow of the sorted list of stocks
     */
    suspend fun sortByName(baseValue: String?, isAscending: Boolean): Flow<List<StockModel>>

    /**
     * Sorts the list of stocks by value
     *
     * @param baseValue the currency of the stocks
     * @param isAscending flag indicating whether to sort in ascending/descending order
     *
     * @return a flow of the sorted list of stocks
     */
    suspend fun sortByValue(baseValue: String?, isAscending: Boolean): Flow<List<StockModel>>

    /**
     * Saves a favorite stock to the database
     *
     * @param stock the favorite stock
     */
    suspend fun saveFavorite(stock: StockModel)

    /**
     * Retrieves the list of favorite stocks from the database
     *
     * @return the list of favorite stocks
     */
    suspend fun getFavorites(): List<StockModel>

    /**
     * Removes a stock from the list of favorites
     *
     * @param stock the stock to be removed
     */
    suspend fun deleteFavorite(stock: StockModel)

    /**
     * Updates the list of favorite stocks
     *
     * @param stocks the list of favorite stocks
     */
    suspend fun updateFavorites(stocks: List<StockModel>)
}

/**
 * Implementation of the stock use case
 *
 * @param repository the stock repository
 */
class StockUseCaseImpl @Inject constructor(
    private val repository: StockRepository
) : StockUseCase {
    override suspend fun getLatestStocks(baseValue: String?) =
        repository.getMockStocks(baseValue ?: DEFAULT_BASE_VALUE)

    override suspend fun sortByName(
        baseValue: String?,
        isAscending: Boolean
    ): Flow<List<StockModel>> =
        sortStockBy(baseValue, isAscending) { it.name }

    override suspend fun sortByValue(
        baseValue: String?,
        isAscending: Boolean
    ): Flow<List<StockModel>> =
        sortStockBy(baseValue, isAscending) { it.value }

    override suspend fun saveFavorite(stock: StockModel) = repository.saveFavoriteStock(stock)

    override suspend fun deleteFavorite(stock: StockModel) = repository.deleteFavoriteStock(stock)

    override suspend fun getFavorites() = repository.getFavoriteStocks()

    /**
     * Inline function to simplify sorting syntax
     *
     * @param baseValue the currency of the stocks
     * @param isAscending flag indicating whether to sort in ascending/descending order
     * @param selector the sorting condition
     *
     * @return a flow of the sorted list of stocks
     */
    private suspend inline fun <R : Comparable<R>> sortStockBy(
        baseValue: String?,
        isAscending: Boolean,
        crossinline selector: (StockModel) -> R?
    ): Flow<List<StockModel>> = getLatestStocks(baseValue).map {
        it.sortedBy(selector).run {
            if (!isAscending) asReversed() else this
        }
    }

    override suspend fun updateFavorites(stocks: List<StockModel>) = repository.updateFavorites(stocks)
}