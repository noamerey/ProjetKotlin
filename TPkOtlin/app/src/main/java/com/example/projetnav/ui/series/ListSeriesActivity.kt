package com.example.projetnav.ui.series

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R


class ListSeriesActivity : AppCompatActivity() {
    private lateinit var listSeriesViewModel: ListSeriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_list_series)

        // Initialisation du ViewModel
        listSeriesViewModel = ViewModelProvider(this).get(ListSeriesViewModel::class.java)

        // Exemple de données (à remplacer par vos données réelles)
        val series = listOf(
            Serie(
                title = "Titre de la série",
                imageResId = R.drawable.astronaut,
                studio = "Nom du studio",
                numberOfEpisodes = 10,
                year = 2022,
                story = "Histoire"
            ),
            Serie(
                title = "Titre de la série 2",
                imageResId = R.drawable.astronaut,
                studio = "Nom du studio",
                numberOfEpisodes = 10,
                year = 2022,
                story = "Histoire"
            ),
            Serie(
                title = "Titre de la série 3",
                imageResId = R.drawable.astronaut,
                studio = "Nom du studio",
                numberOfEpisodes = 10,
                year = 2022,
                story = "Histoire"
            )
        )

        // Mise à jour du ViewModel avec les données
        listSeriesViewModel.series = series

        // Mise à jour de l'interface utilisateur

        // Mise à jour du recycler_series
        val recycle_serie = findViewById<View>(R.id.recycler_series) as RecyclerView
        recycle_serie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle_serie.adapter = SerieAdapter(listSeriesViewModel.series)
    }
}