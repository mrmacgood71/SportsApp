package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class PlayerStatisticsInfo(
    val player: String,
    @SerializedName("player_assists")
    val playerAssists: String,
    @SerializedName("player_blocks")
    val playerBlocks: String,
    @SerializedName("player_defense_rebounds")
    val playerDefenseRebounds: String,
    @SerializedName("player_field_goals_attempts")
    val playerFieldGoalsAttempts: String,
    @SerializedName("player_field_goals_made")
    val playerFieldGoalsMade: String,
    @SerializedName("player_freethrows_goals_attempts")
    val playerFreethrowsGoalsAttempts: String,
    @SerializedName("player_freethrows_goals_made")
    val playerFreethrowsGoalsMade: String,
    @SerializedName("player_id")
    val playerId: String,
    @SerializedName("player_minutes")
    val playerMinutes: String,
    @SerializedName("player_offence_rebounds")
    val playerOffenceRebounds: String,
    @SerializedName("player_oncourt")
    val playerOncourt: String,
    @SerializedName("player_personal_fouls")
    val playerPersonalFouls: String,
    @SerializedName("player_plus_minus")
    val playerPlusMinus: String,
    @SerializedName("player_points")
    val playerPoints: String,
    @SerializedName("player_position")
    val playerPosition: String,
    @SerializedName("player_steals")
    val playerSteals: String,
    @SerializedName("player_threepoint_goals_attempts")
    val playerThreepointGoalsAttempts: String,
    @SerializedName("player_threepoint_goals_made")
    val playerThreepointGoalsMade: String,
    @SerializedName("player_total_rebounds")
    val playerTotalRebounds: String,
    @SerializedName("player_turnovers")
    val playerTurnovers: String
)