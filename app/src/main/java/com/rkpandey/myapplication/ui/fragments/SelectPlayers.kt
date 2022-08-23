package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.card.MaterialCardView
import com.rkpandey.myapplication.R

class SelectPlayers(private var getContext : Context) : Fragment()
{
    lateinit var singlePlayer : MaterialCardView
    lateinit var backArrow : ImageView
    lateinit var continueArrow : ImageView
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_players , container , false)
        singlePlayer = view.findViewById(R.id.singlePlayer)
        backArrow = view.findViewById(R.id.backSelected)
        continueArrow = view.findViewById(R.id.iv_continue)
        singlePlayer.setOnClickListener {
            singlePlayer.strokeWidth = 1
            singlePlayer.strokeColor = resources.getColor(R.color.selected)
            singlePlayer.setOnClickListener {
                Toast.makeText(getContext , "Single Player is activated now", Toast.LENGTH_SHORT).show()
            }
        }
        backArrow.setOnClickListener {
            val gameTimer = GameTimer(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter_right_to_left , R.anim.exit_right_to_left
                                      , R.anim.enter_left_to_right , R.anim.exit_left_to_right)
                ?.replace(R.id.splashierContainer,gameTimer )
                ?.disallowAddToBackStack()
                ?.commit()
        }
        continueArrow.setOnClickListener {
            Toast.makeText(getContext , "Continue to Quiz Game is Activated now", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}