package com.halil.cryptoapp.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.halil.cryptoapp.util.loadImage

class CoinBinding {
    //"https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
    companion object {
        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(imageView: ImageView, coinImage: String) {
            val imageUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/$coinImage.png"
            imageView.loadImage(imageUrl)
        }
    }
}