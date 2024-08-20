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
 * Main activity of the application
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * Binding for the layout
     */
    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }

    /**
     * ViewModel for the list of stocks
     */
    private val listViewModel by viewModels<ListViewModel>()

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
                openDialog(R.array.sort_by) { which ->
                    when (which) {
                        0 -> listViewModel.sortByName(true)  // Sort by name in ascending order
                        1 -> listViewModel.sortByName(false) // Sort by name in descending order
                        2 -> listViewModel.sortByValue(true) // Sort by value in ascending order
                        3 -> listViewModel.sortByValue(false) // Sort by value in descending order
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
     * Opens a dialog for selecting an item
     *
     * @param itemsId Resource ID for the list of items
     * @param clickListener Callback for the selected item
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