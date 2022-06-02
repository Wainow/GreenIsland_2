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
 * Вью холдер для списка акций
 *
 * @param binding биндинг айтема акции
 * @param favoriteClicked колбек клика на звездочку
 */
class ListViewHolder(
    private val binding: StockItemBinding,
    private val favoriteClicked: (String) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    /**
     * Функция для связывания вьюшки и сущности акции
     *
     * @param stock сущность акции
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
     * Фунция для настройки вьюшки звезды и сущности акции
     *
     * @param star кнопка звездочка
     * @param stock сущность акции
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