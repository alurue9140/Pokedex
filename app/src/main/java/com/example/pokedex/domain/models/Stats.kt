package com.example.pokedex.domain.models

import com.google.gson.annotations.SerializedName
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class Stats @Inject constructor(
    @SerializedName("hp")
    var hp: Float = 0f,
    @SerializedName("atk")
    var atk: Float = 0f,
    @SerializedName("def")
    var def: Float = 0f,
    @SerializedName("specialAttack")
    var specialAttack: Float = 0f,
    @SerializedName("specialDefense")
    var specialDefense: Float = 0f,
    @SerializedName("spd")
    var spd: Float = 0f
) {
    override fun toString(): String {
        return "Stats(hp=$hp, atk=$atk, def=$def, specialAttack=$specialAttack, specialDefense=$specialDefense, spd=$spd)"
    }
}
