package com.fontbenjamin.lokakaka.encyclopediaFragment.smuggling

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
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
import com.fontbenjamin.lokakaka.R
import com.fontbenjamin.lokakaka.encyclopediaFragment.EncyclopediaFragment


class SmugglingFragment: Fragment() {

    lateinit var backImageView: ImageView

    lateinit var labsButton: Button
    lateinit var terminalButton: Button
    lateinit var drugsButton: Button

    lateinit var orphanageButton: Button
    lateinit var paradiseButton: Button
    lateinit var jumptownButton: Button
    lateinit var nt999xxButton: Button
    lateinit var stashButton: Button
    lateinit var nuenButton: Button

    lateinit var contentTextView: TextView

    lateinit var constraintLayoutYoutube: ConstraintLayout
    lateinit var constraintLayoutDrugs: ConstraintLayout
    lateinit var constraintLayoutTerminal: ConstraintLayout
    lateinit var constraintLayoutLabs: ConstraintLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_smuggling, container, false)


    companion object {
        fun newInstance(): SmugglingFragment = SmugglingFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // we retrieve the views from the layout
        getViews()

        // we set the initial appearance of the views and buttons
        setViewInitialState()

        // we set the buttons action listeners
        setButtonsListeners()
    }

    private fun setButtonsListeners() {
        drugsButton.setOnClickListener({
            contentTextView.setText(getString(R.string.smuggling_content_marchandises))
            constraintLayoutYoutube.visibility = View.GONE
            constraintLayoutDrugs.setBackgroundResource(R.color.colorAccent)
            constraintLayoutTerminal.setBackgroundResource(R.color.colorBackground)
            constraintLayoutLabs.setBackgroundResource(R.color.colorBackground)
        })
        terminalButton.setOnClickListener({
            contentTextView.setText(getString(R.string.smuggling_content_terminal))
            constraintLayoutYoutube.visibility = View.GONE
            constraintLayoutDrugs.setBackgroundResource(R.color.colorBackground)
            constraintLayoutTerminal.setBackgroundResource(R.color.colorAccent)
            constraintLayoutLabs.setBackgroundResource(R.color.colorBackground)
        })
        labsButton.setOnClickListener({
            contentTextView.setText(getString(R.string.smuggling_content_labos))
            constraintLayoutYoutube.visibility = View.VISIBLE
            constraintLayoutDrugs.setBackgroundResource(R.color.colorBackground)
            constraintLayoutTerminal.setBackgroundResource(R.color.colorBackground)
            constraintLayoutLabs.setBackgroundResource(R.color.colorAccent)
        })

        backImageView.setOnClickListener({
            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
            ft.replace(this.id, EncyclopediaFragment(), "EncyclopediaFragment")
            ft.commit()
        })

        orphanageButton.setOnClickListener({ watchYoutubeVideo("IqBKatHvR9A") })
        paradiseButton.setOnClickListener({ watchYoutubeVideo("CLtafTBm2kU") })
        jumptownButton.setOnClickListener({ watchYoutubeVideo("ouxB2toqah8") })
        nt999xxButton.setOnClickListener({ watchYoutubeVideo("Jd6I5748cAk") })
        stashButton.setOnClickListener({ watchYoutubeVideo("ttgXST0OuuE") })
        nuenButton.setOnClickListener({ watchYoutubeVideo("G6noFJvF45c") })
    }

    private fun setViewInitialState() {
        constraintLayoutYoutube.visibility = View.GONE
        backImageView.bringToFront()
    }

    private fun getViews() {
        backImageView = getView()?.findViewById(R.id.imageViewBackSmuggling)!!
        drugsButton = getView()?.findViewById(R.id.buttonDrugs)!!
        terminalButton = getView()?.findViewById(R.id.buttonTerminal)!!
        labsButton = getView()?.findViewById(R.id.buttonLabs)!!
        orphanageButton = getView()?.findViewById(R.id.buttonOrphanage)!!
        paradiseButton = getView()?.findViewById(R.id.buttonParadise)!!
        jumptownButton = getView()?.findViewById(R.id.buttonJumptown)!!
        nt999xxButton = getView()?.findViewById(R.id.buttonNT999XX)!!
        stashButton = getView()?.findViewById(R.id.buttonStashHouse)!!
        nuenButton = getView()?.findViewById(R.id.buttonNuen)!!
        contentTextView = getView()?.findViewById(R.id.textViewContentSmuggling)!!
        constraintLayoutYoutube = getView()?.findViewById(R.id.constraintLayoutYoutube)!!
        constraintLayoutDrugs = getView()?.findViewById(R.id.constraintLayoutDrugsButton)!!
        constraintLayoutTerminal = getView()?.findViewById(R.id.constraintLayoutTerminalButton)!!
        constraintLayoutLabs = getView()?.findViewById(R.id.constraintLayoutLabsButton)!!
    }

    private fun watchYoutubeVideo(id: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$id")
        )
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }

}