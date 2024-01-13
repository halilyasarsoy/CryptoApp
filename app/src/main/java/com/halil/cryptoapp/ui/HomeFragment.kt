package com.halil.cryptoapp.ui

import androidx.fragment.app.viewModels
import com.halil.cryptoapp.base.BaseFragment
import com.halil.cryptoapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreateFinish() {

    }

    override fun initializeListeners() {

    }

    override fun observeEvents() {

    }
}