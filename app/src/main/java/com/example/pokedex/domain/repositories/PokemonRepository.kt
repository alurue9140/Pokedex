package com.example.pokedex.domain.repositories

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList

interface PokemonRepository {

    fun getPokemon(name:String) : Pokemon

    fun getPokemonList() : PokemonList

}