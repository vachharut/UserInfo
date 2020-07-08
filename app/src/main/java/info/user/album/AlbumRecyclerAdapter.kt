package info.user.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import info.user.BR
import info.user.R

class AlbumRecyclerAdapter() : RecyclerView.Adapter<AlbumRecyclerAdapter.PhotoVH>() {
    private val photos = mutableListOf<PhotoModel>()

    fun update(newPhotos: PhotoModelList) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.view_album_item,
            parent,
            false
        )
        return PhotoVH(binding)
    }

    override fun getItemId(id: Int): Long = id.toLong()

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoVH, position: Int) {
        val photo = photos[position]
        holder.binding.apply {
            setVariable(BR.model, photo)
            root.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    AlbumFragmentDirections.actionAlbumToPhoto(
                        albumId = photo.albumId,
                        photoId = photo.id,
                        photoUrl = photo.url,
                        imageText = photo.title
                    )
                )
            }
            executePendingBindings()
        }
    }

    class PhotoVH(
        val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
