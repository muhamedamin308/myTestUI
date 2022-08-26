package com.rkpandey.myapplication.ui.Model.Questions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.rkpandey.myapplication.R

class QuestionsAdapter(val click : OnClick) : RecyclerView.Adapter<QuestionsAdapter.CateViewHolder>()
{
    var choices : List<Answers> = listOf(
        Answers(Answer = "Amistad 1839 Revolt") ,
        Answers(Answer = "Amistaf Revolt 1859") ,
        Answers(Answer = "Amistad Revolt 1964") ,
        Answers(Answer = "Amistad Revolt 1869") ,
    )
    class CateViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var cardSelected : MaterialCardView = itemView.findViewById(R.id.cardQuestion)
        var cardAnswer : TextView = itemView.findViewById(R.id.answer)
    }

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : CateViewHolder
    {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent , false)
        return CateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder : CateViewHolder , position : Int)
    {
        val currentItem = choices[position]
        holder.cardAnswer.text = currentItem.Answer
        holder.cardSelected.setOnClickListener {
            click.onClickItem(position)
        }
    }

    override fun getItemCount() : Int
    {
        return choices.size
    }
    interface OnClick{
        fun onClickItem (position : Int)
    }
}