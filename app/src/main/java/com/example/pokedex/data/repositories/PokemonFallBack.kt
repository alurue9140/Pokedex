package com.example.pokedex.data.repositories

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject
class PokemonFallBack @Inject constructor(
    apiRepository: PokemonApiRepositoryImpl,
    jsonRepository: PokemonFromJsonRepository
) : PokemonRepository {

    private val pokemonRepository: PokemonRepository =
        try {
            if (apiRepository.getPokemonList().list.isEmpty()) {
                jsonRepository
            } else {
                apiRepository
            }
        } catch (e: Exception) {
            jsonRepository
        }

    override fun getPokemon(name: String): Pokemon {
        return pokemonRepository.getPokemon(name)
    }

    override fun getPokemonList(): PokemonList {
        return pokemonRepository.getPokemonList()
    }
}
