package com.wainow.greenisland.presentation.list

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wainow.greenisland.presentation.entity.Screen

/**
 * Adapter for the application's pages
 */
class PageAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    /**
     * List of fragments for the application
     */
    private val fragments = Screen.values().map { ListFragment.newInstance(it.ordinal) }

    /**
     * Get the tab title for a given page number
     *
     * @param position Page number
     *
     * @return Tab title for the page
     */
    fun getTabTitle(position: Int) = Screen.values()[position].title

    override fun getItemCount() = Screen.getPageCount()

    override fun createFragment(position: Int) = fragments[position]
}