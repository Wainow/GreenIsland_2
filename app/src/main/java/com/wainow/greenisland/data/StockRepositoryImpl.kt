package com.wainow.greenisland.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wainow.greenisland.data.api.ApiService
import com.wainow.greenisland.data.api.MockedResults
import com.wainow.greenisland.data.db.StockDao
import com.wainow.greenisland.data.entity.ResponseDto
import com.wainow.greenisland.domain.StockRepository
import com.wainow.greenisland.domain.entity.Stock
import com.wainow.greenisland.toFavoriteEntity
import com.wainow.greenisland.toFavoriteModel
import com.wainow.greenisland.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.reflect.Type
import javax.inject.Inject

/**
 * Implementation of the repository
 *
 * @param apiService the stock API service
 * @param stockDao the DAO entity for database operations
 */
class StockRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val stockDao: StockDao
) : StockRepository {
    override suspend fun getLatestStocks(baseValue: String): Flow<List<Stock>> =
        flow {
            emit(apiService.getStocks(baseValue).toModel())
        }

    override suspend fun getMockStocks(baseValue: String): Flow<List<Stock>> {
        val type: Type = object : TypeToken<ResponseDto>() {}.type
        return flow {
            val response: ResponseDto =
                Gson().fromJson(MockedResults.getLatestStock(baseValue), type)
            emit(response.toModel())
        }
    }

    override suspend fun getFavoriteStocks() = stockDao.getAllFavoriteStocks().toModel()
    override suspend fun saveFavoriteStock(stock: Stock) = stockDao.insert(stock.toFavoriteEntity())
    override suspend fun deleteFavoriteStock(stock: Stock) = stockDao.delete(stock.toFavoriteEntity())
    override suspend fun updateFavorites(stocks: List<Stock>) = stockDao.update(stocks.toFavoriteModel())
}