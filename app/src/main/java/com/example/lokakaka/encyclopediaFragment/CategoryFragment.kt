package com.example.lokakaka.encyclopediaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lokakaka.R

class CategoryFragment: Fragment() {

    private lateinit var backImageView: ImageView
    private lateinit var contentImageView: ImageView
    private lateinit var contentTextView: TextView

    lateinit var category: Categories

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_category, container, false)




    companion object {
        fun newInstance(): CategoryFragment = CategoryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backImageView = getView()?.findViewById(R.id.backImageView)!!
        contentImageView = getView()?.findViewById(R.id.imageViewContent)!!
        contentTextView = getView()?.findViewById(R.id.textViewContent)!!

        backImageView.setOnClickListener( {
            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
            ft.replace(this.id, EncyclopediaFragment(), "EncyclopediaFragment")
            ft.commit()
        })

        when(category) {
            Categories.SMUGGLING -> {
                contentImageView.setImageResource(R.mipmap.smuggling_screenshot_foreground)
                contentTextView.setText(R.string.smuggling_content)
            }
            Categories.CLEANING -> {
                contentImageView.setImageResource(R.mipmap.cleaning_screenshot_foreground)
                contentTextView.setText(R.string.cleaning_content)
            }
            Categories.HACKING -> {
                contentImageView.setImageResource(R.mipmap.hacking_screenshot_foreground)
                contentTextView.setText(R.string.hacking_content)
            }
            Categories.MERCENARY -> {
                contentImageView.setImageResource(R.mipmap.mercenary_screenshot_foreground)
                contentTextView.setText(R.string.mercenary_content)
            }
            Categories.DATARUNNING -> {
                contentImageView.setImageResource(R.mipmap.datarunning_screenshot_foreground)
                contentTextView.setText(R.string.datarunning_content)
            }
            Categories.PIRACY -> {
                contentImageView.setImageResource(R.mipmap.piracy_screenshot_foreground)
                contentTextView.setText(R.string.piracy_content)
            }
            Categories.RACING -> {
                contentImageView.setImageResource(R.mipmap.racing_screenshot_foreground)
                contentTextView.setText(R.string.racing_content)
            }
        }
    }
}