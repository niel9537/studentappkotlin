package com.devniel.studentapp

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {
    //Tampil data
    @GET("/tampil")
    fun data() : Call<ValuesModel>

    //Tambah data
    @FormUrlEncoded
    @POST("/tambah")
    fun create(
        @Field("nim") nim : String,
        @Field("nama") nama : String,
        @Field("jurusan") jurusan : String
    ) : Call<CreatesModel>
}