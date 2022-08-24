package com.rkpandey.myapplication.ui.fragments

import android.app.AlertDialog
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
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*

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
                ?.setCustomAnimations(
                    R.anim.enter_right_to_left ,
                    R.anim.exit_right_to_left ,
                    R.anim.enter_left_to_right ,
                    R.anim.exit_left_to_right
                )
                ?.replace(R.id.splashierContainer , selectPlayers)
                ?.disallowAddToBackStack()
                ?.commit()
        }
        ll30mins.setOnClickListener {
            showAlert("Alert...!" , "Subscribe for 30 minutes timer…thanks!" , 30)
        }
        ll60mins.setOnClickListener {
            showAlert("Alert...!" , "Subscribe for 60 minutes timer…thanks!" , 60)
        }
        backTimer.setOnClickListener {
            val categories = Categories(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(
                    R.anim.enter_right_to_left ,
                    R.anim.exit_right_to_left ,
                    R.anim.enter_left_to_right ,
                    R.anim.exit_left_to_right
                )
                ?.replace(R.id.splashierContainer , categories)
                ?.disallowAddToBackStack()
                ?.commit()
        }
        return view
    }

    private fun showAlert(title : String , body : String , time : Int)
    {
        val alert = View.inflate(getContext , R.layout.custom_alert_dialog , null)
        val builder = AlertDialog.Builder(getContext)
        builder.setView(alert)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        alert.alertCustomTitle.text = title
        alert.alertCustomBody.text = body
        alert.negativeButton.setOnClickListener {
            dialog.dismiss()
        }
        alert.positiveIcon.setOnClickListener {
            Toast.makeText(
                getContext ,
                "Please buy new subscription for $time mins quiz game mode" ,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}