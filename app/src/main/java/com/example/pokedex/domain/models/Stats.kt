package com.example.pokedex.domain.models

import com.google.gson.annotations.SerializedName
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


class Stats (

    var hp: Float = 0f,

    var atk: Float = 0f,

    var def: Float = 0f,

    var specialAttack: Float = 0f,

    var specialDefense: Float = 0f,

    var spd: Float = 0f
) {
    override fun toString(): String {
        return "Stats(hp=$hp, atk=$atk, def=$def, specialAttack=$specialAttack, specialDefense=$specialDefense, spd=$spd)"
    }
}
