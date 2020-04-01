package com.owenlejeune.simpletextinputlayout

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.os.Build
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.owenlejeune.simpletextinputlayout.tools.ColorUtils

open class SimpleTextInputLayout @JvmOverloads constructor(context: Context,
                                                           attrs: AttributeSet? = null,
                                                           defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr) {

    private var mTextInputLayout: TextInputLayout
    private var mTextInputEditText: TextInputEditText

    init {
        orientation = VERTICAL

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.text_input_layout, this, true)

        mTextInputLayout = view.findViewById(R.id.text_input_root)
        mTextInputEditText = view.findViewById(R.id.text_input_child)

        mTextInputLayout.isFocusableInTouchMode = true

        context.theme.obtainStyledAttributes(attrs, R.styleable.SimpleTextInputLayout, 0, 0)
            .apply { applyAttributes(this) }

        mTextInputEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { /* Not Implemented */ }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { /* Not Implemented */ }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearError()
            }

        })
    }

    private fun applyAttributes(arr: TypedArray) {
        try {
            arr.getString(R.styleable.SimpleTextInputLayout_hint)?.let { setHint(it) }

            val backgroundColor = arr.getColor(R.styleable.SimpleTextInputLayout_backgroundColor,
                ColorUtils.getColorResForAttr(context, android.R.attr.background))
            mTextInputEditText.setBackgroundColor(backgroundColor)

            val errorColor = arr.getColor(R.styleable.SimpleTextInputLayout_errorTextColor,
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    ColorUtils.getColorResForAttr(context, android.R.attr.colorError)
                else Color.RED)
            mTextInputLayout.setErrorTextColor(ColorStateList.valueOf(errorColor))

            val hintColor = arr.getColor(R.styleable.SimpleTextInputLayout_hintTextColor,
                ColorUtils.getColorResForAttr(context, android.R.attr.hint))
            mTextInputLayout.defaultHintTextColor = ColorStateList.valueOf(hintColor)

            val iconTint = arr.getColor(R.styleable.SimpleTextInputLayout_endIconTint,
                ColorUtils.getColorResForAttr(context, android.R.attr.colorPrimary))
            mTextInputLayout.setEndIconTintList(ColorStateList.valueOf(iconTint))

            val boxStrokeColor = arr.getColor(R.styleable.SimpleTextInputLayout_boxStrokeColor,
                ColorUtils.getColorResForAttr(context, android.R.attr.strokeColor))
            mTextInputLayout.boxStrokeColor = boxStrokeColor

            val textColor = arr.getColor(R.styleable.SimpleTextInputLayout_textColor,
                ColorUtils.getColorResForAttr(context, android.R.attr.textColor))
            mTextInputEditText.setTextColor(textColor)
        } finally {
            arr.recycle()
        }
    }

    fun getText(): Editable? = mTextInputEditText.text

    fun getString(): String = getText()?.toString() ?: ""

    fun setHint(hint: CharSequence) {
        mTextInputLayout.hint = hint
    }

    fun setHint(@StringRes hint: Int) {
        mTextInputLayout.hint = context.getString(hint)
    }

    fun overrideInputType(inputType: Int) {
        mTextInputEditText.inputType = inputType
    }

    fun setEndIconMode(@TextInputLayout.EndIconMode iconMode: Int) {
        mTextInputLayout.endIconMode = iconMode
    }

    fun applyFilters(vararg filters: InputFilter) {
        mTextInputEditText.filters = filters
    }

    fun setError(error: CharSequence) {
        mTextInputLayout.error = error
    }

    fun setError(@StringRes error: Int) {
        mTextInputLayout.error = context.getString(error)
    }

    fun clearError() {
        mTextInputLayout.error = ""
    }

}