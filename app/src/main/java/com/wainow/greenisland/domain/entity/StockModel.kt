package com.wainow.greenisland.domain.entity

/**
 * Модель акции
 *
 * @property name название акции
 * @property value стоимость акции
 * @property date текущая дата
 * @property currency валюта акции
 */
data class StockModel(
    val name: String,
    val value: Double,
    val date: String,
    val currency: String
)
