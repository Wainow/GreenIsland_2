package com.wainow.greenisland.presentation.entity

/**
 * Ui-сущность акции
 *
 * @property value стоимость акции
 * @property name название акции
 * @property date дата отображаемой стоимости
 * @property currency тип валюты
 * @property isFavorite флаг любимой/не любимой акции
 */
data class StockUi(
    val value: Double,
    val name: String,
    val date: String,
    val currency: String,
    var isFavorite: Boolean
)