package it.macgood.domain.model.player

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("player_age")
    val playerAge: String,
    @SerializedName("player_assists")
    val playerAssists: String,
    @SerializedName("player_blocks")
    val playerBlocks: String,
    @SerializedName("player_clearances")
    val playerClearances: String,
    @SerializedName("player_country")
    val playerCountry: Any,
    @SerializedName("player_crosses_total")
    val playerCrossesTotal: String,
    @SerializedName("player_dispossesed")
    val playerDispossesed: String,
    @SerializedName("player_dribble_attempts")
    val playerDribbleAttempts: String,
    @SerializedName("player_dribble_succ")
    val playerDribbleSuccessful: String,
    @SerializedName("player_duels_total")
    val playerDuelsTotal: String,
    @SerializedName("player_duels_won")
    val playerDuelsWon: String,
    @SerializedName("player_fouls_commited")
    val playerFoulsCommited: String,
    @SerializedName("player_goals")
    val playerGoals: String,
    @SerializedName("player_goals_conceded")
    val playerGoalsConceded: String,
    @SerializedName("player_image")
    val playerImage: String,
    @SerializedName("player_injured")
    val playerInjured: String,
    @SerializedName("player_inside_box_saves")
    val playerInsideBoxSaves: String,
    @SerializedName("player_interceptions")
    val playerInterceptions: String,
    @SerializedName("player_is_captain")
    val playerIsCaptain: String,
    @SerializedName("player_key")
    val playerKey: Long,
    @SerializedName("player_key_passes")
    val playerKeyPasses: String,
    @SerializedName("player_match_played")
    val playerMatchPlayed: String,
    @SerializedName("player_minutes")
    val playerMinutes: String,
    @SerializedName("player_name")
    val playerName: String,
    @SerializedName("player_number")
    val playerNumber: String,
    @SerializedName("player_passes")
    val playerPasses: String,
    @SerializedName("player_passes_accuracy")
    val playerPassesAccuracy: String,
    @SerializedName("player_pen_comm")
    val playerPenComm: String,
    @SerializedName("player_pen_missed")
    val playerPenMissed: String,
    @SerializedName("player_pen_scored")
    val playerPenScored: String,
    @SerializedName("player_pen_won")
    val playerPenWon: String,
    @SerializedName("player_rating")
    val playerRating: String,
    @SerializedName("player_red_cards")
    val playerRedCards: String,
    @SerializedName("player_saves")
    val playerSaves: String,
    @SerializedName("player_shots_total")
    val playerShotsTotal: String,
    @SerializedName("player_substitute_out")
    val playerSubstituteOut: String,
    @SerializedName("player_substitutes_on_bench")
    val playerSubstitutesOnBench: String,
    @SerializedName("player_tackles")
    val playerTackles: String,
    @SerializedName("player_type")
    val playerType: String,
    @SerializedName("player_woordworks")
    val playerWoordworks: String,
    @SerializedName("player_yellow_cards")
    val playerYellowCards: String,
    @SerializedName("team_key")
    val teamKey: String,
    @SerializedName("team_name")
    val teamName: String
)