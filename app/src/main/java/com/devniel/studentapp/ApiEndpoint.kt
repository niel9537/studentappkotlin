package com.devniel.studentapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("/tampil")
    fun data() : Call<ValuesModel>
}