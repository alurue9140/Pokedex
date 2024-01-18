package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.sources.remote.PokeApi
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val pokemonDetail: GetPokemonDetailUseCase) : ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    init {
        loadPokemon()
    }

    private fun loadPokemon(){

        viewModelScope.launch {

            val loadedPokemon = withContext(Dispatchers.IO) {

                pokemonDetail.getPokemonDetail()

            }

            _pokemon.postValue(loadedPokemon)

        }
    }
}
