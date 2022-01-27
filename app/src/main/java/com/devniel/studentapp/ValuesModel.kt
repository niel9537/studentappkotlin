package com.devniel.studentapp

data class ValuesModel(
    val status: Int,
    val values: List<Data>
){
    data class Data(val id_mahasiswa : String?, val nim : Int?, val nama : String?, val jurusan : String?)
}
