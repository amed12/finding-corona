package com.sun3toline.fico.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.sun3toline.fico.R

class CustomController @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attributes, defStyle) {
    init {
        LayoutInflater
            .from(context)
            .inflate(
                R.layout.view_custom,
                this,
                true
            )
    }

}