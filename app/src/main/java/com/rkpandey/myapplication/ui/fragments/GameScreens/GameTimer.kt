package com.rkpandey.myapplication.ui.fragments.GameScreens

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.constraintlayout.widget.ConstraintLayout
import com.rkpandey.myapplication.R
import kotlinx.android.synthetic.main.custom_alert_dialog.*
import kotlin.properties.Delegates

class GameTimer(private val getContext : Context) : Fragment()
{
    private lateinit var backTimer : ImageView
    private lateinit var ll15mins : LinearLayout
    private lateinit var ll30mins : LinearLayout
    private lateinit var ll60mins : LinearLayout
    lateinit var dialog : Dialog

    private lateinit var timeAlertDialog : ConstraintLayout
    private var designWight : Int = 375
    private var designHeight : Int = 812
    private var dpHeight by Delegates.notNull<Int>()
    private var dpWidth by Delegates.notNull<Int>()
    private var dpDesity by Delegates.notNull<Float>()
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_timer , container , false)
        val view2 = inflater.inflate(R.layout.custom_alert_dialog , container , false)
        val displayMetrics = resources.displayMetrics
        timeAlertDialog = view2.findViewById(R.id.timerAlertDialog)
        backTimer = view.findViewById(R.id.backTimer)
        ll15mins = view.findViewById(R.id.Container15mins)
        ll30mins = view.findViewById(R.id.Container30mins)
        ll60mins = view.findViewById(R.id.Container60mins)
        ll30mins.alpha = 0.5f
        ll60mins.alpha = 0.5f

        dpHeight = displayMetrics.heightPixels
        dpWidth = displayMetrics.widthPixels
        dpDesity = displayMetrics.scaledDensity

        val alertParams : ViewGroup.LayoutParams = timeAlertDialog.layoutParams as ViewGroup.MarginLayoutParams
        alertParams.width = calcWidth(290f)

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
        dialog = Dialog(getContext)
        dialog.setContentView(R.layout.custom_alert_dialog)
        dialog.show()
        dialog.window?.setBackgroundDrawable(getDrawable(getContext,R.drawable.alert_bglinear))
        dialog.setCancelable(false)
        dialog.window?.attributes?.windowAnimations = R.style.animations
        dialog.alertCustomTitle.text = title
        dialog.alertCustomBody.text = body
        dialog.negativeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.positiveIcon.setOnClickListener {
            Toast.makeText(
                getContext ,
                "Please buy new subscription for $time mins quiz game mode" ,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun calcWidth(value : Float) : Int{
        return ((dpWidth * (value / designWight)).toInt())
    }
}