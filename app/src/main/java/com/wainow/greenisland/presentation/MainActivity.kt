package com.wainow.greenisland.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.wainow.greenisland.R
import com.wainow.greenisland.databinding.MainActivityBinding
import com.wainow.greenisland.presentation.list.ListViewModel
import com.wainow.greenisland.presentation.list.PageAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Главное активити приложения
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * Биндинг моего лэйаута
     */
    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }

    /**
     * Вью модель списка акций
     */
    private val listViewModel by viewModels<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        setOnClickListeners()
    }

    /**
     * Инициализация всех вьюшек
     */
    private fun initView() {
        binding.run {
            val adapter = PageAdapter(this@MainActivity)
            viewPager.adapter = adapter
            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = getString(adapter.getTabTitle(position))
            }.attach()
        }
    }

    /**
     * Обработка всех кликов на вьюшки
     */
    private fun setOnClickListeners() {
        binding.run {
            sortBtn.setOnClickListener {
                openDialog(R.array.sort_by) { which ->
                    when (which) {
                        0 -> {
                            listViewModel.sortByName(true)
                        }
                        1 -> {
                            listViewModel.sortByName(false)
                        }
                        2 -> {
                            listViewModel.sortByValue(true)
                        }
                        3 -> {
                            listViewModel.sortByValue(false)
                        }
                    }
                }
            }
            valueBtn.setOnClickListener {
                openDialog(R.array.values) { which ->
                    val values = resources.getStringArray(R.array.values)
                    listViewModel.currentValueChanged(values[which])
                }
            }
        }
    }

    /**
     * Открытие диалогового окна в выбором
     *
     * @param itemsId список айдишников строчек для выбора
     * @param clickListener колбек выбранной строчки
     */
    private fun openDialog(itemsId: Int, clickListener: (Int) -> Unit) {
        val builder = AlertDialog.Builder(
            this@MainActivity,
            R.style.AlertDialog_AppCompat_GreenIsland
        )
        builder.setTitle(R.string.dialog_title)
            .setItems(itemsId) { _, which ->
                clickListener(which)
            }
        builder.create().show()
    }
}