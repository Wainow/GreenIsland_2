package com.wainow.greenisland.presentation.entity

/**
 * UI entity for a stock
 *
 * @property value the value of the stock
 * @property name the name of the stock
 * @property date the date of the displayed value
 * @property currency the type of currency
 * @property isFavorite flag indicating whether the stock is a favorite
 */
data class StockUi(
    val value: Double,
    val name: String,
    val date: String,
    val currency: String,
    var isFavorite: Boolean
)