package com.ivy.dev.metmuseum.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.harvardartmuseums.org"
    private const val API_KEY = "285c52ea-7761-48de-bf4a-e83d8f2a0408"
    private const val KEY_NAME = "apikey"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originRequest = chain.request()
            val modifierRequest = originRequest.newBuilder()
                .header(KEY_NAME, API_KEY)
                .build()
            chain.proceed(modifierRequest)
        }
        .build()

    fun createNetwork(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

}