package com.ivy.dev.metmuseum.network

import com.ivy.dev.metmuseum.config.Config.API_KEY
import com.ivy.dev.metmuseum.config.Config.KEY_NAME
import com.ivy.dev.metmuseum.data.models.GalleryResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
//TODO fix the list
    @Headers(KEY_NAME,API_KEY)
    @GET("gallery")
    suspend fun getGallery(): GalleryResponse
}