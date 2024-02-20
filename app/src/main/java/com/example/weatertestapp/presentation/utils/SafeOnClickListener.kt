package com.example.weatertestapp.presentation.utils

import android.view.View

class SafeOnClickListener : View.OnClickListener {
    private var mTime: Long? = null
    private val mDestinationOnClickListener: View.OnClickListener?

    constructor() {
        mDestinationOnClickListener = View.OnClickListener { view: View ->
            onSafeClick(
                view
            )
        }
    }

    constructor(clickListener: View.OnClickListener?) {
        mDestinationOnClickListener = clickListener
    }

    override fun onClick(view: View) {
        val time = System.currentTimeMillis()
        var isSafeClick = false
        if (mTime == null) {
            mTime = time
            isSafeClick = true
        } else {
            if (time - mTime!! >= 500) {
                mTime = time
                isSafeClick = true
            }
        }
        if (mDestinationOnClickListener != null && isSafeClick) {
            mDestinationOnClickListener.onClick(view)
        }
    }

    protected fun onSafeClick(view: View) { }
}