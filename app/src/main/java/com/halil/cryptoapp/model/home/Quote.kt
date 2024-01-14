package com.halil.cryptoapp.model.home


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("BTC")
    val bTC: BTC?,
    @SerializedName("USD")
    val uSD: USD?
)