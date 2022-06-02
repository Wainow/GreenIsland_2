package com.wainow.greenisland.presentation.util

import com.wainow.greenisland.R

/**
 * Синглтон списка констант
 */
object Constants {
    /**
     * Номер страницы с любимыми акциями
     */
    const val FAVORITE_PAGE_INDEX = 2

    /**
     * Число страниц
     */
    const val PAGE_COUNT = 2

    /**
     * Титульники страниц с акциями
     */
    val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
    )

    /**
     * Стандартный тип валюты при открытии приложения
     */
    const val DEFAULT_BASE_VALUE = "EUR"
}