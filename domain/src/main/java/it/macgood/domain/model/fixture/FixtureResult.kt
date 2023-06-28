package it.macgood.domain.model.fixture

import com.google.gson.annotations.SerializedName

data class FixtureResult(
    @SerializedName("result")
    val fixtures: List<Fixture>,
    val success: Int
)