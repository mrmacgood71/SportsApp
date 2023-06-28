package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class StartingLineups(
    val player: String,
    @SerializedName("player_id")
    val playerId: String
)