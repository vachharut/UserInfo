package info.user.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelFactory<T : ViewModel> {
    fun create(handle: SavedStateHandle): T
}

inline fun <reified T : ViewModel> Fragment.viewModel(
    crossinline provider: (SavedStateHandle) -> T
) = viewModels<T> {
    object : AbstractSavedStateViewModelFactory(this, Bundle()) {
        @Suppress("UNCHECKED_CAST")
        override fun <R : ViewModel?> create(
            key: String,
            modelClass: Class<R>,
            handle: SavedStateHandle
        ): R = provider(handle) as R
    }
}
