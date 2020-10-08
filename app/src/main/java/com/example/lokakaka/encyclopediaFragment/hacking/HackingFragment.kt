package com.example.lokakaka.encyclopediaFragment.hacking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lokakaka.R
import com.example.lokakaka.encyclopediaFragment.EncyclopediaFragment
import kotlinx.android.synthetic.main.fragment_hacking.*

class HackingFragment: Fragment() {

    lateinit var backImageView: ImageView

    lateinit var missionButton: Button
    lateinit var microshipsButton: Button
    lateinit var crimestatButton: Button

    lateinit var missionConstraintLayout : ConstraintLayout
    lateinit var microshipConstraintLayout : ConstraintLayout
    lateinit var crimestatConstraintLayout : ConstraintLayout
    lateinit var microshipContentConstraintLayout : ConstraintLayout

    lateinit var contentTextView: TextView



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_hacking, container, false)

    companion object {
        fun newInstance(): HackingFragment = HackingFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backImageView = getView()?.findViewById(R.id.imageViewBackHacking)!!
        missionButton = getView()?.findViewById(R.id.buttonMission)!!
        microshipsButton = getView()?.findViewById(R.id.buttonMicroships)!!
        crimestatButton = getView()?.findViewById(R.id.buttonCrimestat)!!
        missionConstraintLayout = getView()?.findViewById(R.id.constraintLayoutMissionsButton)!!
        microshipConstraintLayout = getView()?.findViewById(R.id.constraintLayoutMicroshipsButton)!!
        crimestatConstraintLayout = getView()?.findViewById(R.id.constraintLayoutCrimeStatButton)!!
        microshipContentConstraintLayout = getView()?.findViewById(R.id.constraintLayoutMicroships)!!
        contentTextView = getView()?.findViewById(R.id.textViewContentHacking)!!

        microshipContentConstraintLayout.visibility = View.GONE

        missionButton.setOnClickListener({
            contentTextView.setText(getString(R.string.hacking_content_missions))
            constraintLayoutMicroships.visibility = View.GONE
            constraintLayoutMissionsButton.setBackgroundResource(R.color.colorAccent)
            constraintLayoutMicroshipsButton.setBackgroundResource(R.color.colorBackground)
            constraintLayoutCrimeStatButton.setBackgroundResource(R.color.colorBackground)
        })

        microshipsButton.setOnClickListener({
            contentTextView.setText(getString(R.string.hacking_content_microhips))
            constraintLayoutMicroships.visibility = View.VISIBLE
            constraintLayoutMissionsButton.setBackgroundResource(R.color.colorBackground)
            constraintLayoutMicroshipsButton.setBackgroundResource(R.color.colorAccent)
            constraintLayoutCrimeStatButton.setBackgroundResource(R.color.colorBackground)
        })

        crimestatButton.setOnClickListener({
            contentTextView.setText(getString(R.string.hacking_content_crimestat))
            constraintLayoutMicroships.visibility = View.GONE
            constraintLayoutMissionsButton.setBackgroundResource(R.color.colorBackground)
            constraintLayoutMicroshipsButton.setBackgroundResource(R.color.colorBackground)
            constraintLayoutCrimeStatButton.setBackgroundResource(R.color.colorAccent)
        })

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