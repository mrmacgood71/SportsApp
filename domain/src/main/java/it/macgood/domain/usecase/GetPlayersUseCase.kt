package it.macgood.domain.usecase

import it.macgood.domain.repository.SportsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPlayersUseCase @Inject constructor(
    private val repository: SportsRepository
) {
    suspend fun execute(playerName: String) = repository.getPlayers(playerName)
}