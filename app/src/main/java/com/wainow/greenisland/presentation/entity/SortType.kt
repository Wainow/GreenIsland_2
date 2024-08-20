package com.wainow.greenisland.presentation.entity

import com.wainow.greenisland.R

/**
 * Enum class representing different types of sorting options.
 *
 * @property text The string resource ID for the sort type's display text.
 */
enum class SortType(val text: Int) {
    /** Sort by name in ascending order. */
    NAME_ASCENDING(R.string.name_ascending),

    /** Sort by name in descending order. */
    NAME_DESCENDING(R.string.name_descending),

    /** Sort by value in ascending order. */
    VALUE_ASCENDING(R.string.value_ascending),

    /** Sort by value in descending order. */
    VALUE_DESCENDING(R.string.value_descending);
}