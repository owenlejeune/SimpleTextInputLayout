package com.owenlejeune.simpletextinputlayout.textviews

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import com.owenlejeune.simpletextinputlayout.SimpleTextInputLayout

class NumericSimpleTextInputLayout @JvmOverloads constructor(context: Context,
                                                             attrs: AttributeSet? = null,
                                                             defStyleAttr: Int = 0)
    : SimpleTextInputLayout(context, attrs, defStyleAttr) {

    init {
        overrideInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL)
    }

}