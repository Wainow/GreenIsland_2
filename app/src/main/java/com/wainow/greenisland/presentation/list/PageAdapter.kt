package com.wainow.greenisland.presentation.list

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wainow.greenisland.presentation.util.Constants.PAGE_COUNT
import com.wainow.greenisland.presentation.util.Constants.TAB_TITLES

/**
 * Адаптер страниц приложения
 */
class PageAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    /**
     * Список фрагментов приложения
     */
    private val fragments = listOf(
        ListFragment.newInstance(1),
        ListFragment.newInstance(2)
    )

    /**
     * Получения титульница страницы по номеру
     *
     * @param position номер страницы
     *
     * @return титульник страницы
     */
    fun getTabTitle(position: Int) = TAB_TITLES[position]

    override fun getItemCount() = PAGE_COUNT

    override fun createFragment(position: Int) = fragments[position]
}