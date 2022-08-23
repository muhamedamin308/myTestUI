package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.card.MaterialCardView
import com.rkpandey.myapplication.R
import kotlin.math.sin

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
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
            transaction?.replace(R.id.splashierContainer, gameTimer)
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        continueArrow.setOnClickListener {
            Toast.makeText(getContext , "Continue to Quiz Game is Activated now", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}