package com.example.pokedex.data.repositories

import com.example.pokedex.data.models.Pokemon

interface PokemonRetriever {


    fun getPokemon() : Pokemon
}