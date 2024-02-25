package com.example.projetnav.ui.series.personnages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R

class PersonnageAdapter(private val personnages: List<Personnage>) :
    RecyclerView.Adapter<PersonnageAdapter.PersonnageViewHolder>() {

    class PersonnageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.personnage_name)
        val surname: TextView = itemView.findViewById(R.id.personnage_surname)
        val image: ImageView = itemView.findViewById(R.id.personnage_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonnageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_personnage, parent, false)
        return PersonnageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonnageViewHolder, position: Int) {
        val personnage = personnages[position]
        holder.name.text = personnage.name
        holder.surname.text = personnage.surname
        holder.image.setImageResource(personnage.imageResId)
    }

    override fun getItemCount(): Int {
        return personnages.size
    }
}