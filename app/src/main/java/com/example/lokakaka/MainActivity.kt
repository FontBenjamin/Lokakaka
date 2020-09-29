package com.example.lokakaka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.lokakaka.chatFragment.ChatFragment
import com.example.lokakaka.encyclopediaFragment.EncyclopediaFragment
import com.example.lokakaka.tradingFragment.TradingFragment
import com.example.lokakaka.welcomeFragment.WelcomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // we open the welcome fragment at the start of the app
        openFragment(WelcomeFragment.newInstance())
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_welcome -> {
                toolbar.title = "Welcome"
                val welcomeFragment = WelcomeFragment.newInstance()
                openFragment(welcomeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_encyclopedia -> {
                toolbar.title = "Encyclopedia"
                val encyclopediaFragment = EncyclopediaFragment.newInstance()
                openFragment(encyclopediaFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_trading -> {
                toolbar.title = "Trading"
                val tradingFragment = TradingFragment.newInstance()
                openFragment(tradingFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_chat -> {
                toolbar.title = "Chat"
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