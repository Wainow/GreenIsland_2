package com.wainow.greenisland.presentation.list

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wainow.greenisland.presentation.util.Constants.PAGE_COUNT
import com.wainow.greenisland.presentation.util.Constants.TAB_TITLES

/**
 * Adapter for the application's pages
 */
class PageAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    /**
     * List of fragments for the application
     */
    private val fragments = listOf(
        ListFragment.newInstance(1),
        ListFragment.newInstance(2)
    )

    /**
     * Get the tab title for a given page number
     *
     * @param position Page number
     *
     * @return Tab title for the page
     */
    fun getTabTitle(position: Int) = TAB_TITLES[position]

    override fun getItemCount() = PAGE_COUNT

    override fun createFragment(position: Int) = fragments[position]
}