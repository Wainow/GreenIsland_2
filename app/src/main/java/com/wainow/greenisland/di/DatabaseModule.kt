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
 * Database module
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    /**
     * Provides the DAO from the database
     *
     * @param database the database
     *
     * @return the DAO
     */
    @Provides
    fun provideStockDao(database: StockDatabase): StockDao {
        return database.stockDao()
    }

    /**
     * Provides the database
     *
     * @param appContext the application context
     *
     * @return the database
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