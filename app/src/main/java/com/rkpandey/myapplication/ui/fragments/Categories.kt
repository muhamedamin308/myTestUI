package com.rkpandey.myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rkpandey.myapplication.R
import com.rkpandey.myapplication.ui.Model.CategoriesAdapter

class Categories (private val getContext : Context) : Fragment() , CategoriesAdapter.OnClick
{
    lateinit var recyclerView : RecyclerView
    lateinit var menu : ImageView
    override fun onCreateView(
            inflater : LayoutInflater , container : ViewGroup? ,
            savedInstanceState : Bundle?
    ) : View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_categories , container , false)
        recyclerView = view.findViewById(R.id.recyclerCategories)
        menu = view.findViewById(R.id.menuCategories)
        recyclerView.layoutManager = LinearLayoutManager(getContext)
        recyclerView.adapter = CategoriesAdapter(this)
        recyclerView.setHasFixedSize(true)
        menu.setOnClickListener {
            val manageSubscription = ManageSubscription(getContext)
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
            transaction?.replace(R.id.splashierContainer, manageSubscription)
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        return view
    }

    override fun onClickItem(position : Int)
    {
        val gameTimer = GameTimer(getContext)
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
        transaction?.replace(R.id.splashierContainer, gameTimer)
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
}