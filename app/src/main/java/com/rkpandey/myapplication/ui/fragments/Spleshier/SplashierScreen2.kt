package com.rkpandey.myapplication.ui.fragments.Spleshier

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rkpandey.myapplication.R
import com.rkpandey.myapplication.ui.fragments.Subscription.subscriptionSkip

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
                        ?.setCustomAnimations(R.anim.fade_in , R.anim.fade_out)
                        ?.replace(R.id.splashierContainer,subscription )
                        ?.disallowAddToBackStack()
                        ?.commit()
                },2500)
        }
        return view
    }
}