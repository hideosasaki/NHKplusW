package com.cloverflavor.nhkplusw

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.webkit.WebView

/**
 * TODO: document your custom view class.
 */
class MyWebView(context: Context, attributeSet: AttributeSet) : WebView(context, attributeSet) {

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        var handled = false
        when (keyCode) {
            KeyEvent.KEYCODE_MENU -> {
                handled = true
                this.evaluateJavascript("document.getElementById('searchbtn').click()", null)
                this.evaluateJavascript("document.getElementById('keyword').focus()", null)
            }
        }
        return handled || super.onKeyDown(keyCode, event)
    }

}