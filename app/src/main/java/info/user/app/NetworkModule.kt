package info.user.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import info.user.api.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    fun provideApiService(): ApiService {
        return provideRetrofit().create(ApiService::class.java)
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    private fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }
}
