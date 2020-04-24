package com.owenlejeune.simpletextinputlayout.textviews

import android.content.Context
import android.util.AttributeSet
import com.owenlejeune.simpletextinputlayout.R
import com.owenlejeune.simpletextinputlayout.SimpleTextInputLayout

class NumericSimpleTextInputLayout @JvmOverloads constructor(context: Context,
                                                             attrs: AttributeSet? = null,
                                                             defStyleAttr: Int = 0)
    : SimpleTextInputLayout(context, attrs, defStyleAttr) {

    override fun getLayout(): Int = R.layout.numeric_text_input_layout

}