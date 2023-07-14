package com.example.retrofitt

import com.example.retrofitt.models.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    suspend fun getAllUsers():Response<Users>
}