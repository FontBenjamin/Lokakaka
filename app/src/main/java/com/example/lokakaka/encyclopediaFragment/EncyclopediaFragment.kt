package com.example.lokakaka.encyclopediaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lokakaka.R
import com.example.lokakaka.encyclopediaFragment.smuggling.SmugglingFragment
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

        encyclopediaIndicator = getView()?.findViewById(R.id.indicatorEncyclopedia)!!
        encyclopediaIndicator.bringToFront()

        smugglingButton = getView()?.findViewById(R.id.buttonSmuggling)!!
        cleaningButton = getView()?.findViewById(R.id.buttonCleaning)!!
        hackingButton = getView()?.findViewById(R.id.buttonHacking)!!
        mercenaryButton = getView()?.findViewById(R.id.buttonMercenary)!!
        datarunningButton = getView()?.findViewById(R.id.buttonDatarunning)!!
        piracyButton = getView()?.findViewById(R.id.buttonPiracy)!!
        racingButton = getView()?.findViewById(R.id.buttonRacing)!!

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

        val ft: FragmentTransaction = fragmentManager!!.beginTransaction()

        smugglingButton.setOnClickListener({
            var fragmentSmuggling: SmugglingFragment = SmugglingFragment()
            ft.replace(this.id, fragmentSmuggling, "SmugglingFragment")
            ft.commit()
        })
        cleaningButton.setOnClickListener({

        })
        hackingButton.setOnClickListener({

        })
        mercenaryButton.setOnClickListener({

        })
        datarunningButton.setOnClickListener({

        })
        piracyButton.setOnClickListener({

        })
        racingButton.setOnClickListener({

        })

        // we launch the animation
        animateButtons()
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