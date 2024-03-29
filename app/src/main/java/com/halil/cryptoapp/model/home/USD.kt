package com.halil.cryptoapp.model.home


import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("fully_diluted_market_cap")
    val fullyDilutedMarketCap: Double?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("market_cap")
    val marketCap: Double?,
    @SerializedName("market_cap_dominance")
    val marketCapDominance: Double?,
    @SerializedName("percent_change_1h")
    val percentChange1h: Double?,
    @SerializedName("percent_change_24h")
    val percentChange24h: Double?,
    @SerializedName("percent_change_7d")
    val percentChange7d: Double?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("volume_24h")
    val volume24h: Double?,
    @SerializedName("volume_change_24h")
    val volumeChange24h: Double?
)