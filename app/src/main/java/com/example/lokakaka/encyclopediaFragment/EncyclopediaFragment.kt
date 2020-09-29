package com.example.lokakaka.encyclopediaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lokakaka.R

class EncyclopediaFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_encyclopedia, container, false)

    companion object {
        fun newInstance(): EncyclopediaFragment = EncyclopediaFragment()
    }

}