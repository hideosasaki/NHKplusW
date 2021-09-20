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
                evaluateJavascript("""
                    var slideShows = document.getElementsByTagName('main')[0].ariaHidden;
                    if (slideShows == null || slideShows == 'false') {
                        document.getElementById('searchbtn').click();
                        document.getElementById('keyword').focus();
                    } else if (document.querySelectorAll('#tab-calender.-active').length > 0) { 
                        document.getElementById('searchbtn').click();
                        document.querySelectorAll('#swiper-wrapper a')[0].focus();
                    } else {
                        document.getElementById('tab-calender').click();
                        document.getElementById('channel_G').focus();
                    }
                    """
                ) { }
                handled = true
            }
//            KeyEvent.KEYCODE_MEDIA_REWIND -> {
//                evaluateJavascript("""
//                    if (document.getElementsByTagName('main')[0].ariaHidden == 'false') {
//                        document.querySelectorAll('#swiper-wrapper a')[0].focus();
//                    } else {
//                        document.getElementById('tab-keyword').click();
//                        document.getElementById('keyword').click();
//                    }
//                    """
//                ) { }
//                handled = true
//            }
//            KeyEvent.KEYCODE_MEDIA_FAST_FORWARD -> {
//                evaluateJavascript("""
//                    if (document.getElementsByTagName('main')[0].ariaHidden == 'false') {
//                        document.querySelectorAll('#swiper-wrapper a')[1].focus();
//                    } else {
//                        document.getElementById('tab-calender').click();
//                        document.getElementById('channel_G').focus();
//                    }
//                    """
//                ) { }
//                handled = true
//            }
//            KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE -> {
//                evaluateJavascript("""
//                    document.activeElement.click();
//                    """
//                ) { }
//                handled = true
//            }
//            KeyEvent.KEYCODE_BACK -> {
//                evaluateJavascript("""
//                    if (document.getElementsByTagName('main')[0].ariaHidden == 'false') {
//                        return 'false';
//                    } else {
//                        document.getElementById('searchbtn').click();
//                        return 'true';
//                    }
//                    """
//                ) { handled = it.toBoolean() }
//            }
        }
        return handled || super.onKeyDown(keyCode, event)
    }

}