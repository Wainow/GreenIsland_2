package com.wainow.greenisland.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity for a favorite stock to be saved in the database
 *
 * @property name the name of the stock
 * @property value the value of the stock
 * @property date the date of the stock value
 * @property currency the currency of the stock
 */
@Entity
data class StockFavoriteEntity(
    @PrimaryKey val name: String = "",
    @ColumnInfo(name = "value") val value: Double = 0.0,
    @ColumnInfo(name = "date") val date: String = "",
    @ColumnInfo(name = "currency") val currency: String = "",
)