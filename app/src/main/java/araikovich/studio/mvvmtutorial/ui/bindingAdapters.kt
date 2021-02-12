package araikovich.studio.mvvmtutorial.ui

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("app:imageUrl")
fun loadImageUrl(view: AppCompatImageView, imageUrl: String) {
    Glide.with(view)
        .load(imageUrl)
        .circleCrop()
        .into(view)
}