package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.rkpandey.myapplication.R

class ManageSubscription(private val getContext : Context) : Fragment()
{
    lateinit var backIc : ImageView
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_manage_subscription , container , false)
        backIc = view.findViewById(R.id.backManage)
        backIc.setOnClickListener {
            val categoriesFragment = Categories(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter_right_to_left , R.anim.exit_right_to_left
                                      , R.anim.enter_left_to_right , R.anim.exit_left_to_right)
                ?.replace(R.id.splashierContainer,categoriesFragment )
                ?.disallowAddToBackStack()
                ?.commit()
        }
        return view
    }
}