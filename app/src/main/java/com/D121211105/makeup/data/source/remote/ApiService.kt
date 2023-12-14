package com.D121211105.makeup.data.source.remote

import com.D121211105.makeup.data.response.GetMakeupResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("api/v1/products.json") // https://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline
    suspend fun getMakeup(
        @Query("brand") brand : String = "maybelline"
    ) : GetMakeupResponse
}