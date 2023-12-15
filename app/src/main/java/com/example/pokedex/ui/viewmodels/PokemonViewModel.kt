package com.example.pokedex.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repositories.PokemonDeserializer
import com.example.pokedex.data.models.Pokemon
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    private val context = getApplication<Application>().applicationContext

    init {
        loadPokemon("lucario")
    }

    private fun loadPokemon(pokemonName: String){

        viewModelScope.launch {

            val loadedPokemon = withContext(Dispatchers.IO) {

                val jsonTexto = getJsonData(context, "${pokemonName.lowercase()}.json")
                val gSon = GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).create()

                gSon.fromJson(jsonTexto, Pokemon::class.java)
            }

            _pokemon.postValue(loadedPokemon)

        }
    }

    private fun getJsonData(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
