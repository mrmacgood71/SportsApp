package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class PlayerStatistics(
    @SerializedName("away_team")
    val awayTeam: List<PlayerStatisticsInfo>,
    @SerializedName("home_team")
    val homeTeam: List<PlayerStatisticsInfo>
)