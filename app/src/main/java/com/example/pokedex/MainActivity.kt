package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pokedex.ui.screens.PokemonView
import com.example.pokedex.ui.viewmodels.PokemonViewModel
import com.example.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    val pokemonViewModel = PokemonViewModel(application)

                    PokemonView(pokemonViewModel)

                }
            }
        }
    }
}