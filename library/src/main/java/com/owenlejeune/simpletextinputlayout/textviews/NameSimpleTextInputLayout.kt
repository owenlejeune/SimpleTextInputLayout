package com.owenlejeune.simpletextinputlayout.textviews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.owenlejeune.simpletextinputlayout.R
import com.owenlejeune.simpletextinputlayout.SimpleTextInputLayout

class NameSimpleTextInputLayout @JvmOverloads constructor(context: Context,
                                                           attrs: AttributeSet? = null,
                                                           defStyleAttr: Int = 0)
    : SimpleTextInputLayout(context, attrs, defStyleAttr) {

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.NameSimpleTextInputLayout, 0, 0)
            .apply { setHint(this) }
    }

    private fun setHint(arr: TypedArray) {
        try {
            val type = arr.getInt(R.styleable.NameSimpleTextInputLayout_type, -1)
            val hint = when (type) {
                0 -> R.string.first_name_hint
                1 -> R.string.last_name_hint
                else -> R.string.name_hint
            }
            setHint(hint)
        } finally {
            arr.recycle()
        }
    }

}