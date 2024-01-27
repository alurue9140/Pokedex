package com.example.pokedex.data.repositories

import android.content.Context
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.data.utils.PokemonDeserializer
import com.example.pokedex.data.utils.PokemonListDeserializer
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.PokemonRepository
import com.google.gson.GsonBuilder
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject


class PokemonFromJsonRepository @Inject constructor(@ApplicationContext private val context: Context) : PokemonRepository {


    override fun getPokemon(name : String): Pokemon {
        val jsonText = getJsonData(context, "$name.json")
        val gSon = GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).create()

        return gSon.fromJson(jsonText, Pokemon::class.java)
    }

    override fun getPokemonList(): PokemonList {
        val jsonText = getJsonData(context, "list.json")
        val gSon = GsonBuilder().registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer()).create()

        return gSon.fromJson(jsonText, PokemonList::class.java)
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