package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val pokemonDetailList: GetPokemonListUseCase) : ViewModel() {

    private var _pokemonList = MutableLiveData<PokemonList>()
    val pokemonList: LiveData<PokemonList> = _pokemonList

    init {
        loadList()
    }

    private fun loadList(){

        viewModelScope.launch {

            val loadedPokemon = withContext(Dispatchers.IO) {

                pokemonDetailList.getPokemonList()

            }

            _pokemonList.postValue(loadedPokemon)

        }
    }


}