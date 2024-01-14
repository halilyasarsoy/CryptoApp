package com.halil.cryptoapp.model.home


import com.google.gson.annotations.SerializedName

data class CryptoRespone(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("status")
    val status: Status?
)