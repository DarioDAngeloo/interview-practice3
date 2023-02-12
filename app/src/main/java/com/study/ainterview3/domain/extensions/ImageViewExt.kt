package com.study.ainterview3.domain.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromApi(url : String){
    Glide.with(this).load(url).into(this)
}