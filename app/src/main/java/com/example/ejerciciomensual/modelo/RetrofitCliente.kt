package com.example.ejerciciomensual.modelo

import com.example.ejerciciomensual.InterfaceApi.ApiService
import com.example.ejerciciomensual.InterfaceApi.RegistroApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitCliente {

    private const val BASE_URL = "http://10.115.22.102/api_cursos/"

    private val jsonConfig = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        isLenient = true
    }

    private val retrofit: Retrofit by lazy {
        val contentType = "application/json".toMediaType()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(jsonConfig.asConverterFactory(contentType))
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    val registroApi: RegistroApi by lazy {
        retrofit.create(RegistroApi::class.java)
    }

    val inscripcionesApi: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}