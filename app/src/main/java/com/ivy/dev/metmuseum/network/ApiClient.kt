package com.ivy.dev.metmuseum.network

import com.ivy.dev.metmuseum.config.Config.API_KEY
import com.ivy.dev.metmuseum.config.Config.KEY_NAME
import com.ivy.dev.metmuseum.data.repository.GalleryRepository
import com.ivy.dev.metmuseum.data.repository.GalleryRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.harvardartmuseums.org"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor { chain ->
            val originRequest = chain.request()
            val modifiedUrl = originRequest.url.newBuilder()
                .addQueryParameter(KEY_NAME, API_KEY)
                .build()
            val modifiedRequest = originRequest.newBuilder()
                .url(modifiedUrl)
                .build()
            chain.proceed(modifiedRequest)
        }
        .build()

    private fun createNetwork(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    fun getGalleryRepository(): GalleryRepository{
        val apiService = createNetwork()
        return GalleryRepositoryImpl(apiService)
    }

}