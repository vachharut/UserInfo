package info.user.utils

import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions


fun showImageView(
    imageView: AppCompatImageView,
    @DrawableRes placeholder: Int,
    imageUrl: String
) {
    val glideUrl = GlideUrl(
        imageUrl, LazyHeaders.Builder()
            .addHeader("User-Agent", "your-user-agent")
            .build()
    )
    val options = RequestOptions()
        .placeholder(placeholder)
        .error(placeholder)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .priority(Priority.HIGH)
        .centerInside()
    Glide.with(imageView.context)
        .load(glideUrl)
        .apply(options)
        .into(imageView)
}
