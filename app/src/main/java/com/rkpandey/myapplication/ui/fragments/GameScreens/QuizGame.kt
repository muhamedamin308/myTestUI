package com.rkpandey.myapplication.ui.fragments.GameScreens

import android.app.Dialog
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rkpandey.myapplication.R
import com.rkpandey.myapplication.ui.Model.Questions.QuestionsAdapter
import kotlinx.android.synthetic.main.custom_alert_dialog_game.*
import kotlin.properties.Delegates

class QuizGame (private val getContext : Context) : Fragment() , QuestionsAdapter.OnClick
{
    private lateinit var question : TextView
    private lateinit var recyclerView : RecyclerView
    private lateinit var exitGame : ImageView
    private lateinit var nextGame : ImageView
    lateinit var dialog : Dialog
    private lateinit var circleTime : ImageView
    private lateinit var linearRecycler : LinearLayout
    private lateinit var relativeLayout : RelativeLayout
    private lateinit var mediaPlayerCorrect : MediaPlayer
    private lateinit var mediaPlayerWrong : MediaPlayer
    var designWight : Int = 375
    var designHeight : Int = 812
    var dpHeight by Delegates.notNull<Int>()
    var dpWidth by Delegates.notNull<Int>()
    var dpDesity by Delegates.notNull<Float>()
    private lateinit var quizAlertDialog : ConstraintLayout
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz_game , container , false)
        val view2 = inflater.inflate(R.layout.custom_alert_dialog_game , container , false)
        var displayMetrics = resources.displayMetrics
        quizAlertDialog = view2.findViewById(R.id.gameAlertDialog)
            recyclerView = view.findViewById(R.id.recyclerQuestions)
            question = view.findViewById(R.id.questionText)
            exitGame = view.findViewById(R.id.exit)
            nextGame = view.findViewById(R.id.next)
//            toolbarQuiz = view.findViewById(R.id.toolbarQuizGame)
            circleTime = view.findViewById(R.id.questionTimer)
            linearRecycler = view.findViewById(R.id.linearRecyclerContainer)
            relativeLayout = view.findViewById(R.id.linearLayout2)
            mediaPlayerCorrect = MediaPlayer.create(getContext , R.raw.correct_anwser_sound)
            mediaPlayerWrong = MediaPlayer.create(getContext , R.raw.wrong_answer_sound)

        dpHeight = displayMetrics.heightPixels
        dpWidth = displayMetrics.widthPixels
        dpDesity = displayMetrics.scaledDensity

        recyclerView.layoutManager = LinearLayoutManager(getContext)
        recyclerView.adapter = QuestionsAdapter(this)
        recyclerView.setHasFixedSize(true)

       // question.text = "This was the first Black man to hold a high position in a Wall Street firm and was only one of four Black CEOs within Fortune 500 companies. His highest net worth was recorded in 2006 at \$48 million. He is also the first Black non-broker to take charge of Merrill Lynch in the company’s history"

//        val toolbarParams : ViewGroup.LayoutParams = toolbarQuiz.layoutParams as ViewGroup.MarginLayoutParams
//        toolbarParams.height = calcHight(40f)

        val circleTimeParams : ViewGroup.LayoutParams = circleTime.layoutParams as ViewGroup.MarginLayoutParams
        circleTimeParams.height = calcHight(55f)

        val linearRecyclerParams : ViewGroup.LayoutParams = linearRecycler.layoutParams as ViewGroup.MarginLayoutParams
        linearRecyclerParams.height = calcHight(500f)

        val relativeLayoutParams : ViewGroup.LayoutParams = relativeLayout.layoutParams as ViewGroup.MarginLayoutParams
        relativeLayoutParams.height = calcHight(60f)

        val questionParams : ViewGroup.LayoutParams = question.layoutParams as ViewGroup.MarginLayoutParams
        questionParams.height = calcHight(150f)
        questionParams.width = calcWidth(350f)

        val quizAlertDialogParams : ViewGroup.LayoutParams = quizAlertDialog.layoutParams as ViewGroup.MarginLayoutParams
        quizAlertDialogParams.width = calcWidth(277f)

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
            mediaPlayerCorrect.start()
        } else {
            Toast.makeText(getContext , "Wrong Answer try again" , Toast.LENGTH_SHORT).show()
            mediaPlayerWrong.start()
        }
    }
    private fun showAlert(title : String , body : String , positiveText : String , negativeText : String)
    {
        dialog = Dialog(getContext)
        dialog.setContentView(R.layout.custom_alert_dialog_game)
        dialog.show()
        dialog.window?.setBackgroundDrawable(getDrawable(getContext,R.drawable.alert_bglinear))
        dialog.setCancelable(false)
        dialog.window?.attributes?.windowAnimations = R.style.animations
        dialog.alertCustomTitleGame.text = title
        dialog.alertCustomBodyGame.text = body
        dialog.positiveIconGame.text = positiveText
        dialog.negativeButtonGame.text = negativeText
        dialog.positiveIconGame.setOnClickListener {
            dialog.dismiss()
        }
        dialog.negativeButtonGame.setOnClickListener {
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
    private fun calcHight(value : Float) : Int{
        return ((dpHeight * (value / designHeight)).toInt())
    }
    private fun calcWidth(value : Float) : Int{
        return ((dpWidth * (value / designWight)).toInt())
    }
}