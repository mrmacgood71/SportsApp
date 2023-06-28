package it.macgood.sportsapp.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.macgood.data.repository.SportsRepositoryImpl
import it.macgood.domain.repository.SportsRepository

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    fun provideSportsRepository(repositoryImpl: SportsRepositoryImpl): SportsRepository


}