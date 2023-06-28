package it.macgood.data.api

import it.macgood.data.util.Constants
import it.macgood.domain.model.fixture.FixtureResult
import it.macgood.domain.model.league.LeagueResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AllSportsBasketballApi {

    @GET("basketball/")
    suspend fun getFixtures(
        @Query("met") action: String = "Fixtures",
        @Query("APIkey") apiKey: String = Constants.API_KEY,
        @Query("from") from: String = "2023-06-27",
        @Query("to") to: String = "2023-06-28"
    ) : Response<FixtureResult>

    @GET("basketball/")
    suspend fun getLeagues(
        @Query("met") action: String = "Leagues",
        @Query("APIkey") apiKey: String = Constants.API_KEY
    ) : Response<LeagueResult>
}