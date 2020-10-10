package com.example.lokakaka

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.lokakaka.chatFragment.ChatFragment
import com.example.lokakaka.encyclopediaFragment.EncyclopediaFragment
import com.example.lokakaka.tradingFragment.TradingFragment
import com.example.lokakaka.welcomeFragment.WelcomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var toolbarTitle: TextView

    lateinit var menuConstraintLayout: ConstraintLayout

    lateinit var creditConstraintLayout: ConstraintLayout



    var titleTick: Boolean = false

    var menuClick: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // we retrieve the views from the layout
        getViews()
        creditConstraintLayout.bringToFront()
        creditConstraintLayout.visibility = View.GONE

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        menuConstraintLayout.setOnClickListener({
            if (menuClick) {
                creditConstraintLayout.visibility = View.GONE
                menuClick = false
            } else {
                creditConstraintLayout.visibility = View.VISIBLE
                menuClick = true
            }
        })

            buttonCredits.setOnClickListener({
                val inflater =
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val popupView: View = inflater.inflate(R.layout.credits_popup, null)
                val width = ConstraintLayout.LayoutParams.MATCH_PARENT
                val height = ConstraintLayout.LayoutParams.WRAP_CONTENT
                val focusable = true // lets taps outside the popup also dismiss it
                val popupWindow = PopupWindow(popupView, width, height, focusable)
                popupWindow.showAtLocation(creditConstraintLayout, Gravity.CENTER, 0, 0)
                popupView.setOnTouchListener { v, event ->
                    popupWindow.dismiss()
                    true
                }
            })


        // we open the welcome fragment at the start of the app
        openFragment(WelcomeFragment.newInstance())

        // we change the design of the title bar
        animateActionBar()

    }

    private fun getViews() {
        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = findViewById(R.id.titleTextView)
        bottomNavigation = findViewById(R.id.bottomNavigationView)
        menuConstraintLayout = findViewById(R.id.constraintLayoutMenu)
        creditConstraintLayout = findViewById(R.id.constraintLayoutCreditsButton)
    }

    private fun animateActionBar() {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {
                // do my thing
                if (titleTick) {
                    toolbarTitle.text = getString(R.string.title)
                    titleTick = false
                } else {
                    toolbarTitle.text  = getString(R.string.title_full)
                    titleTick = true
                }
                mainHandler.postDelayed(this, 750)
            }
        })
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_welcome -> {
                val welcomeFragment = WelcomeFragment.newInstance()
                openFragment(welcomeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_encyclopedia -> {
                val encyclopediaFragment = EncyclopediaFragment.newInstance()
                openFragment(encyclopediaFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_trading -> {
                val tradingFragment = TradingFragment.newInstance()
                openFragment(tradingFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_chat -> {
                val chatFragment = ChatFragment.newInstance()
                openFragment(chatFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}