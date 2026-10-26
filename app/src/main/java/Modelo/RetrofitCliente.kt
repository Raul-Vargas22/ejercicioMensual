package Modelo

import com.example.ejerciciomensual.InterfaceApi.ApiService
import retrofit2.Retrofit

object RetrofitCliente {
    private const val BASE_URL=""///aqui ira la URL del api

    private val jsonConfig = json {

    }

    val apiService: ApiService by lazy {
        val contenType = "aplication/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConvertFactory(jsonConfig.asConvertFactory(contenType= contenType))
            .build()
            .create(ApiService::class.java)
    }
}