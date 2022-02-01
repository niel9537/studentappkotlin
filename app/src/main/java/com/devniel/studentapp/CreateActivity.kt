package com.devniel.studentapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {
    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var edtNim: EditText
    private lateinit var edtNama: EditText
    private lateinit var edtJurusan: EditText
    private lateinit var btnTambah: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setupView()
        setupListener()
    }

    private fun setupView(){
        edtNim = findViewById(R.id.edtNim)
        edtNama = findViewById(R.id.edtNama)
        edtJurusan = findViewById(R.id.edtJurusan)
        btnTambah = findViewById(R.id.btnTambah)
    }

    private fun setupListener(){
        btnTambah.setOnClickListener{
            if(edtNim.text.toString().isNotEmpty()){
                if(edtJurusan.text.toString().isNotEmpty()){
                   if(edtNama.text.toString().isNotEmpty()){
                       api.create(edtNim.text.toString(), edtNama.text.toString(),edtJurusan.text.toString() )
                           .enqueue(object : Callback<CreatesModel> {
                               override fun onResponse(
                                   call: Call<CreatesModel>,
                                   response: Response<CreatesModel>
                               ) {
                                   if(response.isSuccessful){
                                       val result = response.body()
                                       Toast.makeText(
                                           applicationContext,
                                           result!!.status,
                                           Toast.LENGTH_SHORT
                                       ).show()
                                       startActivity(Intent(applicationContext, MainActivity::class.java))
                                   }
                               }

                               override fun onFailure(call: Call<CreatesModel>, t: Throwable) {
                                   TODO("Not yet implemented")
                               }

                           })
                   }else{
                       Toast.makeText(applicationContext,"Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
                   }
                }else{
                    Toast.makeText(applicationContext,"Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext,"Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }

        }
    }
}