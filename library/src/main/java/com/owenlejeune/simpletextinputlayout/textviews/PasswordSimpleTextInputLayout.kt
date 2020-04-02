package com.owenlejeune.simpletextinputlayout.textviews

import android.content.Context
import android.content.res.TypedArray
import android.text.InputType
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import com.owenlejeune.simpletextinputlayout.R
import com.owenlejeune.simpletextinputlayout.SimpleTextInputLayout

class PasswordSimpleTextInputLayout @JvmOverloads constructor(context: Context,
                                                               attrs: AttributeSet? = null,
                                                               defStyleAttr: Int = 0)
    : SimpleTextInputLayout(context, attrs, defStyleAttr) {

    init {
        overrideInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE)

        context.theme.obtainStyledAttributes(attrs, R.styleable.PasswordSimpleTextInputLayout, 0, 0)
            .apply { setHint(this) }
    }

    private fun setHint(arr: TypedArray) {
        try {
            val isConfirmation = arr
                .getBoolean(R.styleable.PasswordSimpleTextInputLayout_passwordConfirmation, false)
            val hint = if (isConfirmation) R.string.password_confirm_hint else R.string.password_hint
            setHint(hint)
        } finally {
            arr.recycle()
        }
    }

}