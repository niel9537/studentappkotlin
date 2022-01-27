package com.devniel.studentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { ApiRetrofit().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        api.data().enqueue(object : Callback<ValuesModel>{
            override fun onFailure(call: Call<ValuesModel>, t: Throwable) {
                Log.e("MainActivity",t.toString())
            }

            override fun onResponse(call: Call<ValuesModel>, response: Response<ValuesModel>) {
                if(response.isSuccessful){
                    val listData = response.body()!!.values
                    listData.forEach({
                        Log.e("MainActivity","Nama : ${it.nama}")
                    })
                }

            }
        })
    }
}