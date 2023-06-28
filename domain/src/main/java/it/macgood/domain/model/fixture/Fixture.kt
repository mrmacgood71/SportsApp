package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class Fixture(
    @SerializedName("away_team_key")
    val awayTeamKey: Int,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("event_away_team")
    val eventAwayTeam: String,
    @SerializedName("event_away_team_logo")
    val eventAwayTeamLogo: String,
    @SerializedName("event_date")
    val eventDate: String,
    @SerializedName("event_final_result")
    val eventFinalResult: String,
    @SerializedName("event_home_team")
    val eventHomeTeam: String,
    @SerializedName("event_home_team_logo")
    val eventHomeTeamLogo: String,
    @SerializedName("event_key")
    val eventKey: Int,
    @SerializedName("event_live")
    val eventLive: String,
    @SerializedName("event_quarter")
    val eventQuarter: String,
    @SerializedName("event_status")
    val eventStatus: String,
    @SerializedName("event_time")
    val eventTime: String,
    @SerializedName("home_team_key")
    val homeTeamKey: Int,
    @SerializedName("league_key")
    val leagueKey: Int,
    @SerializedName("league_name")
    val leagueName: String,
    @SerializedName("league_round")
    val leagueRound: Any,
    @SerializedName("league_season")
    val leagueSeason: String,
    val lineups: Lineups,
    @SerializedName("player_statistics")
    val playerStatistics: PlayerStatistics,
    val scores: Scores,
    val statistics: List<Statistics>
)