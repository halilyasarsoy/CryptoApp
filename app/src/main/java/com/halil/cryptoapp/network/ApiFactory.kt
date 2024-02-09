package com.halil.cryptoapp.network

import com.halil.cryptoapp.model.detail.DetailResponse
import com.halil.cryptoapp.model.home.CryptoRespone
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//END POINT : https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?limit=10
//HEADER : X-CMC_PRO_API_KEY
//API KEY : 3d871177-214c-439e-80a3-d87a9fc1cc4d
interface ApiFactory {
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getData(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("limit") limit: String
    ): CryptoRespone

    @GET("v1/cryptocurrency/info")
    suspend fun getDetail(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("symbol") symbol: String
    ): DetailResponse
}