package com.ivy.dev.metmuseum.data.repository

import com.ivy.dev.metmuseum.data.models.GalleryResponse

interface GalleryRepository {
    suspend fun getGallery(): GalleryResponse
}