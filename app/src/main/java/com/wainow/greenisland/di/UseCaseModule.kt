package com.wainow.greenisland.di

import com.wainow.greenisland.domain.StockRepository
import com.wainow.greenisland.domain.StockUseCase
import com.wainow.greenisland.domain.StockUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Use case module in Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    /**
     * Provides the stock use case
     *
     * @param repo the stock repository
     *
     * @return the implementation of the stock use case
     */
    @Provides
    @Singleton
    fun provideStockUseCase(repo: StockRepository): StockUseCase =
        StockUseCaseImpl(repo)

}