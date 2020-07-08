package info.user.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import info.user.R
import info.user.utils.showImageView

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: AppCompatImageView, imageUrl: String) {

    showImageView(
        imageView,
        R.drawable.ic_baseline_blur,
        imageUrl
    )

}
