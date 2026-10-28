package Modelo

import com.example.ejerciciomensual.InterfaceApi.ApiService
import kotlinx.serialization.json.Json
object RetrofitCliente {
    private const val BASE_URL="http://192.168.1.100/api_cursos/"///aqui ira la URL del api

    private val jsonConfig = Json {
        ignoreUnknownKeys = true
        coerceInputValues= true
        isLeteinit= true
    }

    val apiService: ApiService by lazy {
        val contenType = "application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConvertFactory(jsonConfig.asConvertFactory(contenType= contenType))
            .build()
            .create(ApiService::class.java)
    }
}