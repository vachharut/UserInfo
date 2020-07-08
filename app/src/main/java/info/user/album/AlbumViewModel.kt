package info.user.album

import androidx.lifecycle.*
import info.user.api.ApiService
import kotlinx.coroutines.*

class AlbumViewModel(
    private val service: ApiService,
    val albumId: Int,
    handle: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val PHOTOS_MODEL_KEY = "PhotosModelKey"
    }

    private val mutablePhotos: MutableLiveData<PhotoModelList> =
        handle.getLiveData(PHOTOS_MODEL_KEY)
    val photos: LiveData<PhotoModelList> = mutablePhotos

    init {
        fetchPhotos(albumId)
    }


    private fun fetchPhotos(albumId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            if (!mutablePhotos.value.isNullOrEmpty()) {
                return@launch
            }
            mutablePhotos.postValue(
                try {
                    service.getPhotos()
                        .map {
                            it.toPhotoModel()
                        }
                        .filter {
                            it.albumId == albumId
                        }
                        .toList()
                } catch (exception: Exception) {
                    emptyList<PhotoModel>()
                }

            )
        }
    }
}
