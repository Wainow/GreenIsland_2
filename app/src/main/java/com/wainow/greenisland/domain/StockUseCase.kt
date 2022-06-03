package com.wainow.greenisland.domain

import com.wainow.greenisland.domain.entity.StockModel
import com.wainow.greenisland.presentation.util.Constants.DEFAULT_BASE_VALUE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Интерфейс юз кейса акций
 */
interface StockUseCase {
    /**
     * Получение последнего списка акций
     *
     * @param baseValue валюта акций
     *
     * @return Флоу списка акций
     */
    suspend fun getLatestStocks(baseValue: String?): Flow<List<StockModel>>

    /**
     * Сортировка списка акций по названию
     *
     * @param baseValue валюта акций
     * @param isAscending флаг сортировки по возрастанию/убыванию
     *
     * @return Флоу списка акций
     */
    suspend fun sortByName(baseValue: String?, isAscending: Boolean): Flow<List<StockModel>>

    /**
     * Сортировка списка акций по стоимости
     *
     * @param baseValue валюта акций
     * @param isAscending флаг сортировки по возрастанию/убыванию
     *
     * @return Флоу списка акций
     */
    suspend fun sortByValue(baseValue: String?, isAscending: Boolean): Flow<List<StockModel>>

    /**
     * Сохранение любимой акции в БД
     *
     * @param stock любимая акция
     */
    suspend fun saveFavorite(stock: StockModel)

    /**
     * Получение списка любимых акций из БД
     *
     * @return список любимых акций
     */
    suspend fun getFavorites(): List<StockModel>

    /**
     * Удаление акции из списка любиых
     *
     * @param stock нелюбимая акция
     */
    suspend fun deleteFavorite(stock: StockModel)

    suspend fun updateFavorites(stocks: List<StockModel>)
}

/**
 * Реализация юзкейса акций
 *
 * @param repository репозиторий акций
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
     * Инлайн функция для упрощения синтаксиса сортировки
     *
     * @param baseValue валюта акций
     * @param isAscending флаг сортировки по возрастанию/убыванию
     * @param selector условие сортировки
     *
     * @return флоу отсортированного списка акций
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