package com.example.pokedex.data.repositories

import com.example.pokedex.domain.models.Pokemon

interface PokemonRepository {

    fun getPokemon() : Pokemon

}