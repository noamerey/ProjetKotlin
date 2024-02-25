package com.example.projetnav.ui.series

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R

class SerieAdapter(private val serie: List<Serie>) :
    RecyclerView.Adapter<SerieAdapter.SerieViewHolder>() {

    class SerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titre_serie)
        val imageResId: ImageView = itemView.findViewById(R.id.image_serie)
        val studio: TextView = itemView.findViewById(R.id.studio)
        val numberOfEpisodes: TextView = itemView.findViewById(R.id.nb_episodes)
        val year: TextView = itemView.findViewById(R.id.annee)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_serie, parent, false)
        return SerieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        val currentSerie = serie[position]

        holder.title.text = currentSerie.title
        holder.imageResId.setImageResource(currentSerie.imageResId)
        holder.studio.text = currentSerie.studio
        holder.numberOfEpisodes.text = currentSerie.numberOfEpisodes.toString()
        holder.year.text = currentSerie.year.toString()
    }

    override fun getItemCount(): Int {
        return serie.size
    }
}
