package info.user.album

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("photos")
fun setAlbumRecyclerItems(
    recyclerView: RecyclerView,
    album: List<PhotoModel>?
) {
    var adapter = (recyclerView.adapter as? AlbumRecyclerAdapter)
    if (adapter == null) {
        adapter = AlbumRecyclerAdapter()
        recyclerView.adapter = adapter
    }
    adapter.update(album.orEmpty())
}
