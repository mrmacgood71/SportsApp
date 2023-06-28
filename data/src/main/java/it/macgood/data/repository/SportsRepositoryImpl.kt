package it.macgood.data.repository

import it.macgood.data.api.AllSportsBasketballApi
import it.macgood.data.api.AllSportsFootballApi
import it.macgood.domain.model.fixture.FixtureResult
import it.macgood.domain.model.league.LeagueResult
import it.macgood.domain.model.player.PlayersResult
import it.macgood.domain.repository.SportsRepository
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SportsRepositoryImpl @Inject constructor (
    private val basketballApi: AllSportsBasketballApi,
    private val footballApi: AllSportsFootballApi
) : SportsRepository {

    override suspend fun getFixtures(): Response<FixtureResult> {
        val now = System.currentTimeMillis()
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = format.format(Date(now))
        val tomorrow = format.format(Date(now + 86_400_000))
        return basketballApi.getFixtures(from = today, to = tomorrow)
    }

    override suspend fun getLeagues(): Response<LeagueResult> = basketballApi.getLeagues()

    override suspend fun getPlayers(playerName: String): Response<PlayersResult>
                                                = footballApi.getPlayers(playerName = playerName)
}