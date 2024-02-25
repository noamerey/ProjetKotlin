package com.example.projetnav.ui.series

import androidx.lifecycle.ViewModel
import com.example.projetnav.ui.series.episodes.Episode
import com.example.projetnav.ui.series.personnages.Personnage

class SerieViewModel : ViewModel() {
    var serie: Serie? = null
    var personnages: List<Personnage> = emptyList()
    var episodes: List<Episode> = emptyList()
}