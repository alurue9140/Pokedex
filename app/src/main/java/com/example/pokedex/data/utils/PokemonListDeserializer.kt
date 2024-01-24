package com.example.pokedex.data.utils

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.models.PokemonType
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class PokemonListDeserializer : JsonDeserializer<PokemonList> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): PokemonList {
        json as JsonObject

        val pokemonList = mutableSetOf<String>()

        val results = json.get("results").asJsonArray
        results.forEach {
            val name = it.asJsonObject.get("name").asString
            pokemonList.add(name)

        }

        pokemonList.forEach{
            println(it)
        }

        return PokemonList(pokemonList)
    }
}