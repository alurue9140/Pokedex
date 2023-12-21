package com.example.pokedex.data.utils

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonType
import com.example.pokedex.domain.models.Stats
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.reflect.Type
import javax.inject.Inject

@ActivityScoped
class PokemonDeserializer @Inject constructor() : JsonDeserializer<Pokemon> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Pokemon {
        json as JsonObject

        val stats = Stats()
        val img : String
        var firstType: PokemonType? = null
        var secondType: PokemonType? = null

        val name: String = json.get("name").asString

        val spritesA = json.get("sprites").asJsonObject
        val otherA = spritesA.get("other").asJsonObject
        val artworkA = otherA.get("official-artwork").asJsonObject
        img = artworkA.get("front_default").asString

        val height : Float = json.get("height").asFloat

        val id : Int = json.get("id").asInt

        val statsMap = mapOf(
            "hp" to stats::hp,
            "attack" to stats::atk,
            "defense" to stats::def,
            "special-attack" to stats::specialAttack,
            "special-defense" to stats::specialDefense,
            "speed" to stats::spd
        )

        val statsArray = json.get("stats").asJsonArray
        statsArray.forEach {
            val statName = it.asJsonObject.get("stat").asJsonObject.get("name").asString
            statsMap[statName]?.set(it.asJsonObject.get("base_stat").asFloat)
        }

        val typesArray = json.get("types").asJsonArray
        typesArray.forEach{
            val slot = it.asJsonObject.get("slot").asInt

            val typeO = it.asJsonObject.get("type").asJsonObject

            val type = typeO.get("name").asString

            if (slot == 1) {

                firstType = PokemonType.valueOf(type.uppercase())

            } else if (slot == 2){

                secondType = PokemonType.valueOf(type.uppercase())

            }
        }

        val weight : Float = json.get("weight").asFloat


        return Pokemon(name = name, weight = weight, height = height, stats = stats, imgStr = img, id = id, firstType = firstType!!, secondType = secondType)
    }


}