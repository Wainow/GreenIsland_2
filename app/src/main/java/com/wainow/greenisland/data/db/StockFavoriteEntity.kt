package com.wainow.greenisland.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Сущность любимой акции для сохранения в БД
 *
 * @property name название акции
 * @property value стоимость акции
 * @property date дата стоимости
 * @property currency валюта акции
 */
@Entity
data class StockFavoriteEntity(
    @PrimaryKey val name: String = "",
    @ColumnInfo(name = "value") val value: Double = 0.0,
    @ColumnInfo(name = "date") val date: String = "",
    @ColumnInfo(name = "currency") val currency: String = "",
)