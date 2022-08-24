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
class BuySubscription(private val getContext : Context) : Fragment()
{
    lateinit var cardSale1 : MaterialCardView
    lateinit var playNowSale1 : ImageView
    lateinit var cardSale2 : MaterialCardView
    lateinit var playNowSale2 : ImageView
    lateinit var backSubscription : ImageView
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_buy_subscription , container , false)
        cardSale1 = view.findViewById(R.id.cvbuy_sale1)
        playNowSale1 = view.findViewById(R.id.playNowbuy_sale1)
        cardSale2 = view.findViewById(R.id.cvbuy_sale2)
        playNowSale2 = view.findViewById(R.id.playNowbuy_sale2)
        backSubscription = view.findViewById(R.id.backBuySubscription)

        cardSale1.setOnClickListener {
            cardSale1.strokeWidth = 2
            cardSale1.strokeColor = resources.getColor(R.color.ground)
            playNowSale1.isClickable = true
            cardSale2.strokeColor = resources.getColor(R.color.white)
            playNowSale2.isClickable = false
            playNowSale1.setOnClickListener {
                Toast.makeText(getContext , "$ 2.99 In Process" , Toast.LENGTH_SHORT).show()
            }
        }
        cardSale2.setOnClickListener {
            cardSale2.strokeWidth = 2
            cardSale2.strokeColor = resources.getColor(R.color.ground)
            playNowSale2.isClickable = true
            cardSale1.strokeColor = resources.getColor(R.color.white)
            playNowSale1.isClickable = false
            playNowSale2.setOnClickListener {
                Toast.makeText(getContext , "$ 4.99 In Process" , Toast.LENGTH_SHORT).show()
            }
        }
        backSubscription.setOnClickListener {
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
}