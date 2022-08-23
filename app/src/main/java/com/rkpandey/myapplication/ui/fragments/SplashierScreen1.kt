package com.rkpandey.myapplication.ui.fragments

import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.rkpandey.myapplication.R

class SplashierScreen1 : Fragment()
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
                val splashierScreen2 = SplashierScreen2()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.splashierContainer , splashierScreen2)?.commit()
            },1400)
        }
        return view
    }
}