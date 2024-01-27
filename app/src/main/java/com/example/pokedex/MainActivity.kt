package com.example.pokedex

import android.app.Application
import android.os.Bundle
import android.os.StrictMode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.ui.screens.PokemonListView
import com.example.pokedex.ui.screens.PokemonView
import com.example.pokedex.ui.viewmodels.PokemonViewModel
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokedexApp : Application()
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val pokemonListViewModel: PokemonListViewModel by viewModels()

    val pokemonViewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    StrictMode.setThreadPolicy(
                        StrictMode.ThreadPolicy.Builder().permitAll().build()
                    )

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "PokemonList") {
                        composable("PokemonList"){ PokemonListView(pokemonListViewModel, navController) }
                        //composable("Pokemon") {PokemonView(pokemonViewModel)}
                        composable("Pokemon/{namePokemon}", arguments = listOf(
                            navArgument("namePokemon") {type = NavType.StringType}
                        )) {backStackEntry ->
                            val param = backStackEntry.arguments?.getString("namePokemon")
                            pokemonViewModel.setPokemonNameAndGetData(param!!)
                            PokemonView(pokemonViewModel, navController)

                        }
                    }
                }
            }
        }
    }
}
