package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.rkpandey.myapplication.R

class GameTimer(private val getContext : Context) : Fragment()
{
    private lateinit var backTimer : ImageView
    private lateinit var ll15mins : LinearLayout
    private lateinit var ll30mins : LinearLayout
    private lateinit var ll60mins : LinearLayout
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_timer , container , false)
        backTimer = view.findViewById(R.id.backTimer)
        ll15mins = view.findViewById(R.id.Container15mins)
        ll30mins = view.findViewById(R.id.Container30mins)
        ll60mins = view.findViewById(R.id.Container60mins)
        ll30mins.alpha = 0.5f
        ll60mins.alpha = 0.5f

        ll15mins.setOnClickListener {
            val selectPlayers = SelectPlayers(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter_right_to_left , R.anim.exit_right_to_left
                                      , R.anim.enter_left_to_right , R.anim.exit_left_to_right)
                ?.replace(R.id.splashierContainer,selectPlayers )
                ?.disallowAddToBackStack()
                ?.commit()
        }
        ll30mins.setOnClickListener {
            Toast.makeText(getContext , "30 mins is not allowed yet" , Toast.LENGTH_SHORT).show()
        }
        ll60mins.setOnClickListener {
            Toast.makeText(getContext , "60 mins is not allowed yet" , Toast.LENGTH_SHORT).show()
        }
        backTimer.setOnClickListener {
            val categories = Categories(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter_right_to_left , R.anim.exit_right_to_left
                                      , R.anim.enter_left_to_right , R.anim.exit_left_to_right)
                ?.replace(R.id.splashierContainer,categories )
                ?.disallowAddToBackStack()
                ?.commit()
        }
        return view
    }
}