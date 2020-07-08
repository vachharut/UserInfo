package info.user.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import info.user.databinding.FragmentUsersBinding
import info.user.utils.ViewModelFactory
import info.user.utils.app
import info.user.utils.viewModel

class UsersFragment : Fragment() {

    private val usersViewModelFactory by lazy { UsersViewModelFactory() }
    private val usersViewModel: UsersViewModel by viewModel { usersViewModelFactory.create(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentUsersBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = usersViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    inner class UsersViewModelFactory() : ViewModelFactory<UsersViewModel> {

        override fun create(handle: SavedStateHandle): UsersViewModel {
            return UsersViewModel(
                app.apiService,
                handle
            )
        }
    }
}
