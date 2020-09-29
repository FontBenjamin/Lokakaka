package com.example.lokakaka

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.lokakaka.chatFragment.ChatFragment
import com.example.lokakaka.encyclopediaFragment.EncyclopediaFragment
import com.example.lokakaka.tradingFragment.TradingFragment
import com.example.lokakaka.welcomeFragment.WelcomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var toolbarTitle: TextView

    var titleTick: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = findViewById(R.id.titleTextView)
        bottomNavigation = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // we open the welcome fragment at the start of the app
        openFragment(WelcomeFragment.newInstance())

        // we change the design of the title bar
        animateActionBar()
    }

    fun applyFont(tv: TextView, context: Activity) {
        tv.typeface = Typeface.createFromAsset(context.assets, "fonts/customFont")
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