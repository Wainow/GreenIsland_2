package com.wainow.greenisland.domain.entity

/**
 * Enum class representing various currencies.
 */
enum class Currency {
    EUR,
    USD,
    RUB,
    CZK;

    companion object {
        /**
         * Returns the default currency.
         *
         * The default currency is set to [EUR] (Euro).
         *
         * @return The default currency, which is [EUR].
         */
        fun getDefaultCurrency() = EUR
    }
}