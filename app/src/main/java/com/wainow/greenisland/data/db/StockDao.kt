package com.wainow.greenisland.data.db

import androidx.room.*

@Dao
interface StockDao {
    @Query("SELECT * FROM stockFavoriteEntity")
    suspend fun getAllFavoriteStocks(): List<StockFavoriteEntity>

    @Insert
    suspend fun insert(favoriteStock: StockFavoriteEntity)

    @Delete
    suspend fun delete(stock: StockFavoriteEntity)

    @Update
    suspend fun update(stocks: List<StockFavoriteEntity>)
}