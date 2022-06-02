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
 * Модуль юзкейсов в хилте
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    /**
     * Провайдинг юз кейса акций
     *
     * @param repo репозиторий акций
     *
     * @return имплементация юз кейса акций
     */
    @Provides
    @Singleton
    fun provideStockUseCase(repo: StockRepository): StockUseCase =
        StockUseCaseImpl(repo)

}