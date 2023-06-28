package it.macgood.domain.model.player

data class PlayersResult(
    val result: List<Player>,
    val success: Int
)