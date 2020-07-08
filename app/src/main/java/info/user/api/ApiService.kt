package info.user.api

import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}
