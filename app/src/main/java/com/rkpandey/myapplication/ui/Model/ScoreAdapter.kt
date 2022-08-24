package com.rkpandey.myapplication.ui.Model

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.rkpandey.myapplication.R

class ScoreAdapter : RecyclerView.Adapter<ScoreAdapter.CateViewHolder>()
{
    var players : List<PlayersScore> = listOf(
        PlayersScore(10 , 1),
        PlayersScore(12 , 2),
        PlayersScore(42 , 3),
        PlayersScore(18 , 4),
    )
    class CateViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var cardScore : TextView = itemView.findViewById(R.id.playerScore)
        var cardPlayer : TextView = itemView.findViewById(R.id.playerNumber)
    }

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : CateViewHolder
    {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.item_players_score, parent , false)
        return CateViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder : CateViewHolder , position : Int)
    {
        val currentItem = players[position]
        holder.cardScore.text = "Score ${currentItem.score}"
        holder.cardPlayer.text = "Player ${currentItem.playerNumber}"
    }

    override fun getItemCount() : Int
    {
        return players.size
    }
}