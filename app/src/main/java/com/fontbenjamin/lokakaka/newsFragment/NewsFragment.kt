package com.fontbenjamin.lokakaka.newsFragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.fontbenjamin.lokakaka.MainActivity
import com.fontbenjamin.lokakaka.R
import com.fontbenjamin.lokakaka.welcomeFragment.WelcomeFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.wang.avi.AVLoadingIndicatorView
import kotlinx.android.synthetic.main.new_cell.view.*

class NewsFragment: Fragment() {

    lateinit var newsLayout: LinearLayout

    lateinit var newsIndicator: AVLoadingIndicatorView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_news, container, false)

    companion object {
        fun newInstance(): NewsFragment = NewsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsLayout = getView()?.findViewById(R.id.newsLayout)!!
        newsIndicator = getView()?.findViewById(R.id.indicatorNews)!!
        newsIndicator.bringToFront()
        getNews()
    }

    private fun getNews() {
        val db = FirebaseFirestore.getInstance()
        var orderedResult: List<New> = ArrayList()
        db.collection("news")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // we get the data from Cloud Firestore
                        val new = document.toObject(New::class.java)
                        orderedResult += new
                    }
                    orderedResult.sortedByDescending { it.date }
                    for (new in orderedResult.reversed()) {
                        // we create the new cell to add to the ui
                        val view =
                            LayoutInflater.from(context)
                                .inflate(R.layout.new_cell, newsLayout, false)
                        view.titleTextView.text = new.title
                        view.contentTextView.text = new.content
                        newsLayout.addView(view)
                    }
                    newsIndicator.visibility = View.GONE
                } else {
                    // handle error
                    val popupView: View = LayoutInflater.from(context).inflate(R.layout.error_popup, null)
                    val width = ConstraintLayout.LayoutParams.MATCH_PARENT
                    val height = ConstraintLayout.LayoutParams.WRAP_CONTENT
                    val focusable = true // lets taps outside the popup also dismiss it
                    val popupWindow = PopupWindow(popupView, width, height, focusable)
                    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
                    popupView.setOnTouchListener { v, event ->
                        popupWindow.dismiss()
                        val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
                        ft.replace(this.id, WelcomeFragment(), "WelcomeFragment")
                        ft.commit()
                        (activity as MainActivity).bottomNavigation.setSelectedItemId(R.id.navigation_welcome)
                        true
                    }
                }
            }
    }

}