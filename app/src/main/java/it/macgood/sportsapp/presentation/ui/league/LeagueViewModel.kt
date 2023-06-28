package it.macgood.sportsapp.presentation.ui.league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.core.network.Resource
import it.macgood.domain.model.league.League
import it.macgood.domain.usecase.GetLeaguesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor (
    private val getLeaguesUseCase: GetLeaguesUseCase
) : ViewModel() {

    val leagues: MutableStateFlow<Resource<List<League>>> = MutableStateFlow(Resource.Loading())

    init {
        getLeagues()
    }

    private fun getLeagues() = viewModelScope.launch {
        getLeaguesUseCase.invoke().collect { response ->
            leagues.value = response
        }
    }
}