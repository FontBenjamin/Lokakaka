package com.example.lokakaka.encyclopediaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lokakaka.R

class CategoryFragment: Fragment() {

    private lateinit var backImageView: ImageView
    lateinit var category: Categories

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        when(category) {
            Categories.SMUGGLING -> return inflater.inflate(R.layout.fragment_smuggling, container, false)
            Categories.CLEANING -> return inflater.inflate(R.layout.fragment_smuggling, container, false)
            Categories.HACKING -> return inflater.inflate(R.layout.fragment_smuggling, container, false)
            Categories.MERCENARY -> return inflater.inflate(R.layout.fragment_smuggling, container, false)
            Categories.DATARUNNING -> return inflater.inflate(R.layout.fragment_smuggling, container, false)
            Categories.PIRACY -> return inflater.inflate(R.layout.fragment_smuggling, container, false)
            Categories.RACING -> return inflater.inflate(R.layout.fragment_smuggling, container, false)
        }
    }


    companion object {
        fun newInstance(): CategoryFragment = CategoryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backImageView = getView()?.findViewById(R.id.backImageView)!!
        backImageView.setOnClickListener( {
            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
            ft.replace(this.id, EncyclopediaFragment(), "EncyclopediaFragment")
            ft.commit()
        })
    }
}