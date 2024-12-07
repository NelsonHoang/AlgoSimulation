package com.nhoang.algosimulation.di

import com.nhoang.algosimulation.data.repository.AlgorithmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAlgorithmRepository(): AlgorithmRepository {
        return AlgorithmRepository()
    }
}