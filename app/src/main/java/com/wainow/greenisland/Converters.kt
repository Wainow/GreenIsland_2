package com.wainow.greenisland

import com.wainow.greenisland.data.db.StockFavoriteEntity
import com.wainow.greenisland.data.entity.ResponseDto
import com.wainow.greenisland.domain.entity.StockModel
import com.wainow.greenisland.presentation.entity.StockUi

/**
 * Converts the server response to a stock model.
 *
 * @return a list of stock models.
 */
fun ResponseDto.toModel() = this.rates.mapValues { entry ->
    StockModel(
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
fun StockModel.toUi(isFavorite: Boolean = false) =
    StockUi(
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
fun List<StockModel>.toUi(isFavorite: Boolean = false) = map { it.toUi(isFavorite) }

/**
 * Converts a UI stock model to a stock model.
 *
 * @return a stock model.
 */
fun StockUi.toModel() = StockModel(
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
fun StockModel.toFavoriteEntity() = StockFavoriteEntity(
    name = name,
    value = value,
    date = date,
    currency = currency
)

fun List<StockModel>.toFavoriteModel() = map { it.toFavoriteEntity() }

/**
 * Converts a database entity to a stock model.
 *
 * @return a stock model.
 */
fun StockFavoriteEntity.toModel() = StockModel(
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
fun getColorIdFromPrice(price: Double): String {
    var number = "$price"
        .filter { it.isDigit() }
    while (number.length < 7) {
        number += "5"
    }
    return "#${number.take(6)}"
}