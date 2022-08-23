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
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
            transaction?.replace(R.id.splashierContainer, categories)
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        return view
    }
}