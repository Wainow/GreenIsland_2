package com.wainow.greenisland.di

import android.content.Context
import androidx.room.Room
import com.wainow.greenisland.data.db.StockDao
import com.wainow.greenisland.data.db.StockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Модуль БД
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    /**
     * Получение ДАО от БД
     *
     * @param database БД
     *
     * @return ДАО
     */
    @Provides
    fun provideStockDao(database: StockDatabase): StockDao {
        return database.stockDao()
    }

    /**
     * Получение БД
     *
     * @param appContext контекст
     *
     * @return БД
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): StockDatabase {
        return Room.databaseBuilder(
            appContext,
            StockDatabase::class.java,
            "stocks-db"
        ).build()
    }

}