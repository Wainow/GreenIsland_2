package com.wainow.greenisland.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Database entity
 */
@Database(entities = [StockFavoriteEntity::class], version = 1)
abstract class StockDatabase : RoomDatabase() {

    /**
     * Gets the DAO for database interaction
     */
    abstract fun stockDao(): StockDao

}