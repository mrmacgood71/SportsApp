package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class HomeTeam(
    @SerializedName("starting_lineups")
    val startingLineups: List<StartingLineups>,
    val substitutes: List<Substitutes>
)