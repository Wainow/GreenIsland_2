package com.wainow.greenisland.data.db

import androidx.room.*
/**
 * Сущность для обращения к БД
 */
@Dao
interface StockDao {
    /**
     * Получение всех любимых акций
     *
     * @return список любимых акций
     */
    @Query("SELECT * FROM stockFavoriteEntity")
    suspend fun getAllFavoriteStocks(): List<StockFavoriteEntity>

    /**
     * Поместить акцию в БД
     *
     * @param favoriteStock любимая акция
     */
    @Insert
    suspend fun insert(favoriteStock: StockFavoriteEntity)

    /**
     * Удалить акцию из БД
     *
     * @param stock не любимая акция
     */
    @Delete
    suspend fun delete(stock: StockFavoriteEntity)

    /**
     * Обновить список акций в БД
     *
     * @param stocks список акций для обновления
     */
    @Update
    suspend fun update(stocks: List<StockFavoriteEntity>)
}