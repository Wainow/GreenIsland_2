package com.wainow.greenisland.domain.entity

/**
 * Stock model
 *
 * @property name the name of the stock
 * @property value the value of the stock
 * @property date the current date
 * @property currency the currency of the stock
 */
data class Stock(
    val name: String,
    val value: Double,
    val date: String,
    val currency: String
)