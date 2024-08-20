package com.wainow.greenisland

import com.wainow.greenisland.data.db.StockFavoriteEntity
import com.wainow.greenisland.data.entity.ResponseDto
import com.wainow.greenisland.domain.entity.Stock
import com.wainow.greenisland.presentation.entity.StockUI

const val HEX_NEUTRAL_COLOR_DIGIT = 5
const val HEX_MAX_DIGIT_COUNT = 6

/**
 * Converts the server response to a stock model.
 *
 * @return a list of stock models.
 */
fun ResponseDto.toModel() = this.rates.mapValues { entry ->
    Stock(
        name = entry.key,
        value = entry.value,
        date = date,
        currency = base
    )
}.values.toMutableList()

/**
 * Converts a stock model to a UI stock model.
 *
 * @param isFavorite indicates whether the stock is a favorite.
 * @return a UI stock model.
 */
fun Stock.toUi(isFavorite: Boolean = false) =
    StockUI(
        name = name,
        value = value,
        date = date,
        currency = currency,
        isFavorite = isFavorite
    )

/**
 * Converts a list of stock models to a list of UI stock models.
 *
 * @param isFavorite indicates whether the stocks are favorites.
 * @return a list of UI stock models.
 */
fun List<Stock>.toUi(isFavorite: Boolean = false) = map { it.toUi(isFavorite) }

/**
 * Converts a UI stock model to a stock model.
 *
 * @return a stock model.
 */
fun StockUI.toModel() = Stock(
    name = name,
    value = value,
    date = date,
    currency = currency
)

/**
 * Converts a stock model to a database entity for storage.
 *
 * @return a favorite stock entity for database storage.
 */
fun Stock.toFavoriteEntity() = StockFavoriteEntity(
    name = name,
    value = value,
    date = date,
    currency = currency
)

fun List<Stock>.toFavoriteModel() = map { it.toFavoriteEntity() }

/**
 * Converts a database entity to a stock model.
 *
 * @return a stock model.
 */
fun StockFavoriteEntity.toModel() = Stock(
    name = name,
    value = value,
    date = date,
    currency = currency
)

/**
 * Converts a list of database entities to a list of stock models.
 *
 * @return a list of stock models.
 */
fun List<StockFavoriteEntity>.toModel() = map { it.toModel() }

/**
 * Converts a stock price to a HEX color code.
 *
 * @return a HEX color code.
 */
fun getColorHEXFromPrice(price: Double): String {
    var number = "$price"
        .filter { it.isDigit() }
    while (number.length <= HEX_MAX_DIGIT_COUNT) {
        number += HEX_NEUTRAL_COLOR_DIGIT.toString()
    }
    return "#${number.take(HEX_MAX_DIGIT_COUNT)}"
}