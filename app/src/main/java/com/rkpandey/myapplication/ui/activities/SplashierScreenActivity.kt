package com.rkpandey.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rkpandey.myapplication.R
import com.rkpandey.myapplication.ui.fragments.SplashierScreen1

class SplashierScreenActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashier_screen_activity)

        val splashierScreen1 = SplashierScreen1(this)
        supportFragmentManager.beginTransaction().replace(R.id.splashierContainer , splashierScreen1).commit()
    }
}