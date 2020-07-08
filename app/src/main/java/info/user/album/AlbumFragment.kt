package info.user.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.navArgs
import info.user.databinding.FragmentAlbumBinding
import info.user.utils.ViewModelFactory
import info.user.utils.app
import info.user.utils.viewModel

class AlbumFragment : Fragment() {

    private val albumViewModelFactory by lazy { AlbumViewModelFactory() }
    private val albumViewModel: AlbumViewModel by viewModel { albumViewModelFactory.create(it) }
    private val args: AlbumFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAlbumBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = albumViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    inner class AlbumViewModelFactory() : ViewModelFactory<AlbumViewModel> {

        override fun create(handle: SavedStateHandle): AlbumViewModel {
            return AlbumViewModel(
                app.apiService,
                args.albumId,
                handle
            )
        }
    }
}
