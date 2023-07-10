package com.ivy.dev.metmuseum.ui.viewmodel.gallery

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivy.dev.metmuseum.data.models.GalleryResponse
import com.ivy.dev.metmuseum.data.repository.GalleryRepository
import kotlinx.coroutines.launch

class GalleryViewModel(val galleryRepository: GalleryRepository):ViewModel() {
    private val _galleryData = mutableStateOf<GalleryResponse?>(null)
    val galleryData: State<GalleryResponse?> = _galleryData

    fun fetchGallery(){
        viewModelScope.launch {
            try {
                val response = galleryRepository.getGallery()
                _galleryData.value = response
            }catch (e: Exception){
                Log.d(CLASS_NAME, e.message.toString())
            }
        }
    }

    companion object{
        const val CLASS_NAME = "GalleryViewModel"
    }

}