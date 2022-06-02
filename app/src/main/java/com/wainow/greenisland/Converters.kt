package com.wainow.greenisland

import com.wainow.greenisland.data.db.StockFavoriteEntity
import com.wainow.greenisland.data.entity.ResponseDto
import com.wainow.greenisland.domain.entity.StockModel
import com.wainow.greenisland.presentation.entity.StockUi

/**
 * Преобразование ответа от сервера в модель акции
 *
 * @return модель акции
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
 * Преобразование модели акции в ui-модель акции
 *
 * @return ui-модель акции
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
 * Преобразование списка моделей акций в список ui-моделей акций
 *
 * @return список ui-моделей акций
 */
fun List<StockModel>.toUi(isFavorite: Boolean = false) = map { it.toUi(isFavorite) }

/**
 * Преобразование ui-модели акции в модель акции
 *
 * @return модель акции
 */
fun StockUi.toModel() = StockModel(
    name = name,
    value = value,
    date = date,
    currency = currency
)

/**
 * Преобразование модели акции в сущность для сохранения в БД
 *
 * @return сущность любимой акции для сохранения в БД
 */
fun StockModel.toFavoriteEntity() = StockFavoriteEntity(
    name = name,
    value = value,
    date = date,
    currency = currency
)

/**
 * Преобразование сущности БД в модель акции
 *
 * @return модель акции
 */
fun StockFavoriteEntity.toModel() = StockModel(
    name = name,
    value = value,
    date = date,
    currency = currency
)

/**
 * Преобразование списка сущностей БД в список моделей акций
 *
 * @return список моделей акций
 */
fun List<StockFavoriteEntity>.toModel() = map { it.toModel() }

/**
 * Преобразование цены акции в HEX кодировку цвета
 *
 * @return HEX кодировка цвета
 */
fun getColorIdFromPrice(price: Double): String {
    var number = "$price"
        .filter { it.isDigit() }
    while(number.length < 7) {
        number += "5"
    }
    return "#${number.take(6)}"
}