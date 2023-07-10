package com.ivy.dev.metmuseum.data.repository

import com.ivy.dev.metmuseum.data.models.GalleryResponse
import com.ivy.dev.metmuseum.network.ApiService

class GalleryRepositoryImpl(private val apiService: ApiService): GalleryRepository {
    override suspend fun getGallery(): GalleryResponse {
        return apiService.getGallery()
    }
}