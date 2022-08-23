package com.rkpandey.myapplication.ui.fragments

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

class SplashierScreen1(private val getContext : Context) : Fragment()
{
     lateinit var handler : Handler
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splashier_screen1 , container , false)
        handler = Handler()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
        {
            handler.postDelayed(
                Runnable {
                val splashierScreen2 = SplashierScreen2(getContext)
                    val transaction = activity?.supportFragmentManager?.beginTransaction()
                    transaction?.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
                    transaction?.replace(R.id.splashierContainer, splashierScreen2)
                    transaction?.disallowAddToBackStack()
                    transaction?.commit()
            },1400)
        }
        return view
    }
}