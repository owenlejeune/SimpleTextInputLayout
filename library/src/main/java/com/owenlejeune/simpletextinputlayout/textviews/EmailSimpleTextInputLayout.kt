package com.owenlejeune.simpletextinputlayout.textviews

import android.content.Context
import android.util.AttributeSet
import android.util.Patterns
import com.owenlejeune.simpletextinputlayout.R
import com.owenlejeune.simpletextinputlayout.SimpleTextInputLayout

class EmailSimpleTextInputLayout @JvmOverloads constructor(context: Context,
                                                          attrs: AttributeSet? = null,
                                                          defStyleAttr: Int = 0)
    : SimpleTextInputLayout(context, attrs, defStyleAttr) {

    init {
        setHint(R.string.email_hint)
    }

    override fun getLayout(): Int = R.layout.email_text_input_layout

    fun isValidEmailAddress(): Boolean {
        return getText()?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() }
            ?: false
    }

}