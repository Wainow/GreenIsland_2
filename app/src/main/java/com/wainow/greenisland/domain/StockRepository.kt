package com.wainow.greenisland.domain

import com.wainow.greenisland.domain.entity.StockModel
import kotlinx.coroutines.flow.Flow

/**
 * Репозиторий для акций
 */
interface StockRepository {
    /**
     * Получение последних акций из сети интернет
     *
     * @param baseValue валюта акции
     *
     * @return флоу списка акций
     */
    suspend fun getLatestStocks(baseValue: String): Flow<List<StockModel>>

    /**
     * Получение последних акций в замоканном варианте (мб полезно если превышено число запросов)
     *
     * @param baseValue валюта акции
     *
     * @return флоу списка акций
     */
    suspend fun getMockStocks(baseValue: String): Flow<List<StockModel>>

    /**
     * Сохранение текущей любимой акции в БД
     *
     * @param stock текущая любимая акция
     */
    suspend fun saveFavoriteStock(stock: StockModel)

    /**
     * Получение списка любимых акций из БД
     *
     * @return список любимых акций
     */
    suspend fun getFavoriteStocks(): List<StockModel>

    /**
     * Удаление нелюбимой акции из списка любимых
     *
     * @param stock нелюбимая акция
     */
    suspend fun deleteFavoriteStock(stock: StockModel)
}