package info.user.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import info.user.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment() {
    private val navArgs: PhotoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPhotoBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            args = navArgs
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

}
