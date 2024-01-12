package com.example.pokedex.domain.usecases

import com.example.pokedex.data.repositories.PokemonRepository
import com.example.pokedex.domain.models.Pokemon
import dagger.Binds
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {

    fun getPokemonDetail() : Pokemon {
        return pokemonRepository.getPokemon()
    }




}