package info.user.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import info.user.BR
import info.user.R

class UsersRecyclerAdapter() : RecyclerView.Adapter<UsersRecyclerAdapter.UserVH>() {
    private val users = mutableListOf<UserModel>()

    fun update(newUsers: UserModelList) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.view_user_item,
            parent,
            false
        )
        return UserVH(binding)
    }

    override fun getItemId(id: Int): Long = id.toLong()

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = users[position]
        holder.binding.apply {
            setVariable(BR.model, user)
            root.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    UsersFragmentDirections.actionUsersToAlbum(user.id)
                )
            }
            executePendingBindings()
        }
    }

    class UserVH(
        val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
