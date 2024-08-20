package com.wainow.greenisland.presentation.util

import com.wainow.greenisland.presentation.entity.StockUi

/**
 * File containing extension functions for primitives
 */

/**
 * Filters the list of stocks to return only the favorite ones.
 *
 * @return list of favorite stocks
 */
fun List<StockUi>.favorite() = filter { it.isFavorite }