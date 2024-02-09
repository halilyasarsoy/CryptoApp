package com.halil.cryptoapp.ui.detail

import com.halil.cryptoapp.base.BaseRepository
import com.halil.cryptoapp.network.ApiFactory
import javax.inject.Inject

class DetailRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {
    suspend fun getDetail(
        apiKey: String,
        symbol: String,
    ) = safeApiRequest { apiFactory.getDetail(apiKey, symbol) }
}