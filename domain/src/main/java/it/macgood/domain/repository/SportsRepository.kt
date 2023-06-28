package it.macgood.domain.repository

import it.macgood.domain.model.fixture.FixtureResult
import it.macgood.domain.model.league.LeagueResult
import it.macgood.domain.model.player.Player
import it.macgood.domain.model.player.PlayersResult
import retrofit2.Response

interface SportsRepository {
    suspend fun getFixtures() : Response<FixtureResult>
    suspend fun getLeagues() : Response<LeagueResult>
    suspend fun getPlayers(playerName: String) : Response<PlayersResult>
}