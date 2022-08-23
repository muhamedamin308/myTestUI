package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rkpandey.myapplication.R

class subscriptionSkip(private val getContext : Context) : Fragment()
{
    private lateinit var skipnow : TextView
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_subscription_skip , container , false)
        skipnow = view.findViewById(R.id.skipNow)
        skipnow.setOnClickListener {
            val categories = Categories(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter_right_to_left , R.anim.exit_right_to_left
                , R.anim.enter_left_to_right , R.anim.exit_left_to_right)
                ?.replace(R.id.splashierContainer, categories)
                ?.disallowAddToBackStack()
                ?.commit()
        }
        return view
    }
}