package com.moataz.mox.utils.helper

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun loadImage(view: View, imageUrl: String?) {
    val image: ImageView = view as ImageView
    image.load(imageUrl)
}