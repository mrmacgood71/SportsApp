package it.macgood.domain.model.league

import com.google.gson.annotations.SerializedName

data class LeagueResult(
    @SerializedName("result")
    val leagues: List<League>,
    val success: Int
)