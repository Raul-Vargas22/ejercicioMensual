package com.example.ejerciciomensual.modelo

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitCliente {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val apiService: RegistroApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.100.36:8080/registro_api/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(RegistroApi::class.java)
    }
}