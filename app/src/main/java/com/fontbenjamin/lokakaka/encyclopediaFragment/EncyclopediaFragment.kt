package com.fontbenjamin.lokakaka.encyclopediaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.fontbenjamin.lokakaka.R
import com.fontbenjamin.lokakaka.encyclopediaFragment.cleaning.CleaningFragment
import com.fontbenjamin.lokakaka.encyclopediaFragment.datarunning.DatarunningFragment
import com.fontbenjamin.lokakaka.encyclopediaFragment.hacking.HackingFragment
import com.fontbenjamin.lokakaka.encyclopediaFragment.mercenary.MercenaryFragment
import com.fontbenjamin.lokakaka.encyclopediaFragment.piracy.PiracyFragment
import com.fontbenjamin.lokakaka.encyclopediaFragment.racing.RacingFragment
import com.fontbenjamin.lokakaka.encyclopediaFragment.smuggling.SmugglingFragment
import com.wang.avi.AVLoadingIndicatorView


class EncyclopediaFragment: Fragment() {

    private lateinit var smugglingButton: Button
    private lateinit var cleaningButton: Button
    private lateinit var hackingButton: Button
    private lateinit var mercenaryButton: Button
    private lateinit var datarunningButton: Button
    private lateinit var piracyButton: Button
    private lateinit var racingButton: Button

    lateinit var encyclopediaIndicator: AVLoadingIndicatorView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_encyclopedia, container, false)

    companion object {
        fun newInstance(): EncyclopediaFragment = EncyclopediaFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // we retrieve the views from the layout
        getViews()

        // we set the initial appearance of the views and buttons
        setViewInitialState()

        // we set the buttons action listeners
        setButtonsListeners()

        // we launch the buttonss animation
        animateButtons()
    }

    private fun getViews() {
        encyclopediaIndicator = getView()?.findViewById(R.id.indicatorEncyclopedia)!!
        smugglingButton = getView()?.findViewById(R.id.buttonSmuggling)!!
        cleaningButton = getView()?.findViewById(R.id.buttonCleaning)!!
        hackingButton = getView()?.findViewById(R.id.buttonHacking)!!
        mercenaryButton = getView()?.findViewById(R.id.buttonMercenary)!!
        datarunningButton = getView()?.findViewById(R.id.buttonDatarunning)!!
        piracyButton = getView()?.findViewById(R.id.buttonPiracy)!!
        racingButton = getView()?.findViewById(R.id.buttonRacing)!!
    }

    private fun setViewInitialState() {
        encyclopediaIndicator.bringToFront()
        smugglingButton.visibility = View.INVISIBLE
        (smugglingButton.parent as ConstraintLayout).visibility = View.INVISIBLE
        cleaningButton.visibility = View.INVISIBLE
        (cleaningButton.parent as ConstraintLayout).visibility = View.INVISIBLE
        hackingButton.visibility = View.INVISIBLE
        (hackingButton.parent as ConstraintLayout).visibility = View.INVISIBLE
        mercenaryButton.visibility = View.INVISIBLE
        (mercenaryButton.parent as ConstraintLayout).visibility = View.INVISIBLE
        datarunningButton.visibility = View.INVISIBLE
        (datarunningButton.parent as ConstraintLayout).visibility = View.INVISIBLE
        piracyButton.visibility = View.INVISIBLE
        (piracyButton.parent as ConstraintLayout).visibility = View.INVISIBLE
        racingButton.visibility = View.INVISIBLE
        (racingButton.parent as ConstraintLayout).visibility = View.INVISIBLE
    }

    private fun setButtonsListeners() {
        val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
        smugglingButton.setOnClickListener({
            var fragmentSmuggling: SmugglingFragment = SmugglingFragment()
            ft.replace(this.id, fragmentSmuggling, "SmugglingFragment")
            ft.commit()
        })
        cleaningButton.setOnClickListener({
            var fragmentCleaning: CleaningFragment = CleaningFragment()
            ft.replace(this.id, fragmentCleaning, "SmugglingFragment")
            ft.commit()
        })
        hackingButton.setOnClickListener({
            var fragmentHacking: HackingFragment = HackingFragment()
            ft.replace(this.id, fragmentHacking, "HackingFragment")
            ft.commit()
        })
        mercenaryButton.setOnClickListener({
            var fragmentMercenary: MercenaryFragment = MercenaryFragment()
            ft.replace(this.id, fragmentMercenary, "MercenaryFragment")
            ft.commit()
        })
        datarunningButton.setOnClickListener({
            var fragmentDatarunning: DatarunningFragment = DatarunningFragment()
            ft.replace(this.id, fragmentDatarunning, "DatarunningFragment")
            ft.commit()
        })
        piracyButton.setOnClickListener({
            var fragmentPiracy: PiracyFragment = PiracyFragment()
            ft.replace(this.id, fragmentPiracy, "PiracyFragment")
            ft.commit()
        })
        racingButton.setOnClickListener({
            var fragmentRacing: RacingFragment = RacingFragment()
            ft.replace(this.id, fragmentRacing, "RacingFragment")
            ft.commit()
        })
    }

    private fun animateButtons() {
        smugglingButton.getHandler().postDelayed(Runnable { smugglingButton.setVisibility(View.VISIBLE)
            (smugglingButton.parent as ConstraintLayout).visibility = View.VISIBLE },100)
        cleaningButton.getHandler().postDelayed(Runnable { cleaningButton.setVisibility(View.VISIBLE)
            (cleaningButton.parent as ConstraintLayout).visibility = View.VISIBLE},200)
        hackingButton.getHandler().postDelayed(Runnable { hackingButton.setVisibility(View.VISIBLE)
            (hackingButton.parent as ConstraintLayout).visibility = View.VISIBLE},300)
        mercenaryButton.getHandler().postDelayed(Runnable { mercenaryButton.setVisibility(View.VISIBLE)
            (mercenaryButton.parent as ConstraintLayout).visibility = View.VISIBLE},400)
        datarunningButton.getHandler().postDelayed(Runnable { datarunningButton.setVisibility(View.VISIBLE)
            (datarunningButton.parent as ConstraintLayout).visibility = View.VISIBLE},500)
        piracyButton.getHandler().postDelayed(Runnable { piracyButton.setVisibility(View.VISIBLE)
            (piracyButton.parent as ConstraintLayout).visibility = View.VISIBLE},600)
        racingButton.getHandler().postDelayed(Runnable { racingButton.setVisibility(View.VISIBLE)
            (racingButton.parent as ConstraintLayout).visibility = View.VISIBLE},700)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        encyclopediaIndicator.visibility = View.GONE
    }

}