package info.user.app

import android.app.Application
import info.user.api.ApiService

class App : Application() {

    val apiService: ApiService by lazy { NetworkModule().provideApiService() }
}
