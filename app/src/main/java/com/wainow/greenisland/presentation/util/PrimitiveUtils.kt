package com.wainow.greenisland.presentation.util

import com.wainow.greenisland.presentation.entity.StockUI

/**
 * File containing extension functions for primitives
 */

/**
 * Filters the list of stocks to return only the favorite ones.
 *
 * @return list of favorite stocks
 */
fun List<StockUI>.favorite() = filter { it.isFavorite }