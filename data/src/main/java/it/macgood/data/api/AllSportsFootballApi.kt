package it.macgood.data.api

import it.macgood.data.util.Constants
import it.macgood.domain.model.player.PlayersResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AllSportsFootballApi {

    @GET("football/")
    suspend fun getPlayers (
        @Query("met") action: String = "Players",
        @Query("APIkey") apiKey: String = Constants.API_KEY,
        @Query("playerName") playerName: String
    ) : Response<PlayersResult>
}