package it.macgood.sportsapp.presentation.ui.fixture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.core.network.Resource
import it.macgood.domain.model.fixture.Fixture
import it.macgood.domain.usecase.GetFixturesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val getFixturesUseCase: GetFixturesUseCase
) : ViewModel() {

    val fixtures: MutableStateFlow<Resource<List<Fixture>>> = MutableStateFlow(Resource.Loading())

    init {
        getFixtures()
    }

    private fun getFixtures() = viewModelScope.launch {
        getFixturesUseCase.invoke().collect { response ->
            fixtures.value = response
        }
    }
}