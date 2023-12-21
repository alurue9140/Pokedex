package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.data.repositories.PokemonFromJsonRetriever
import com.example.pokedex.data.repositories.PokemonRetriever
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val pokemonRepository: PokemonFromJsonRetriever) : ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

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
