package com.wainow.greenisland.presentation.entity

/**
 * Состояния экрана
 */
sealed class LatestStocksUiState {
    /**
     * Состояние загрузки
     *
     * @property message сообщение
     */
    data class Loading(val message: String = ""): LatestStocksUiState()

    /**
     * Состояние успешной загрузки акций
     *
     * @property stocks список акций
     */
    data class Success(val stocks: List<StockUi>) : LatestStocksUiState()

    /**
     * Состояние ошибки
     *
     * @property exception текущая ошибка
     */
    data class Error(val exception: Throwable) : LatestStocksUiState()

    /**
     * Проверка состояния на успешность
     *
     * @param action действие которое выполняем если текущее состояние успешное
     *
     * @return сущность состояния экрана
     */
    inline fun onSuccess(
        crossinline action: (List<StockUi>) -> Unit
    ): LatestStocksUiState {
        if (this is Success) {
            action(stocks)
        }
        return this
    }
}