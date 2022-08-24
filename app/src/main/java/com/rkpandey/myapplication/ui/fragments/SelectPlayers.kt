package com.rkpandey.myapplication.ui.fragments

import android.app.AlertDialog
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.card.MaterialCardView
import com.rkpandey.myapplication.R
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*
import kotlinx.android.synthetic.main.custom_alert_dialog_game.view.*

class SelectPlayers(private var getContext : Context) : Fragment()
{
    private lateinit var singlePlayer : MaterialCardView
    private lateinit var doublePlayer : MaterialCardView
    private lateinit var threePlayer : MaterialCardView
    private lateinit var fourPlayer : MaterialCardView
    private lateinit var backArrow : ImageView
    private lateinit var continueArrow : ImageView
    private var flag : Boolean = false
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_players , container , false)
        singlePlayer = view.findViewById(R.id.singlePlayer)
        doublePlayer = view.findViewById(R.id.twoPlayer)
        threePlayer = view.findViewById(R.id.threePlayer)
        fourPlayer = view.findViewById(R.id.fourPlayer)
        backArrow = view.findViewById(R.id.backSelected)
        continueArrow = view.findViewById(R.id.iv_continue)
        singlePlayer.setOnClickListener {
            singlePlayer.strokeWidth = 2
            singlePlayer.strokeColor = resources.getColor(R.color.selected)
            doublePlayer.strokeWidth = 0
            doublePlayer.strokeColor = resources.getColor(R.color.white)
            threePlayer.strokeWidth = 0
            threePlayer.strokeColor = resources.getColor(R.color.white)
            fourPlayer.strokeWidth = 0
            fourPlayer.strokeColor = resources.getColor(R.color.white)
            flag = true
        }
        doublePlayer.setOnClickListener {
            doublePlayer.strokeWidth = 2
            doublePlayer.strokeColor = resources.getColor(R.color.selected)
            singlePlayer.strokeWidth = 0
            singlePlayer.strokeColor = resources.getColor(R.color.white)
            threePlayer.strokeWidth = 0
            threePlayer.strokeColor = resources.getColor(R.color.white)
            fourPlayer.strokeWidth = 0
            fourPlayer.strokeColor = resources.getColor(R.color.white)
            flag = false
            showAlert(
                "Alert...!" ,
                "There are multiple players, the points will be added simultaneously",
                "Ok"
            )
        }
        threePlayer.setOnClickListener {
            threePlayer.strokeWidth = 2
            threePlayer.strokeColor = resources.getColor(R.color.selected)
            singlePlayer.strokeWidth = 0
            singlePlayer.strokeColor = resources.getColor(R.color.white)
            doublePlayer.strokeWidth = 0
            doublePlayer.strokeColor = resources.getColor(R.color.white)
            fourPlayer.strokeWidth = 0
            fourPlayer.strokeColor = resources.getColor(R.color.white)
            flag = false
            showAlert(
                "Alert...!" ,
                "There are multiple players, the points will be added simultaneously",
                "Ok"
            )
        }
        fourPlayer.setOnClickListener {
            fourPlayer.strokeWidth = 2
            fourPlayer.strokeColor = resources.getColor(R.color.selected)
            singlePlayer.strokeWidth = 0
            singlePlayer.strokeColor = resources.getColor(R.color.white)
            doublePlayer.strokeWidth = 0
            doublePlayer.strokeColor = resources.getColor(R.color.white)
            threePlayer.strokeWidth = 0
            threePlayer.strokeColor = resources.getColor(R.color.white)
            flag = false
            showAlert(
                "Alert...!" ,
                "There are multiple players, the points will be added simultaneously",
                "Ok"
            )
        }
        backArrow.setOnClickListener {
            val gameTimer = GameTimer(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(
                    R.anim.enter_right_to_left ,
                    R.anim.exit_right_to_left ,
                    R.anim.enter_left_to_right ,
                    R.anim.exit_left_to_right
                )
                ?.replace(R.id.splashierContainer , gameTimer)
                ?.disallowAddToBackStack()
                ?.commit()
        }
        continueArrow.setOnClickListener {
            if (flag)
            {
                val quizGame = QuizGame(getContext)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.setCustomAnimations(
                        R.anim.enter_right_to_left ,
                        R.anim.exit_right_to_left ,
                        R.anim.enter_left_to_right ,
                        R.anim.exit_left_to_right
                    )
                    ?.replace(R.id.splashierContainer , quizGame)
                    ?.disallowAddToBackStack()
                    ?.commit()
            }
        }
        return view
    }

    private fun showAlert(title : String , body : String , positiveText : String)
    {
        val alert = View.inflate(getContext , R.layout.custom_alert_dialog_game , null)
        val builder = AlertDialog.Builder(getContext)
        builder.setView(alert)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        alert.alertCustomTitleGame.text = title
        alert.alertCustomBodyGame.text = body
        alert.negativeButtonGame.visibility = View.GONE
        alert.positiveIconGame.text = positiveText
        alert.positiveIconGame.setOnClickListener {
            dialog.dismiss()
        }
    }
}