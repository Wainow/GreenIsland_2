package com.wainow.greenisland.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StockDao {
    @Query("SELECT * FROM stockFavoriteEntity")
    suspend fun getAllFavoriteStocks(): List<StockFavoriteEntity>

    @Insert
    suspend fun insert(favoriteStock: StockFavoriteEntity)

    @Delete
    suspend fun delete(stock: StockFavoriteEntity)
}