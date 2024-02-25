package com.example.projetnav.ui.series

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R
import com.example.projetnav.ui.series.episodes.Episode
import com.example.projetnav.ui.series.episodes.EpisodeAdapter
import com.example.projetnav.ui.series.personnages.Personnage
import com.example.projetnav.ui.series.personnages.PersonnageAdapter

class SerieActivity : AppCompatActivity() {
    private lateinit var serieViewModel: SerieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_serie)

        serieViewModel = ViewModelProvider(this).get(SerieViewModel::class.java)

        val serie = Serie(
            title = "Titre de la série",
            imageResId = R.drawable.astronaut,
            studio = "Nom du studio",
            numberOfEpisodes = 10,
            year = 2022,
            story = "Histoire"
        )

        val personnages = listOf(
            Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
            Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
            Personnage("Personnage 3", "Rôle 3", R.drawable.astronaut),
        )

        val episodes = listOf(
            Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
            Episode("Épisode 2", "Description de l'épisode 2", 2, "10/01/2022"),
            Episode("Épisode 3", "Description de l'épisode 3", 3, "19/01/2022"),
        )

        serieViewModel.serie = serie
        serieViewModel.personnages = personnages
        serieViewModel.episodes = episodes

        findViewById<TextView>(R.id.titre_serie).text = serieViewModel.serie?.title
        findViewById<ImageView>(R.id.image_serie).setImageResource(serieViewModel.serie?.imageResId ?: 0)
        findViewById<TextView>(R.id.studio).text = serieViewModel.serie?.studio
        findViewById<TextView>(R.id.nb_episodes).text = serieViewModel.serie?.numberOfEpisodes.toString() + " épisodes"
        findViewById<TextView>(R.id.annee).text = serieViewModel.serie?.year.toString()
        findViewById<TextView>(R.id.text_histoire).text = serieViewModel.serie?.story

        val recycle_perso = findViewById<View>(R.id.recycler_personnages) as RecyclerView
        recycle_perso.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle_perso.adapter = PersonnageAdapter(serieViewModel.personnages)

        val recycle_episode = findViewById<View>(R.id.recycler_episodes) as RecyclerView
        recycle_episode.layoutManager = LinearLayoutManager(this)
        recycle_episode.adapter = EpisodeAdapter(serieViewModel.episodes)

        val buttonHistoire = findViewById<Button>(R.id.button_histoire)
        val buttonPersonnages = findViewById<Button>(R.id.button_personnages)
        val buttonEpisodes = findViewById<Button>(R.id.button_episodes)

        buttonHistoire.setOnClickListener {
            showHistoire()
        }

        buttonPersonnages.setOnClickListener {
            showPersonnages()
        }

        buttonEpisodes.setOnClickListener {
            showEpisodes()
        }
    }

    private fun showHistoire() {
        val textViewHistoire = findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = findViewById<RecyclerView>(R.id.recycler_episodes)

        textViewHistoire.visibility = View.VISIBLE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showPersonnages() {
        val textViewHistoire = findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = findViewById<RecyclerView>(R.id.recycler_episodes)

        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.VISIBLE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showEpisodes() {
        val textViewHistoire = findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = findViewById<RecyclerView>(R.id.recycler_episodes)

        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.VISIBLE
    }
}