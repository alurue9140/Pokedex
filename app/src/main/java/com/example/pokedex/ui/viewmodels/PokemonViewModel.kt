package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val pokemonDetail: GetPokemonDetailUseCase) : ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon?>()
    val pokemon: MutableLiveData<Pokemon?> = _pokemon

    private var _pokemonName = ""

    init {
        setPokemonNameAndGetData(_pokemonName)
    }

    fun setPokemonNameAndGetData(name: String) {
        _pokemon.postValue(null)
        loadPokemon(name)
    }

    private fun loadPokemon(name : String){
        _pokemonName = name
        viewModelScope.launch {

            val loadedPokemon = withContext(Dispatchers.IO) {

                pokemonDetail.getPokemonDetail(_pokemonName)

            }

            _pokemon.postValue(loadedPokemon)

        }
    }
}
