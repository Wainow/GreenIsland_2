package com.wainow.greenisland.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wainow.greenisland.domain.StockUseCase
import com.wainow.greenisland.presentation.entity.LatestStocksUiState
import com.wainow.greenisland.presentation.entity.StockUi
import com.wainow.greenisland.presentation.util.Constants.DEFAULT_BASE_VALUE
import com.wainow.greenisland.presentation.util.Constants.FAVORITE_PAGE_INDEX
import com.wainow.greenisland.presentation.util.favorite
import com.wainow.greenisland.toModel
import com.wainow.greenisland.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the stock list
 *
 * @param stockUseCase Use case for stocks
 */
@HiltViewModel
class ListViewModel @Inject constructor(
    private val stockUseCase: StockUseCase
) : ViewModel() {

    /**
     * Flow for the UI state of all stocks
     */
    private val _uiState =
        MutableStateFlow<LatestStocksUiState>(LatestStocksUiState.Loading())

    /**
     * Flow for the UI state of favorite stocks
     */
    private val _uiFavoriteState =
        MutableStateFlow<LatestStocksUiState>(LatestStocksUiState.Success(emptyList()))

    /**
     * Current currency for stocks
     */
    private val _currentValue = MutableLiveData(DEFAULT_BASE_VALUE)

    init {
        findValues(_currentValue.value)
    }

    /**
     * Handle the user selecting a stock as a favorite
     *
     * @param name The name of the stock
     */
    fun favoriteStockClicked(name: String) {
        _uiState.value.onSuccess { list ->
            _uiState.value = LatestStocksUiState.Loading()
            val stocks = list.map { stock ->
                if (name == stock.name) {
                    stock.apply { isFavorite = !isFavorite }
                    saveFavoriteStock(stock)
                    stock
                } else
                    stock
            }
            _uiState.value = LatestStocksUiState.Success(stocks)
            _uiFavoriteState.value = LatestStocksUiState.Success(stocks.favorite())
        }
    }

    /**
     * Save the selected favorite stock
     *
     * @param stock The selected favorite stock
     */
    private fun saveFavoriteStock(stock: StockUi) {
        viewModelScope.launch {
            if (stock.isFavorite) stockUseCase.saveFavorite(stock.toModel())
            else stockUseCase.deleteFavorite(stock.toModel())
        }
    }

    /**
     * Handle changes in the current currency for stocks
     *
     * @param newValue The new currency for stocks
     */
    fun currentValueChanged(newValue: String) {
        _currentValue.postValue(newValue)
        _uiState.value = LatestStocksUiState.Loading()
        findValues(newValue)
    }

    /**
     * Fetch stocks based on the currency
     *
     * @param baseValue The currency
     */
    private fun findValues(baseValue: String?) {
        viewModelScope.launch {
            try {
                val favorites = stockUseCase.getFavorites()
                _uiFavoriteState.value =
                    LatestStocksUiState.Success(favorites.toUi(isFavorite = true))
                stockUseCase.getLatestStocks(baseValue).collect { list ->
                    val result = list.map { model ->
                        if (favorites.any { it.name == model.name }) {
                            favorites.find { it.name == model.name }?.apply {
                                value = model.value
                                currency = model.currency
                            }
                            model.toUi(true)
                        } else {
                            model.toUi(false)
                        }
                    }
                    stockUseCase.updateFavorites(favorites)
                    _uiFavoriteState.value = LatestStocksUiState.Success(favorites.toUi(true))
                    _uiState.value = LatestStocksUiState.Success(result)
                }
            } catch (e: Exception) {
                _uiState.value = LatestStocksUiState.Error(e)
            }
        }
    }

    /**
     * Get a specific state flow based on the page number
     *
     * @param page The page number
     * @return The state flow
     */
    fun getStocksByPage(page: Int): StateFlow<LatestStocksUiState> =
        when (page) {
            FAVORITE_PAGE_INDEX -> _uiFavoriteState
            else -> _uiState
        }

    /**
     * Sort stocks by name
     *
     * @param isAscending Flag for ascending/descending order
     */
    fun sortByName(isAscending: Boolean) {
        sort(byName = true, isAscending)
    }

    /**
     * Sort stocks by value
     *
     * @param isAscending Flag for ascending/descending order
     */
    fun sortByValue(isAscending: Boolean) {
        sort(byName = false, isAscending)
    }

    /**
     * Sort stocks
     *
     * @param byName Flag to sort by name/value
     * @param isAscending Flag for ascending/descending order
     */
    private fun sort(byName: Boolean, isAscending: Boolean) {
        viewModelScope.launch {
            _uiState.value = LatestStocksUiState.Loading()
            try {
                val favorites = stockUseCase.getFavorites()
                (if (byName) stockUseCase.sortByName(_currentValue.value, isAscending)
                else stockUseCase.sortByValue(_currentValue.value, isAscending))
                    .collect { list ->
                        val result = list.map { model ->
                            model.toUi(favorites.any { it.name == model.name })
                        }
                        _uiState.value = LatestStocksUiState.Success(result)
                        _uiFavoriteState.value = LatestStocksUiState.Success(result.favorite())
                    }
            } catch (e: Exception) {
                _uiState.value = LatestStocksUiState.Error(e)
            }
        }
    }
}