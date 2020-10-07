package com.example.lokakaka.encyclopediaFragment.cleaning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lokakaka.R
import com.example.lokakaka.encyclopediaFragment.EncyclopediaFragment
import com.wang.avi.AVLoadingIndicatorView

class CleaningFragment: Fragment() {

    lateinit var backImageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_cleaning, container, false)

    companion object {
        fun newInstance(): CleaningFragment = CleaningFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backImageView = getView()?.findViewById(R.id.imageViewBackCleaning)!!

        backImageView.bringToFront()
        backImageView.setOnClickListener({
            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
            ft.replace(this.id, EncyclopediaFragment(), "EncyclopediaFragment")
            ft.commit()
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}