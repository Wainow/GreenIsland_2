package com.wainow.greenisland.presentation.entity

import com.wainow.greenisland.R

/**
 * Enum class representing different screens in the application.
 *
 * @property title The string resource ID for the screen's title.
 */
enum class Screen(val title: Int) {
    /** Screen showing all stocks. */
    ALL_STOCKS(title = R.string.all_stocks),

    /** Screen showing favorite items. */
    FAVORITES(title = R.string.favorites);

    companion object {
        /**
         * Returns the total number of screens.
         *
         * @return The number of screens defined in the [Screen] enum.
         */
        fun getPageCount() = Screen.values().size
    }
}