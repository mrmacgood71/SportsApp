package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class Quarter(
    @SerializedName("score_away")
    val scoreAway: String,
    @SerializedName("score_home")
    val scoreHome: String
)