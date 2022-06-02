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
 * Фрагмент страницы акции
 */
@AndroidEntryPoint
class ListFragment : CoreFragment<ListFragmentBinding>() {

    companion object {
        /**
         * Ключ для сохранения номера в бандл
         */
        const val ARG_SECTION_NUMBER = "number"

        /**
         * Создание экземляра фрагмента
         *
         * @param sectionNumber номер страницы
         *
         * @return экземляр фрагмента
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
     * Адаптер для списка акций
     */
    private var listAdapter: ListAdapter? = null

    /**
     * Вью модель списка акций
     */
    private val listViewModel by activityViewModels<ListViewModel>()

    override fun ListFragmentBinding.onInitView() {
        setupAdapter()
        observeViewModel()
    }

    /**
     * Настройка адаптера
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
     * Наблюдение за вью моделью
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
     * Отображения состояния загрузки
     *
     * @param isShow флаг отображения/скрытия загрузки
     */
    private fun showLoading(isShow: Boolean) {
        binding.pb.visibility = if(isShow) View.VISIBLE else View.INVISIBLE
    }

    /**
     * Показ списка акций
     *
     * @param value список акций
     */
    private fun showStocks(value: List<StockUi>) {
        listAdapter?.stocks = value
        showLoading(false)
    }

    /**
     * Показ ошибки на экране
     *
     * @param error ошибка
     */
    private fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        showLoading(false)
    }

    /**
     * Получения номера страницы из бандла
     *
     * @return номер страницы
     */
    private fun getPage() = arguments?.getInt(ARG_SECTION_NUMBER) ?: 0

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = ListFragmentBinding.inflate(inflater, container, false)

}