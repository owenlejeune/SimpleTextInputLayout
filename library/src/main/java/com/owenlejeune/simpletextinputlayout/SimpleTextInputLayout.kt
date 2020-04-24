package com.owenlejeune.simpletextinputlayout

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.owenlejeune.simpletextinputlayout.tools.ColorUtils

open class SimpleTextInputLayout @JvmOverloads constructor(context: Context,
                                                           attrs: AttributeSet? = null,
                                                           defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr) {

    var mTextInputLayout: TextInputLayout
    var mTextInputEditText: TextInputEditText

    init {
        orientation = VERTICAL

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(getLayout(), this, true)

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

    @LayoutRes
    open fun getLayout(): Int = R.layout.text_input_layout

    private fun applyAttributes(arr: TypedArray) {
        try {
            arr.getString(R.styleable.SimpleTextInputLayout_hint)?.let { setHint(it) }

            val backgroundColor = arr.getColor(R.styleable.SimpleTextInputLayout_backgroundColor, 0)
            if (backgroundColor != 0) {
                setBackgroundColor(backgroundColor)
            }

            val errorColor = arr.getColor(R.styleable.SimpleTextInputLayout_errorTextColor, Color.RED)
            mTextInputLayout.setErrorTextColor(ColorStateList.valueOf(errorColor))

            val hintColor = arr.getColor(R.styleable.SimpleTextInputLayout_hintTextColor, 0)
            if (hintColor != 0) {
                setHintColor(hintColor)
            }

            val iconTint = arr.getColor(R.styleable.SimpleTextInputLayout_endIconTint,
                ColorUtils.getColorResForAttr(context, android.R.attr.colorPrimary))
            setEndIconTint(iconTint)

            val boxStrokeColor = arr.getColor(R.styleable.SimpleTextInputLayout_boxStrokeColor, 0)
            if (boxStrokeColor != 0) {
                setBoxStrokeColor(boxStrokeColor)
            }

            val textColor = arr.getColor(R.styleable.SimpleTextInputLayout_textColor, 0)
            if (textColor != 0) {
                setTextColor(textColor)
            }
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

    fun setText(text: CharSequence) {
        mTextInputEditText.setText(text)
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

    override fun setBackgroundColor(@ColorInt color: Int) {
        mTextInputEditText.setBackgroundColor(color)
        mTextInputLayout.setBackgroundColor(color)
    }

    fun setErrorColor(@ColorInt color: Int) {
        setErrorColor(ColorStateList.valueOf(color))
    }

    fun setErrorColor(stateList: ColorStateList) {
        mTextInputLayout.setErrorTextColor(stateList)
    }

    fun setHintColor(@ColorInt color: Int) {
        setHintColor(ColorStateList.valueOf(color))
    }

    fun setHintColor(stateList: ColorStateList) {
        mTextInputLayout.defaultHintTextColor = stateList
    }

    fun setEndIconTint(@ColorInt color: Int) {
        setEndIconTint(ColorStateList.valueOf(color))
    }

    fun setEndIconTint(stateList: ColorStateList) {
        mTextInputLayout.setEndIconTintList(stateList)
    }

    fun setBoxStrokeColor(@ColorInt color: Int) {
        mTextInputLayout.boxStrokeColor = color
    }

    fun setTextColor(@ColorInt color: Int) {
        mTextInputEditText.setTextColor(color)
    }

}