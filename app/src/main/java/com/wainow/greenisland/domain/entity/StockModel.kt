package com.wainow.greenisland.domain.entity

/**
 * Stock model
 *
 * @property name the name of the stock
 * @property value the value of the stock
 * @property date the current date
 * @property currency the currency of the stock
 */
data class StockModel(
    val name: String,
    var value: Double,
    val date: String,
    var currency: String
)