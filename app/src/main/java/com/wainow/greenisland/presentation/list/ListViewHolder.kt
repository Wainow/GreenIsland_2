package com.wainow.greenisland.presentation.list

import android.graphics.Color
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wainow.greenisland.R
import com.wainow.greenisland.databinding.StockItemBinding
import com.wainow.greenisland.getColorIdFromPrice
import com.wainow.greenisland.presentation.entity.StockUi

/**
 * ViewHolder for the stock list
 *
 * @param binding Binding for the stock item
 * @param favoriteClicked Callback for star button clicks
 */
class ListViewHolder(
    private val binding: StockItemBinding,
    private val favoriteClicked: (String) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the view with the stock entity
     *
     * @param stock The stock entity
     */
    fun bind(stock: StockUi) {
        binding.run {
            with(stock) {
                nameTv.text = name
                infoTv.text = date
                priceTv.text = value.toString()
                currencyTv.text = currency
                imageView.setBackgroundColor(Color.parseColor(getColorIdFromPrice(value)))
                bindStar(starIb, this)
            }
        }
    }

    /**
     * Configures the star button view with the stock entity
     *
     * @param star The star button
     * @param stock The stock entity
     */
    private fun bindStar(star: ImageButton, stock: StockUi) {
        star.apply {
            setImageResource(
                if (stock.isFavorite)
                    R.drawable.ic_star
                else
                    R.drawable.ic_empty_star
            )
            setOnClickListener {
                favoriteClicked(stock.name)
            }
        }
    }
}