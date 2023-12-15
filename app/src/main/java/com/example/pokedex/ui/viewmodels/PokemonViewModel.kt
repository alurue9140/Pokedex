package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.data.repositories.PokemonFromJsonRetriever
import com.example.pokedex.data.repositories.PokemonRetriever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    val pokemonRepository: PokemonRetriever = PokemonFromJsonRetriever(application.applicationContext)

    init {
        loadPokemon()
    }

    private fun loadPokemon(){

        viewModelScope.launch {

            val loadedPokemon = withContext(Dispatchers.IO) {

                pokemonRepository.getPokemon()

            }

            _pokemon.postValue(loadedPokemon)

        }
    }
}
