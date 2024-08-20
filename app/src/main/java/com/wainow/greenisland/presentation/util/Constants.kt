package com.wainow.greenisland.presentation.util

import com.wainow.greenisland.R

/**
 * Singleton for a list of constants
 */
object Constants {
    /**
     * Page number for the favorite stocks
     */
    const val FAVORITE_PAGE_INDEX = 2

    /**
     * Number of pages
     */
    const val PAGE_COUNT = 2

    /**
     * Titles for the tabs in the stocks pages
     */
    val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
    )

    /**
     * Default currency type when the application starts
     */
    const val DEFAULT_BASE_VALUE = "EUR"
}