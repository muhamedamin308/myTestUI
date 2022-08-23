package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rkpandey.myapplication.R

class SplashierScreen2(private val getContext : Context) : Fragment()
{
    lateinit var handler : Handler
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splashier_screen2 , container , false)
        handler = Handler()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
        {
            handler.postDelayed(
                Runnable {
                    val subscription = subscriptionSkip(getContext)
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.setCustomAnimations(R.anim.enter_right_to_left , R.anim.exit_right_to_left
                                              , R.anim.enter_left_to_right , R.anim.exit_left_to_right)
                        ?.replace(R.id.splashierContainer,subscription )
                        ?.disallowAddToBackStack()
                        ?.commit()
                },2500)
        }
        return view
    }
}