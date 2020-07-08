package info.user.album

import android.os.Parcelable
import info.user.api.Photo
import kotlinx.android.parcel.Parcelize

typealias PhotoModelList = List<PhotoModel>

@Parcelize
data class PhotoModel(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Parcelable

fun Photo.toPhotoModel() = PhotoModel(
    albumId = albumId,
    id = id,
    title = title,
    url = url,
    thumbnailUrl = thumbnailUrl
)
