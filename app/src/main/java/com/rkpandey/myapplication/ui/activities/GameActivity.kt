package com.rkpandey.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rkpandey.myapplication.R
import com.rkpandey.myapplication.ui.fragments.Subscription.subscriptionSkip

class GameActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val subscription = subscriptionSkip(this)
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.gameContainer , subscription).commit()

    }
}