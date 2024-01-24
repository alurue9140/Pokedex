package com.example.pokedex.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import java.util.Locale


@Composable
fun PokemonListView (pokemonListViewModel: PokemonListViewModel, navController: NavHostController) {

    val pokemonList by pokemonListViewModel.pokemonList.observeAsState()

    if (pokemonList != null) {
        Column (
            modifier = Modifier.fillMaxSize()
        ){

            LazyColumn (
                contentPadding = PaddingValues(5.dp)
            ) {
                items(pokemonList?.list!!.toList() ) { pokemon ->
                    Card (
                        modifier = Modifier.fillMaxWidth().padding(5.dp).clickable {

                            navController.navigate("Pokemon/${pokemon}")
                                                                                   },
                        elevation = CardDefaults.cardElevation(4.dp),
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = pokemon.uppercase(Locale.ROOT),
                                fontSize = 25.sp
                            )
                        }
                    }
                }
            }

        }
    }



}