package com.example.projetnav

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.databinding.ActivityMainBinding
import com.example.projetnav.ui.series.ListSeriesViewModel
import com.example.projetnav.ui.series.Serie
import com.example.projetnav.ui.series.SerieAdapter
import com.example.projetnav.ui.series.SerieViewModel
import com.example.projetnav.ui.series.episodes.Episode
import com.example.projetnav.ui.series.episodes.EpisodeAdapter
import com.example.projetnav.ui.series.personnages.Personnage
import com.example.projetnav.ui.series.personnages.PersonnageAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var listSeriesViewModel: ListSeriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_list_series)


        listSeriesViewModel = ViewModelProvider(this).get(ListSeriesViewModel::class.java)

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

        listSeriesViewModel.series = series

        val recycle_serie = findViewById<View>(R.id.recycler_series) as RecyclerView
        recycle_serie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle_serie.adapter = SerieAdapter(listSeriesViewModel.series)
    }
}

