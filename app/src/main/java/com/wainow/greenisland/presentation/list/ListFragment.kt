package com.wainow.greenisland.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.wainow.greenisland.databinding.ListFragmentBinding
import com.wainow.greenisland.presentation.core.CoreFragment
import com.wainow.greenisland.presentation.entity.LatestStocksUiState
import com.wainow.greenisland.presentation.entity.StockUi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Fragment for the stock page
 */
@AndroidEntryPoint
class ListFragment : CoreFragment<ListFragmentBinding>() {

    companion object {
        /**
         * Key for saving the page number in the bundle
         */
        const val ARG_SECTION_NUMBER = "number"

        /**
         * Creates a new instance of the fragment
         *
         * @param sectionNumber the page number
         *
         * @return the fragment instance
         */
        fun newInstance(sectionNumber: Int): ListFragment {
            val args = Bundle().apply {
                putInt(ARG_SECTION_NUMBER, sectionNumber)
            }
            val fragment = ListFragment().apply {
                arguments = args
            }
            return fragment
        }
    }

    /**
     * Adapter for the stock list
     */
    private var listAdapter: ListAdapter? = null

    /**
     * View model for the stock list
     */
    private val listViewModel by activityViewModels<ListViewModel>()

    override fun ListFragmentBinding.onInitView() {
        setupAdapter()
        observeViewModel()
    }

    /**
     * Sets up the adapter
     */
    private fun setupAdapter() {
        val manager = LinearLayoutManager(context)
        listAdapter = ListAdapter(
            favoriteClicked = listViewModel::favoriteStockClicked
        )
        binding.listRv.run {
            layoutManager = manager
            adapter = listAdapter
        }
    }

    /**
     * Observes the view model
     */
    private fun observeViewModel() {
        lifecycleScope.launch {
            listViewModel.getStocksByPage(getPage()).collect { uiState ->
                when (uiState) {
                    is LatestStocksUiState.Loading -> showLoading(true)
                    is LatestStocksUiState.Success -> showStocks(uiState.stocks)
                    is LatestStocksUiState.Error -> showError(uiState.exception.toString())
                }
            }
        }
    }

    /**
     * Shows or hides the loading indicator
     *
     * @param isShow flag to show or hide loading
     */
    private fun showLoading(isShow: Boolean) {
        binding.pb.visibility = if(isShow) View.VISIBLE else View.INVISIBLE
    }

    /**
     * Displays the list of stocks
     *
     * @param value the list of stocks
     */
    private fun showStocks(value: List<StockUi>) {
        listAdapter?.stocks = value
        showLoading(false)
    }

    /**
     * Displays an error message on the screen
     *
     * @param error the error message
     */
    private fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        showLoading(false)
    }

    /**
     * Gets the page number from the bundle
     *
     * @return the page number
     */
    private fun getPage() = arguments?.getInt(ARG_SECTION_NUMBER) ?: 0

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = ListFragmentBinding.inflate(inflater, container, false)

}