package com.cloverflavor.nhkplusw

import android.os.Bundle
import android.webkit.WebView
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {
    lateinit var web: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        web = findViewById(R.id.web)
        web.settings.javaScriptEnabled = true
        web.loadUrl("https://plus.nhk.jp/")
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//            .replace(R.id.main_browse_fragment, MainFragment()) http://192.168.0.6:8000/
//            .commitNow()
//        }
    }
}