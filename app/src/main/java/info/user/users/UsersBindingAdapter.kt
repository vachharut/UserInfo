package info.user.users

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("users")
fun setUserRecyclerItems(
    recyclerView: RecyclerView,
    users: List<UserModel>?
) {
    var adapter = (recyclerView.adapter as? UsersRecyclerAdapter)
    if (adapter == null) {
        adapter = UsersRecyclerAdapter()
        recyclerView.adapter = adapter
    }
    adapter.update(users.orEmpty())
}
