package com.wainow.greenisland.di

import com.wainow.greenisland.data.StockRepositoryImpl
import com.wainow.greenisland.domain.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Module for repositories in Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    /**
     * Provides the stock repository
     *
     * @param impl the repository implementation
     *
     * @return the repository
     */
    @Binds
    fun bindStockRepo(impl: StockRepositoryImpl): StockRepository

}