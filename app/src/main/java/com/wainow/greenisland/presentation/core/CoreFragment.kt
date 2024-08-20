package com.wainow.greenisland.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Base abstract fragment for extracting common methods and fields
 */
abstract class CoreFragment<T : ViewBinding> : Fragment() {

    /**
     * Layout binding
     */
    protected lateinit var binding: T

    /**
     * Gets the binding
     *
     * @param inflater the inflater for binding XML and view
     * @param container the current ViewGroup of the fragment
     */
    abstract fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T

    /**
     * Initializes the views
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