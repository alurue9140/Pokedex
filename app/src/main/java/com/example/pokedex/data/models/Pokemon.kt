package com.example.pokedex.data.models

class Pokemon(
    var name: String = "",
    var weight: Float = 0.0f,
    var height: Float = 0.0f,
    var stats: Stats = Stats(),
    var imgStr: String = "",
    var id : Int = 0,
    var firstType: PokemonType? = null,
    var secondType: PokemonType? = null,
) {

    companion object{}
    override fun toString(): String {
        return "Pokemon(name='$name', weight=$weight, height=$height, stats=$stats, img=$imgStr, id=$id, firstType=$firstType, secondType=$secondType)"
    }
}

