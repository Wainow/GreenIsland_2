package com.wainow.greenisland.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wainow.greenisland.databinding.StockItemBinding
import com.wainow.greenisland.presentation.entity.StockUi

/**
 * Адаптер списка акций
 *
 * @param favoriteClicked калбек нажатия на звездочку
 */
class ListAdapter(
    private val favoriteClicked: (String) -> Unit
): RecyclerView.Adapter<ListViewHolder>() {

    /**
     * Список акций
     */
    var stocks: List<StockUi> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = StockItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding, favoriteClicked)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) = holder.bind(stocks[position])

    override fun getItemCount() = stocks.size
}