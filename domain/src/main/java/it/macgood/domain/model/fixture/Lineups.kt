package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class Lineups(
    @SerializedName("away_team")
    val awayTeam: AwayTeam,
    @SerializedName("home_team")
    val homeTeam: HomeTeam
)