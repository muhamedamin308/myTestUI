package com.rkpandey.myapplication.ui.Model.Categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.rkpandey.myapplication.R

class CategoriesAdapter(val click : OnClick) : RecyclerView.Adapter<CategoriesAdapter.CateViewHolder>()
{
    val categories : List<CategoriesData> = listOf(
        CategoriesData("Random" , R.drawable.ic_random) ,
        CategoriesData("Inventors & Pioneers" , R.drawable.ic_money) ,
        CategoriesData("Entertainers & Artists" , R.drawable.ic_music) ,
        CategoriesData("Executives & Officials" , R.drawable.ic_work) ,
        CategoriesData("Sports" , R.drawable.ic_sport) ,
        CategoriesData("Civil Rights" , R.drawable.ic_hand) ,
        CategoriesData("Simply Amazing" , R.drawable.ic_magic)
        )

    class CateViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var cardSelected : ConstraintLayout = itemView.findViewById(R.id.cl_category)
        var cardIcon : ImageView = itemView.findViewById(R.id.icon_card)
        var cardText : TextView = itemView.findViewById(R.id.text_card)
    }

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : CateViewHolder
    {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent , false)
        return CateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder : CateViewHolder , position : Int)
    {
        val currentItem = categories[position]
        holder.cardIcon.setImageResource(currentItem.cardIcon)
        holder.cardText.text = currentItem.cardText
        holder.cardSelected.setOnClickListener {
            click.onClickItem(position)
        }
    }

    override fun getItemCount() : Int
    {
        return categories.size
    }
    interface OnClick{
        fun onClickItem (position : Int)
    }
}