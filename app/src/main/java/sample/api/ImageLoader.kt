package sample.api

import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoader {

    fun load(imageView: ImageView, url: String) {
        Glide
            .with(imageView)
            .load(url)
            .into(imageView)
    }
}