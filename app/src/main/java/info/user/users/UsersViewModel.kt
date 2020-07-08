package info.user.users

import androidx.lifecycle.*
import info.user.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(
    private val service: ApiService,
    handle: SavedStateHandle
) : ViewModel() {

    companion object {
        const val USERS_MODEL_KEY = "UsersModelKey"
    }

    private val mutableUsers: MutableLiveData<UserModelList> =
        handle.getLiveData(USERS_MODEL_KEY)
    val users: LiveData<UserModelList> = mutableUsers

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            if (!mutableUsers.value.isNullOrEmpty()) {
                return@launch
            }
            mutableUsers.postValue(
                try {
                    service.getUsers()
                        .map {
                            it.toUserModel()
                        }
                        .toList()
                } catch (exception: Exception) {
                    emptyList<UserModel>()
                }

            )
        }
    }
}
