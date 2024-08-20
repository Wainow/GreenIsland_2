package com.wainow.greenisland.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.wainow.greenisland.R
import com.wainow.greenisland.databinding.MainActivityBinding
import com.wainow.greenisland.domain.entity.Currency
import com.wainow.greenisland.presentation.entity.SortType
import com.wainow.greenisland.presentation.list.ListViewModel
import com.wainow.greenisland.presentation.list.PageAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity of the application
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * Binding for the main activity layout.
     */
    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }

    /**
     * ViewModel for managing the list of stocks.
     */
    private val listViewModel by viewModels<ListViewModel>()

    /**
     * Array of available sorting types.
     */
    private val sortTypes by lazy { SortType.values() }

    /**
     * Array of available currencies.
     */
    private val currencies by lazy { Currency.values() }

    /**
     * Array of currency names for use in dialogs.
     */
    private val currenciesChars: Array<CharSequence> by lazy {
        currencies.map { it.name }.toTypedArray()
    }

    /**
     * Array of sorting type descriptions for use in dialogs.
     */
    private val sortTypesChars: Array<CharSequence> by lazy {
        sortTypes.map { resources.getString(it.text) }.toTypedArray()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        setOnClickListeners()
    }

    /**
     * Initializes all views
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
     * Handles all view click events
     */
    private fun setOnClickListeners() {
        binding.run {
            sortBtn.setOnClickListener {
                openDialog(sortTypesChars) { which ->
                    val sortType = sortTypes[which]
                    when (sortType) {
                        SortType.NAME_ASCENDING -> listViewModel.sortByName(true)
                        SortType.NAME_DESCENDING -> listViewModel.sortByName(false)
                        SortType.VALUE_ASCENDING -> listViewModel.sortByValue(true)
                        SortType.VALUE_DESCENDING -> listViewModel.sortByValue(false)
                    }
                }
            }
            valueBtn.setOnClickListener {
                openDialog(currenciesChars) { which ->
                    listViewModel.currentValueChanged(currencies[which].name)
                }
            }
        }
    }

    /**
     * Opens a dialog for selecting an item
     *
     * @param itemsId Resource ID for the list of items
     * @param clickListener Callback for the selected item
     */
    private fun openDialog(items: Array<CharSequence>, clickListener: (Int) -> Unit) {
        val builder = AlertDialog.Builder(
            this@MainActivity,
            R.style.AlertDialog_AppCompat_GreenIsland
        )
        builder.setTitle(R.string.dialog_title)
            .setItems(items) { _, which ->
                clickListener(which)
            }
        builder.create().show()
    }
}