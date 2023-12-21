package com.example.pokedex.data.repositories

import com.example.pokedex.domain.models.Pokemon

interface PokemonRetriever {


    fun getPokemon() : Pokemon
}