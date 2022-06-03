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
 * Вью модель списка акций
 *
 * @param stockUseCase юзкейс для акций
 */
@HiltViewModel
class ListViewModel @Inject constructor(
    private val stockUseCase: StockUseCase
) : ViewModel() {
    /**
     * Флоу состояния экрана всех акций
     */
    private val _uiState =
        MutableStateFlow<LatestStocksUiState>(LatestStocksUiState.Loading())

    /**
     * Флоу состояния экрана с любимыми акциями
     */
    private val _uiFavoriteState =
        MutableStateFlow<LatestStocksUiState>(LatestStocksUiState.Success(emptyList()))

    /**
     * Текущая валюта для акций
     */
    private val _currentValue = MutableLiveData(DEFAULT_BASE_VALUE)

    init {
        findValues(_currentValue.value)
    }

    /**
     * Пользователь выбрал акцию как любимую, обработка клика
     *
     * @param name название акции
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
     * Сохранение выбранной любимой акции
     *
     * @param stock выбранная любимая акция
     */
    private fun saveFavoriteStock(stock: StockUi) {
        viewModelScope.launch {
            if (stock.isFavorite) stockUseCase.saveFavorite(stock.toModel())
            else stockUseCase.deleteFavorite(stock.toModel())
        }
    }

    /**
     * Обработка изменения текущей валюты для акций
     *
     * @param newValue новая валюта для акций
     */
    fun currentValueChanged(newValue: String) {
        _currentValue.postValue(newValue)
        _uiState.value = LatestStocksUiState.Loading()
        findValues(newValue)
    }

    /**
     * Поиск акций по валюте
     *
     * @param baseValue валюта
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
     * Получение определенного стейта флоу в зависимости от номера страницы
     *
     * @param page номер страницы
     */
    fun getStocksByPage(page: Int): StateFlow<LatestStocksUiState> =
        when (page) {
            FAVORITE_PAGE_INDEX -> _uiFavoriteState
            else -> _uiState
        }

    /**
     * Сортировка акций по названию
     *
     * @param isAscending флаг сортировки по возрастанию/убыванию
     */
    fun sortByName(isAscending: Boolean) {
        sort(byName = true, isAscending)
    }

    /**
     * Сортировка акций по стоимости
     *
     * @param isAscending флаг сортировки по возрастанию/убыванию
     */
    fun sortByValue(isAscending: Boolean) {
        sort(byName = false, isAscending)
    }

    /**
     * Сортировка акций
     *
     * @param byName флаг сортировки по названию/стоимости
     * @param isAscending флаг сортировки по возрастанию/убыванию
     */
    private fun sort(byName: Boolean, isAscending: Boolean) {
        viewModelScope.launch {
            _uiState.value = LatestStocksUiState.Loading()
            try {
                (if (byName) stockUseCase.sortByName(_currentValue.value, isAscending)
                else stockUseCase.sortByValue(_currentValue.value, isAscending))
                    .collect {
                        _uiState.value = LatestStocksUiState.Success(it.toUi())
                        _uiFavoriteState.value = LatestStocksUiState.Success(it.toUi().favorite())
                    }
            } catch (e: Exception) {
                _uiState.value = LatestStocksUiState.Error(e)
            }
        }
    }
}