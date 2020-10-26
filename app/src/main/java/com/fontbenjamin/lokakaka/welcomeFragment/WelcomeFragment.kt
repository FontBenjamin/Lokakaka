package com.fontbenjamin.lokakaka.welcomeFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.fontbenjamin.lokakaka.R
import com.wang.avi.AVLoadingIndicatorView

class WelcomeFragment: Fragment() {

    lateinit var welcomeIndicator: AVLoadingIndicatorView

    lateinit var buttonWebpage: Button
    lateinit var buttonYoutube: Button
    lateinit var buttonDiscord: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_welcome, container, false)


    companion object {
        fun newInstance(): WelcomeFragment = WelcomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeIndicator = getView()?.findViewById(R.id.indicatorWelcome)!!

        buttonWebpage = getView()?.findViewById(R.id.buttonSyndicate)!!
        buttonYoutube = getView()?.findViewById(R.id.buttonYoutube)!!
        buttonDiscord = getView()?.findViewById(R.id.buttonDiscord)!!

        buttonWebpage.setOnClickListener({
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://robertsspaceindustries.com/orgs/LOKAKAKA")
                )
            )
        })

        buttonYoutube.setOnClickListener({
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://youtube.com/channel/UCgam5Cpkw_pr7bpASWPRrjg")
                )
            )
        })

        buttonDiscord.setOnClickListener({
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://discord.gg/N377XY")
                )
            )
        })

        welcomeIndicator.bringToFront()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        welcomeIndicator.visibility = View.GONE
    }

}