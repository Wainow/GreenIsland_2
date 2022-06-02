package com.wainow.greenisland.presentation.util

import com.wainow.greenisland.presentation.entity.StockUi

/**
 * Файл с экстеншенами примитивов
 */

/**
 * Фильтрация списка акций на любимые
 *
 * @return список любимых акций
 */
fun List<StockUi>.favorite() = filter { it.isFavorite }