package com.example.pokedex.domain.usecases

import com.example.pokedex.domain.repositories.PokemonRepository
import com.example.pokedex.domain.models.Pokemon
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {

    fun getPokemonDetail() : Pokemon {
        return pokemonRepository.getPokemon()
    }




}