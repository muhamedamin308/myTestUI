package com.rkpandey.myapplication.ui.fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.rkpandey.myapplication.R
import com.rkpandey.myapplication.ui.Model.CategoriesAdapter
import com.rkpandey.myapplication.ui.Model.QuestionsAdapter
import kotlinx.android.synthetic.main.custom_alert_dialog_game.view.*
import kotlinx.android.synthetic.main.fragment_quiz_game.*

class QuizGame (private val getContext : Context) : Fragment() , QuestionsAdapter.OnClick
{
    lateinit var question : TextView
    lateinit var recyclerView : RecyclerView
    lateinit var exitGame : ImageView
    lateinit var nextGame : ImageView
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz_game , container , false)
        recyclerView = view.findViewById(R.id.recyclerQuestions)
        question = view.findViewById(R.id.questionText)
        exitGame = view.findViewById(R.id.exit)
        nextGame = view.findViewById(R.id.next)
        recyclerView.layoutManager = LinearLayoutManager(getContext)
        recyclerView.adapter = QuestionsAdapter(this)
        recyclerView.setHasFixedSize(true)
        question.text = "This revolt started when 53 Africans were kidnapped from eastern Africa and sold to the slave trade in Spain, boarding a slave ship going to Cuba. However, this was unsuccessful, and the slaves revolted and killed most onboard members."
        exitGame.setOnClickListener {
            showAlert("Are You Sure" , "Are you ready to stop play right now? " , "No" , "Yes")
        }
        nextGame.setOnClickListener {
            val playersScore = PlayersScore(getContext)
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(
                    R.anim.enter_right_to_left ,
                    R.anim.exit_right_to_left ,
                    R.anim.enter_left_to_right ,
                    R.anim.exit_left_to_right
                )
                ?.replace(R.id.splashierContainer , playersScore)
                ?.disallowAddToBackStack()
                ?.commit()
        }
        return view
    }

    override fun onClickItem(position : Int)
    {
        if (position == 0){
            Toast.makeText(getContext , "Correct Answer" , Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(getContext , "Wrong Answer try again" , Toast.LENGTH_SHORT).show()
        }
    }
    private fun showAlert(title : String , body : String , positiveText : String , negativeText : String)
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
        alert.positiveIconGame.text = positiveText
        alert.negativeButtonGame.text = negativeText
        alert.positiveIconGame.setOnClickListener {
            dialog.dismiss()
        }
        alert.negativeButtonGame.setOnClickListener {
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
            dialog.dismiss()
        }
    }
}