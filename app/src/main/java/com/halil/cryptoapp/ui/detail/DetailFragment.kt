package com.halil.cryptoapp.ui.detail

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.halil.cryptoapp.base.BaseFragment
import com.halil.cryptoapp.databinding.FragmentDetailBinding
import com.halil.cryptoapp.model.detail.CoinDetail
import com.halil.cryptoapp.model.detail.DetailResponse
import com.halil.cryptoapp.util.Constants.API_KEY
import com.halil.cryptoapp.util.loadImage
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateFinish() {
        viewModel.getDetail(API_KEY, args.symbol)
    }

    override fun initializeListeners() {

    }

    override fun observeEvents() {
        with(viewModel) {
            detailResponse.observe(viewLifecycleOwner) {
                parseData(it)
            }
            isLoading.observe(viewLifecycleOwner) {
                handleView(it)
            }
            onError.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun parseData(it: DetailResponse?) {
        val gson = Gson()
        val json = gson.toJson(it?.data)
        val jsonObject = JSONObject(json)

        val jsonValue = jsonObject[args.symbol]
        if (jsonValue is JSONObject) {
            val coin = gson.fromJson(jsonValue.toString(), CoinDetail::class.java)
            coin?.let {
                with(binding) {
                    ivDetail.loadImage(it.logo)
                    tvDetailTitle.text = it.name
                    tvDetailSymbol.text = it.symbol
                    tvDetailDesc.text = it.description
                }
            }
        } else {
            // Hatalı durum
            // Burada uygun bir işlem yapılmalı, örneğin hata işleme veya loglama gibi
        }
    }


    private fun handleView(isLoading: Boolean = true) {
        binding.detailGroup.isVisible = !isLoading
        binding.pbDetail.isVisible = isLoading
    }

}