package com.example.pokedex.data.repositories

import android.content.Context
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.data.utils.PokemonDeserializer
import com.google.gson.GsonBuilder
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject


class PokemonFromJsonRetriever @Inject constructor( @ApplicationContext private val context: Context) : PokemonRetriever {

    private val name = "eternatus-eternamax"

    override fun getPokemon(): Pokemon {
        val jsonTexto = getJsonData(context, "$name.json")
        val gSon = GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).create()

        return gSon.fromJson(jsonTexto, Pokemon::class.java)
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