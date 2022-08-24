package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.rkpandey.myapplication.R
import com.rkpandey.myapplication.ui.Model.QuestionsAdapter
import com.rkpandey.myapplication.ui.Model.ScoreAdapter
import org.w3c.dom.Text
import kotlin.system.exitProcess

class PlayersScore(private val getContext : Context) : Fragment()
{
    private lateinit var recyclerView : RecyclerView
    private lateinit var playAgain : MaterialCardView
    private lateinit var Exit : TextView
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_players_score , container , false)
        recyclerView = view.findViewById(R.id.recyclerScore)
        playAgain = view.findViewById(R.id.cardPlayAgain)
        Exit = view.findViewById(R.id.ExitScore)
        recyclerView.layoutManager = LinearLayoutManager(getContext)
        recyclerView.adapter = ScoreAdapter()
        recyclerView.setHasFixedSize(true)

        playAgain.setOnClickListener {
            val buySubscription = BuySubscription(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter_right_to_left , R.anim.exit_right_to_left
                                      , R.anim.enter_left_to_right , R.anim.exit_left_to_right)
                ?.replace(R.id.splashierContainer,buySubscription )
                ?.disallowAddToBackStack()
                ?.commit()
        }
        Exit.setOnClickListener {
            activity?.moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }
        return view
    }
}