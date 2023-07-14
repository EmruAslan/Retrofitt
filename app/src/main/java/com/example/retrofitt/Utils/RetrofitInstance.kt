package com.example.retrofitt.Utils

import com.example.retrofitt.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api:ApiInterface by lazy {
        Retrofit.Builder().baseUrl(Utils.Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

}