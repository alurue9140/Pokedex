package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.remote.PokeApi
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import retrofit2.Call
import javax.inject.Inject

class PokemonApiRepositoryImpl @Inject constructor() : PokemonRepository {

    private val name = "zekrom"

    override fun getPokemon(): Pokemon {

        return PokeApi.pokemonService.getPokemonByName(name).execute().body()!!
    }
}
