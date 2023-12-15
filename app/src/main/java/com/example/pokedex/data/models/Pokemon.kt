package com.example.pokedex.data.models

import com.google.gson.annotations.SerializedName

class Pokemon(
    @SerializedName("name")
    var name: String = "",
    @SerializedName("weight")
    var weight: Float = 0.0f,
    @SerializedName("height")
    var height: Float = 0.0f,
    @SerializedName("stats")
    var stats: Stats = Stats(),
    @SerializedName("imgStr")
    var imgStr: String = "",
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("firstType")
    var firstType: PokemonType? = null,
    @SerializedName("secondType")
    var secondType: PokemonType? = null,
) {

    companion object{}
    override fun toString(): String {
        return "Pokemon(name='$name', weight=$weight, height=$height, stats=$stats, img=$imgStr, id=$id, firstType=$firstType, secondType=$secondType)"
    }
}

