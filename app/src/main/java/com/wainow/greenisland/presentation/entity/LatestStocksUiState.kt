package com.wainow.greenisland.presentation.entity

/**
 * Screen states
 */
sealed class LatestStocksUiState {
    /**
     * Loading state
     *
     * @property message the message
     */
    data class Loading(val message: String = ""): LatestStocksUiState()

    /**
     * Successful state for loading stocks
     *
     * @property stocks the list of stocks
     */
    data class Success(val stocks: List<StockUi>) : LatestStocksUiState()

    /**
     * Error state
     *
     * @property exception the current error
     */
    data class Error(val exception: Throwable) : LatestStocksUiState()

    /**
     * Checks the state for success
     *
     * @param action the action to perform if the current state is successful
     *
     * @return the screen state entity
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