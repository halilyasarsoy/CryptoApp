package com.halil.cryptoapp.ui.home

import androidx.fragment.app.viewModels
import com.halil.cryptoapp.base.BaseFragment
import com.halil.cryptoapp.databinding.FragmentHomeBinding
import com.halil.cryptoapp.util.Constants.API_KEY
import com.halil.cryptoapp.util.Constants.LIMIT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreateFinish() {
        viewModel.getData(API_KEY, LIMIT)
    }

    override fun initializeListeners() {

    }

    override fun observeEvents() {

    }
}