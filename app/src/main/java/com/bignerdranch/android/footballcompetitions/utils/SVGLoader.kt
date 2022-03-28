package com.bignerdranch.android.footballcompetitions.utils

import android.content.Context
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

class SVGLoader {

    fun loadImage(url: String?, context: Context, imageView: ImageView) {

        val imageLoader = ImageLoader.Builder(context)
            .componentRegistry { add(SvgDecoder(context)) }
            .build()

        val request = ImageRequest.Builder(context)
            .data(url)
            .target(imageView)
            .build()

        imageLoader.enqueue(request)
    }
}