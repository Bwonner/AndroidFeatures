package com.example.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import javax.inject.Inject

class ResourceProvider @Inject constructor(
    private val context: Context
) {
    fun getString(@StringRes id: Int) = context.getString(id)

    fun getString(@StringRes id: Int, vararg formatArgs: Any?) =
        context.getString(id).format(*formatArgs)

    fun getQuantityString(@PluralsRes id: Int, number: Int) =
        context.resources.getQuantityString(id, number, number)

    fun getDrawable(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(context, id)
}