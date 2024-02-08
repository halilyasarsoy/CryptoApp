package com.halil.cryptoapp.ui.home

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.halil.cryptoapp.base.BaseFragment
import com.halil.cryptoapp.databinding.FragmentHomeBinding
import com.halil.cryptoapp.model.home.Data
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
        with(viewModel) {
            cryptoResponse.observe(viewLifecycleOwner) {
                it?.let {
                    it.data?.let { it1 -> setRecycler(it1) }
                }
            }
            isLoading.observe(viewLifecycleOwner) {
                handleViews(it)
            }
            onError.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setRecycler(data: List<Data>) {
        val mAdapter = HomeRecyclerAdapter(object : ItemClickListener {
            override fun onItemClick(coin: Data) {
                //TODO Diğer ekrana push
            }
        })
        binding.recyclerView.adapter = mAdapter
        mAdapter.setList(data)
    }

    private fun handleViews(isLoading: Boolean = false) {
        binding.recyclerView.isVisible = !isLoading
        binding.progressMain.isVisible = isLoading
    }
}