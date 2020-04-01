package com.owenlejeune.simpletextinputlayout.tools

import android.content.Context
import android.os.Build
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

object ColorUtils {

    @Suppress("DEPRECATION")
    @ColorInt
    fun getColorResForAttr(context: Context, @AttrRes attrRes: Int): Int {
        val typedValue = TypedValue()
        val theme = context.theme
        theme.resolveAttribute(attrRes, typedValue, true)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.resources.getColor(typedValue.resourceId, theme)
        } else {
            context.resources.getColor(typedValue.resourceId)
        }
    }

}