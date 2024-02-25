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

/*class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}*/

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

        // Mise à jour du ViewModel avec les données
        listSeriesViewModel.series = series

        // Mise à jour de l'interface utilisateur

        // Mise à jour du recycler_series
        val recycle_serie = findViewById<View>(R.id.recycler_series) as RecyclerView
        recycle_serie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle_serie.adapter = SerieAdapter(listSeriesViewModel.series)
    }
}

/*class MainActivity : AppCompatActivity() {
    private lateinit var serieViewModel: SerieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_serie)

        // Initialisation du ViewModel
        serieViewModel = ViewModelProvider(this).get(SerieViewModel::class.java)

        // Exemple de données (à remplacer par vos données réelles)
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
            // ... Ajoutez d'autres personnages selon vos besoins
        )

        val episodes = listOf(
            Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
            Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
            // ... Ajoutez d'autres épisodes selon vos besoins
        )

        // Mise à jour du ViewModel avec les données
        serieViewModel.serie = serie
        serieViewModel.personnages = personnages
        serieViewModel.episodes = episodes

        // Mise à jour de l'interface utilisateur
        findViewById<TextView>(R.id.titre_serie).text = serieViewModel.serie?.title
        findViewById<ImageView>(R.id.image_serie).setImageResource(serieViewModel.serie?.imageResId ?: 0) // Assurez-vous que R.drawable.astronaut est correct
        findViewById<TextView>(R.id.studio).text = serieViewModel.serie?.studio
        findViewById<TextView>(R.id.nb_episodes).text = serieViewModel.serie?.numberOfEpisodes.toString() + " épisodes"
        findViewById<TextView>(R.id.annee).text = serieViewModel.serie?.year.toString()
        findViewById<TextView>(R.id.text_histoire).text = serieViewModel.serie?.story

        // Mise à jour du recycler_personnages
        val recycle_perso = findViewById<View>(R.id.recycler_personnages) as RecyclerView
        recycle_perso.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle_perso.adapter = PersonnageAdapter(serieViewModel.personnages)

        // Mise à jour du recycler_episodes
        val recycle_episode = findViewById<View>(R.id.recycler_episodes) as RecyclerView
        recycle_episode.layoutManager = LinearLayoutManager(this)
        recycle_episode.adapter = EpisodeAdapter(serieViewModel.episodes)


        val buttonHistoire = findViewById<Button>(R.id.button_histoire)
        val buttonPersonnages = findViewById<Button>(R.id.button_personnages)
        val buttonEpisodes = findViewById<Button>(R.id.button_episodes)

        // Ajout des écouteurs de clic aux boutons
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

        // Afficher la vue d'histoire et masquer les RecyclerViews
        textViewHistoire.visibility = View.VISIBLE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showPersonnages() {
        val textViewHistoire = findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = findViewById<RecyclerView>(R.id.recycler_episodes)

        // Afficher la RecyclerView des personnages et masquer les autres vues
        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.VISIBLE
        recyclerEpisodes.visibility = View.GONE
    }

    private fun showEpisodes() {
        val textViewHistoire = findViewById<TextView>(R.id.text_histoire)
        val recyclerPersonnages = findViewById<RecyclerView>(R.id.recycler_personnages)
        val recyclerEpisodes = findViewById<RecyclerView>(R.id.recycler_episodes)

        // Afficher la RecyclerView des épisodes et masquer les autres vues
        textViewHistoire.visibility = View.GONE
        recyclerPersonnages.visibility = View.GONE
        recyclerEpisodes.visibility = View.VISIBLE
    }
}*/