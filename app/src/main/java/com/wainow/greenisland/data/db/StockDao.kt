package com.wainow.greenisland.data.db

import androidx.room.*

/**
 * Entity for database access
 */
@Dao
interface StockDao {
    /**
     * Retrieves all favorite stocks
     *
     * @return list of favorite stocks
     */
    @Query("SELECT * FROM stockFavoriteEntity")
    suspend fun getAllFavoriteStocks(): List<StockFavoriteEntity>

    /**
     * Inserts a stock into the database
     *
     * @param favoriteStock the favorite stock
     */
    @Insert
    suspend fun insert(favoriteStock: StockFavoriteEntity)

    /**
     * Deletes a stock from the database
     *
     * @param stock the stock to be deleted
     */
    @Delete
    suspend fun delete(stock: StockFavoriteEntity)

    /**
     * Updates the list of stocks in the database
     *
     * @param stocks list of stocks to update
     */
    @Update
    suspend fun update(stocks: List<StockFavoriteEntity>)
}