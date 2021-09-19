package com.cloverflavor.nhkplusw

import android.os.Bundle
import android.webkit.WebView
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {
    lateinit var webView: MyWebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://plus.nhk.jp/")

    //        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//            .replace(R.id.main_browse_fragment, MainFragment()) http://192.168.0.6:8000/
//            .commitNow()
//        }
    }
}