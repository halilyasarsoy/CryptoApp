package com.halil.cryptoapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import java.lang.IllegalArgumentException

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null
    private val binding: VB get() = _binding as VB

    protected abstract val viewModel: VM
    protected abstract fun onCreateFinish()
    protected abstract fun initializeListeners()
    protected abstract fun observeEvents()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        if (null == this._binding) {
            throw IllegalArgumentException("Binding Null")
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateFinish()
        initializeListeners()
        observeEvents()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
