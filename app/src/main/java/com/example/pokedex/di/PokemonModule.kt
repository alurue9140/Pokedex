package com.example.pokedex.di

import com.example.pokedex.data.repositories.PokemonApiRepositoryImpl
import com.example.pokedex.domain.repositories.PokemonRepository
import com.example.pokedex.data.repositories.PokemonFromJsonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonModule {

    @Binds
    abstract fun bindPokemonRepository(pokemonRepository: PokemonFromJsonRepository): PokemonRepository



}