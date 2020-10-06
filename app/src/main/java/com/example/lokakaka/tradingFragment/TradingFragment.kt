package com.example.lokakaka.tradingFragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.lokakaka.R
import com.wang.avi.AVLoadingIndicatorView

class TradingFragment: Fragment() {

    private lateinit var webView: WebView
    lateinit var tradingIndicator: AVLoadingIndicatorView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_trading, container, false)


    companion object {
        fun newInstance(): TradingFragment = TradingFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tradingIndicator = getView()?.findViewById(R.id.indicatorTrading)!!
        tradingIndicator.bringToFront()
        webView = getView()?.findViewById(R.id.tradingWebView)!!
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                tradingIndicator.visibility = View.GONE
            }
        }
        webView.clearCache(true)
        webView.clearHistory()
        webView.settings.javaScriptEnabled = true
        webView.setBackgroundColor(Color.TRANSPARENT)
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.loadUrl(getString(R.string.trading_calculator_url))

    }

}