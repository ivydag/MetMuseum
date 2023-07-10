package com.ivy.dev.metmuseum.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase


@Entity
data class GalleryItemRoom(
    @PrimaryKey val galleryid: Int,
    val floor: Int,
    val gallerynumber: String,
    val id: Int,
    val lastupdate: String,
    val name: String,
    val objectcount: Int,
    val theme: String
)

@Dao
interface GalleryDao {
    @Query("Select * FROM GalleryItemRoom")
    fun getAllGallery(): LiveData<List<GalleryItemRoom>>

    @Insert
    fun insertAllGallery(vararg menuItem: GalleryItemRoom)

    @Query("SELECT (SELECT COUNT(*) FROM GalleryItemRoom) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [GalleryItemRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun galleryDao(): GalleryDao
}