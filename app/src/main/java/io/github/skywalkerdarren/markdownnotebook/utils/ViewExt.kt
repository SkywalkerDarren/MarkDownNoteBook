package io.github.skywalkerdarren.markdownnotebook.utils

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.Utils

fun TypedArray.use(block: TypedArray.() -> Unit) {
    try {
        block(this)
    } finally {
        recycle()
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Int.color(): Int = ContextCompat.getColor(Utils.getApp(), this)

fun Int.string(): String = Utils.getApp().getString(this)

fun Int.drawable(): Drawable = ContextCompat.getDrawable(Utils.getApp(), this)
    ?: throw NullPointerException("no drawable found")