package com.example.lokakaka.welcomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lokakaka.R
import com.wang.avi.AVLoadingIndicatorView

class WelcomeFragment: Fragment() {

    lateinit var welcomeIndicator: AVLoadingIndicatorView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_welcome, container, false)


    companion object {
        fun newInstance(): WelcomeFragment = WelcomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeIndicator = getView()?.findViewById(R.id.indicatorWelcome)!!

        welcomeIndicator.bringToFront()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        welcomeIndicator.visibility = View.GONE
    }

}