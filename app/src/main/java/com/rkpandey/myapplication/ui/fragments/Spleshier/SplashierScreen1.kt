package com.rkpandey.myapplication.ui.fragments.Spleshier

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.rkpandey.myapplication.R
import pl.droidsonroids.gif.GifImageView
import kotlin.properties.Delegates

class SplashierScreen1(private val getContext : Context) : Fragment()
{
    private lateinit var handler : Handler
    private lateinit var eveGif : GifImageView
    private lateinit var eveTeams : ImageView
    private var designWight : Int = 375
    private var designHeight : Int = 812
    private var dpHeight by Delegates.notNull<Int>()
    private var dpWidth by Delegates.notNull<Int>()
    private var dpDesity by Delegates.notNull<Float>()
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splashier_screen1 , container , false)
        var displayMetrics = resources.displayMetrics
        eveGif = view.findViewById(R.id.gifEveGene)
        eveTeams = view.findViewById(R.id.iv_teams)
        dpHeight = displayMetrics.heightPixels
        dpWidth = displayMetrics.widthPixels
        dpDesity = displayMetrics.scaledDensity

        val eveGifParams : ViewGroup.LayoutParams = eveGif.layoutParams as ViewGroup.MarginLayoutParams
        eveGifParams.height = calcHight(247f)
        eveGifParams.width = calcWidth(291f)

        val eveTeamsParams : ViewGroup.LayoutParams = eveTeams.layoutParams as ViewGroup.MarginLayoutParams
        eveTeamsParams.height = calcHight(239f)
        eveTeamsParams.width = calcWidth(239f)


        handler = Handler()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
        {
            handler.postDelayed(
                Runnable {
                val splashierScreen2 = SplashierScreen2(getContext)
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.setCustomAnimations(R.anim.fade_in , R.anim.fade_out)
                        ?.replace(R.id.splashierContainer, splashierScreen2)
                        ?.disallowAddToBackStack()
                        ?.commit()
            },1400)
        }
        return view
    }
    private fun calcHight(value : Float) : Int{
        return ((dpHeight * (value / designHeight)).toInt())
    }
    private fun calcWidth(value : Float) : Int{
        return ((dpWidth * (value / designWight)).toInt())
    }
}