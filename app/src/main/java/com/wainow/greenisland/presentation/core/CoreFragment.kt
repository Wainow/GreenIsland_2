package com.wainow.greenisland.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Базовый абстрактный фрагмент для выноса лишних методов и полей
 */
abstract class CoreFragment<T : ViewBinding> : Fragment() {

    /**
     * Биндинг лэйаута
     */
    protected lateinit var binding: T

    /**
     * Получение биндинга
     *
     * @param inflater инфлейтер для связки xml и view
     * @param container текущая ViewGroup фрагмента
     */
    abstract fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T

    /**
     * Инициализация вьюшек
     */
    protected open fun T.onInitView() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = onCreateBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.onInitView()
    }

}