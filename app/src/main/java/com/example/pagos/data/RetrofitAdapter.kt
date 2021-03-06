package com.example.pagos.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAdapter {
    private var API_SERVICE: Service? = null// <-- usamos el log level

    /**
     * Creamos un interceptor y le indicamos el log level a usar
     */
    val apiService: Service
        /**
         * Asociamos el interceptor a las peticiones
         * Creamos un interceptor y le indicamos el log level a usar
         */
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            // Asociamos el interceptor a las peticiones
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            val baseUrl = "https://dev.placetopay.com/rest/"
            if (API_SERVICE == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build()
                API_SERVICE = retrofit.create(Service::class.java)
            }
            return API_SERVICE!!
        }
}