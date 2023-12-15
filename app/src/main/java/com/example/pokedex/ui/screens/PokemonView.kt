package com.example.pokedex.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.ui.components.ComponentHeader
import com.example.pokedex.ui.components.ComponentName
import com.example.pokedex.ui.components.ComponentStatsCircular
import com.example.pokedex.ui.components.ComponentTitle
import com.example.pokedex.ui.components.ComponentTopAppBar
import com.example.pokedex.ui.components.ComponentType
import com.example.pokedex.ui.components.ComponentWeightHeight
import com.example.pokedex.ui.viewmodels.PokemonViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonView(pokemonViewModel: PokemonViewModel) {
    val pokemon by pokemonViewModel.pokemon.observeAsState()

    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(pokemon?.firstType?.color ?: MaterialTheme.colorScheme.background)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            pokemon?.let { ComponentTopAppBar(it.firstType!!.color, it.id) }
        }
    ) {
        pokemon?.let {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ComponentHeader(it.firstType!!.color, it.imgStr)
                ComponentName(it.name)
                ComponentType(it.firstType!!, it.secondType)
                ComponentWeightHeight(it.weight, it.height)
                ComponentTitle("Base Stats")
                ComponentStatsCircular(
                    it.stats.hp,
                    it.stats.atk,
                    it.stats.def,
                    it.stats.specialAttack,
                    it.stats.specialDefense,
                    it.stats.spd
                )
            }
        }
    }
}
