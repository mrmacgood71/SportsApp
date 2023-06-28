package it.macgood.domain.model.league

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("country_key")
    val countryKey: Int,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("league_key")
    val leagueKey: Int,
    @SerializedName("league_name")
    val leagueName: String
)