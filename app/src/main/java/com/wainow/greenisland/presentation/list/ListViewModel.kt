package com.wainow.greenisland.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wainow.greenisland.domain.StockUseCase
import com.wainow.greenisland.domain.entity.Currency
import com.wainow.greenisland.presentation.entity.LatestStocksUIState
import com.wainow.greenisland.presentation.entity.Screen
import com.wainow.greenisland.presentation.entity.StockUI
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
        MutableStateFlow<LatestStocksUIState>(LatestStocksUIState.Loading())

    /**
     * Flow for the UI state of favorite stocks
     */
    private val _uiFavoriteState =
        MutableStateFlow<LatestStocksUIState>(LatestStocksUIState.Success(emptyList()))

    /**
     * Current currency for stocks
     */
    private val _currentValue = MutableLiveData(Currency.getDefaultCurrency().name)

    init {
        findValues(getCurrencyValue())
    }

    private fun getCurrencyValue() = _currentValue.value ?: Currency.getDefaultCurrency().name

    /**
     * Handle the user selecting a stock as a favorite
     *
     * @param name The name of the stock
     */
    fun favoriteStockClicked(name: String) {
        _uiState.value.onSuccess { list ->
            _uiState.value = LatestStocksUIState.Loading()
            val stocks = list.map { stock ->
                if (name == stock.name) {
                    val newStock = stock.copy(isFavorite = !stock.isFavorite)
                    saveFavoriteStock(newStock)
                    newStock
                } else
                    stock
            }
            _uiState.value = LatestStocksUIState.Success(stocks)
            _uiFavoriteState.value = LatestStocksUIState.Success(stocks.favorite())
        }
    }

    /**
     * Save the selected favorite stock
     *
     * @param stock The selected favorite stock
     */
    private fun saveFavoriteStock(stock: StockUI) {
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
        _uiState.value = LatestStocksUIState.Loading()
        findValues(newValue)
    }

    /**
     * Fetch stocks based on the currency
     *
     * @param baseValue The currency
     */
    private fun findValues(baseValue: String) {
        viewModelScope.launch {
            try {
                val favorites = stockUseCase.getFavorites().toMutableList()
                _uiFavoriteState.value =
                    LatestStocksUIState.Success(favorites.toUi(isFavorite = true))
                stockUseCase.getLatestStocks(baseValue).collect { list ->
                    val result = list.map { model ->
                        if (favorites.any { it.name == model.name }) {
                            favorites.find { it.name == model.name }?.apply {
                                val index = favorites.indexOf(this)
                                favorites[index] = copy(value = model.value, currency = model.currency)
                            }
                            model.toUi(true)
                        } else {
                            model.toUi(false)
                        }
                    }
                    stockUseCase.updateFavorites(favorites)
                    _uiFavoriteState.value = LatestStocksUIState.Success(favorites.toUi(true))
                    _uiState.value = LatestStocksUIState.Success(result)
                }
            } catch (e: Exception) {
                _uiState.value = LatestStocksUIState.Error(e)
            }
        }
    }

    /**
     * Get a specific state flow based on the page number
     *
     * @param page The page number
     * @return The state flow
     */
    fun getStocksByPage(page: Int): StateFlow<LatestStocksUIState> =
        when (page) {
            Screen.FAVORITES.ordinal -> _uiFavoriteState
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
            _uiState.value = LatestStocksUIState.Loading()
            try {
                val favorites = stockUseCase.getFavorites()
                val currencyValue = getCurrencyValue()
                (if (byName) stockUseCase.sortByName(currencyValue, isAscending)
                else stockUseCase.sortByValue(currencyValue, isAscending))
                    .collect { list ->
                        val result = list.map { model ->
                            model.toUi(favorites.any { it.name == model.name })
                        }
                        _uiState.value = LatestStocksUIState.Success(result)
                        _uiFavoriteState.value = LatestStocksUIState.Success(result.favorite())
                    }
            } catch (e: Exception) {
                _uiState.value = LatestStocksUIState.Error(e)
            }
        }
    }
}