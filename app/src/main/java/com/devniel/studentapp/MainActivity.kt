package com.devniel.studentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var valuesAdapter: ValuesAdapter
    private lateinit var listValue: RecyclerView
    private lateinit var btnCreate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupList()
        setupView()
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        getValue()
    }

    private fun setupList(){
        listValue = findViewById(R.id.list_item)
        valuesAdapter = ValuesAdapter(arrayListOf())
        listValue.adapter = valuesAdapter
    }
    private fun setupView(){
        listValue = findViewById(R.id.list_item)
        btnCreate = findViewById(R.id.btnCreate)
    }

    private fun setupListener(){
        btnCreate.setOnClickListener{
            startActivity(Intent(this, CreateActivity::class.java))
        }
    }

    private fun getValue(){
        api.data().enqueue(object : Callback<ValuesModel>{
            override fun onFailure(call: Call<ValuesModel>, t: Throwable) {
                Log.e("MainActivity",t.toString())
            }

            override fun onResponse(call: Call<ValuesModel>, response: Response<ValuesModel>) {
                if(response.isSuccessful){
                    val listData = response.body()!!.values
                    valuesAdapter.setData(listData)
//                    listData.forEach({
//                        Log.e("MainActivity","Nama : ${it.nama}")
//                    })
                }

            }
        })
    }
}