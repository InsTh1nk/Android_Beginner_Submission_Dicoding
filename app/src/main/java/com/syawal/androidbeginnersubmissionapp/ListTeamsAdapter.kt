package com.syawal.androidbeginnersubmissionapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListTeamsAdapter(private val listTeams: ArrayList<Teams>) : RecyclerView.Adapter<ListTeamsAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgTeam: ImageView = itemView.findViewById(R.id.img_team_photo)
        val tvTeamName: TextView = itemView.findViewById(R.id.tv_team_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listTeams.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo, desc) = listTeams[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgTeam)

        holder.tvTeamName.text = name
        holder.tvDesc.text = desc

        holder.itemView.setOnClickListener{
            val detailIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            detailIntent.putExtra("key_team", listTeams[holder.adapterPosition])
            holder.itemView.context.startActivity(detailIntent)
        }
    }
}