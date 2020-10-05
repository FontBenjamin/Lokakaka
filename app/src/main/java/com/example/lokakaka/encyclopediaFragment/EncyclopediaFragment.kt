package com.example.lokakaka.encyclopediaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lokakaka.R


class EncyclopediaFragment: Fragment() {

    private lateinit var smugglingButton: Button
    private lateinit var cleaningButton: Button
    private lateinit var hackingButton: Button
    private lateinit var mercenaryButton: Button
    private lateinit var datarunningButton: Button
    private lateinit var piracyButton: Button
    private lateinit var racingButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_encyclopedia, container, false)

    companion object {
        fun newInstance(): EncyclopediaFragment = EncyclopediaFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        smugglingButton = getView()?.findViewById(R.id.buttonSmuggling)!!
        cleaningButton = getView()?.findViewById(R.id.buttonCleaning)!!
        hackingButton = getView()?.findViewById(R.id.buttonHacking)!!
        mercenaryButton = getView()?.findViewById(R.id.buttonMercenary)!!
        datarunningButton = getView()?.findViewById(R.id.buttonDatarunning)!!
        piracyButton = getView()?.findViewById(R.id.buttonPiracy)!!
        racingButton = getView()?.findViewById(R.id.buttonRacing)!!

        var buttonClickListener: View.OnClickListener = View.OnClickListener {


        }
        val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
        var fragment: CategoryFragment = CategoryFragment()






        smugglingButton.setOnClickListener({
            fragment.category = Categories.SMUGGLING
            ft.replace(this.id, fragment, "SmugglingFragment")
            ft.commit()
        })
        cleaningButton.setOnClickListener({
            fragment.category = Categories.CLEANING
            ft.replace(this.id, fragment, "CleaningFragment")
            ft.commit()
        })
        hackingButton.setOnClickListener({
            fragment.category = Categories.HACKING
            ft.replace(this.id, fragment, "HackingFragment")
            ft.commit()
        })
        mercenaryButton.setOnClickListener({
            fragment.category = Categories.MERCENARY
            ft.replace(this.id, fragment, "MercenaryFragment")
            ft.commit()
        })
        datarunningButton.setOnClickListener({
            fragment.category = Categories.DATARUNNING
            ft.replace(this.id, fragment, "DatarunningFragment")
            ft.commit()
        })
        piracyButton.setOnClickListener({
            fragment.category = Categories.PIRACY
            ft.replace(this.id, fragment, "PiracyFragment")
            ft.commit()
        })
        racingButton.setOnClickListener({
            fragment.category = Categories.RACING
            ft.replace(this.id, fragment, "RacingFragment")
            ft.commit()
        })
    }

}