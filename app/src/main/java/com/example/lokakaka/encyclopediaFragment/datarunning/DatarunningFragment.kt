package com.example.lokakaka.encyclopediaFragment.datarunning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lokakaka.R
import com.example.lokakaka.encyclopediaFragment.EncyclopediaFragment

class DatarunningFragment: Fragment() {

    lateinit var backImageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_datarunning, container, false)

    companion object {
        fun newInstance(): DatarunningFragment = DatarunningFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backImageView = getView()?.findViewById(R.id.imageViewBackDatarunning)!!

        backImageView.bringToFront()

        backImageView.setOnClickListener({
            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
            ft.replace(this.id, EncyclopediaFragment(), "EncyclopediaFragment")
            ft.commit()
        })
    }

}