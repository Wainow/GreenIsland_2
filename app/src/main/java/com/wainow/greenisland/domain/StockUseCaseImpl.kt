package com.wainow.greenisland.domain

import com.wainow.greenisland.domain.entity.Stock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Implementation of the stock use case
 *
 * @param repository the stock repository
 */
class StockUseCaseImpl @Inject constructor(
    private val repository: StockRepository
) : StockUseCase {
    override suspend fun getLatestStocks(baseValue: String) =
        repository.getMockStocks(baseValue)

    override suspend fun sortByName(
        baseValue: String,
        isAscending: Boolean
    ): Flow<List<Stock>> =
        sortStockBy(baseValue, isAscending) { it.name }

    override suspend fun sortByValue(
        baseValue: String,
        isAscending: Boolean
    ): Flow<List<Stock>> = sortStockBy(baseValue, isAscending) { it.value }

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
        baseValue: String,
        isAscending: Boolean,
        crossinline selector: (Stock) -> R?
    ): Flow<List<Stock>> = getLatestStocks(baseValue).map {
        it.sortedBy(selector).run {
            if (!isAscending) asReversed() else this
        }
    }

    override suspend fun getFavorites() = repository.getFavoriteStocks()
    override suspend fun saveFavorite(stock: Stock) = repository.saveFavoriteStock(stock)
    override suspend fun deleteFavorite(stock: Stock) = repository.deleteFavoriteStock(stock)
    override suspend fun updateFavorites(stocks: List<Stock>) = repository.updateFavorites(stocks)
}