package com.example.lokakaka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.lokakaka.chatFragment.ChatFragment
import com.example.lokakaka.encyclopediaFragment.EncyclopediaFragment
import com.example.lokakaka.tradingFragment.TradingFragment
import com.example.lokakaka.welcomeFragment.WelcomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar
    var titleTick: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // we open the welcome fragment at the start of the app
        openFragment(WelcomeFragment.newInstance())

        // we change the design of the title bar
        toolbar.title = getString(R.string.title)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_iconapp)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        animateActionBar()
    }

    private fun animateActionBar() {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {
                // do my thing
                if (titleTick) {
                    toolbar.title = getString(R.string.title)
                    titleTick = false
                } else {
                    toolbar.title = getString(R.string.title_full)
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