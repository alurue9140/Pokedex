package com.example.pokedex.domain.models

import com.google.gson.annotations.SerializedName
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class Pokemon @Inject constructor(

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

