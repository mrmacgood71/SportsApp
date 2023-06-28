package it.macgood.sportsapp.presentation.ui.player

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.core.network.Resource
import it.macgood.domain.model.player.Player
import it.macgood.domain.model.player.PlayersResult
import it.macgood.domain.usecase.GetPlayersUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    val players: MutableLiveData<Resource<List<Player>>> = MutableLiveData()

    fun getPlayers(playerName: String) = viewModelScope.launch {
        players.postValue(Resource.Loading())
        val response = getPlayersUseCase.execute(playerName)
        players.postValue(handlePlayersResponse(response))
    }

    private fun handlePlayersResponse(response: Response<PlayersResult>): Resource<List<Player>> {
        if (response.isSuccessful) {
            response.body()?.let {
                if (it.result != null) return Resource.Success(it.result)
            }
        }
        return Resource.Error("Response error")
    }

}