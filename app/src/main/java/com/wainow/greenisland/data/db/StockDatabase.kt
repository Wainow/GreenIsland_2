package com.wainow.greenisland.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Сущность БД
 */
@Database(entities = [StockFavoriteEntity::class], version = 1)
abstract class StockDatabase : RoomDatabase() {

    /**
     * Получение ДАО для взаимодействия с БД
     */
    abstract fun stockDao(): StockDao

}