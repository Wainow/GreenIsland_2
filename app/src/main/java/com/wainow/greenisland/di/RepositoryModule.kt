package com.wainow.greenisland.di

import com.wainow.greenisland.data.StockRepositoryImpl
import com.wainow.greenisland.domain.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Модуль для репозиториев в хилте
 */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    /**
     * Получение репозитория акций
     *
     * @param impl имплементация репозитория
     *
     * @return репозиторий
     */
    @Binds
    fun bindStockRepo(impl : StockRepositoryImpl) : StockRepository

}