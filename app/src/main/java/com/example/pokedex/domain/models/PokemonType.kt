package com.example.pokedex.domain.models

import androidx.compose.ui.graphics.Color
import com.example.pokedex.ui.theme.*
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


enum class PokemonType(val color: Color) {
    NORMAL(Normal),
    FIRE(Fire),
    WATER(Water),
    ELECTRIC(Electric),
    GRASS(Grass),
    ICE(Ice),
    FIGHTING(Fighting),
    POISON(Poison),
    GROUND(Ground),
    FLYING(Flying),
    PSYCHIC(Psychic),
    BUG(Bug),
    ROCK(Rock),
    GHOST(Ghost),
    DRAGON(Dragon),
    DARK(Dark),
    STEEL(Steel),
    FAIRY(Fairy)
}
