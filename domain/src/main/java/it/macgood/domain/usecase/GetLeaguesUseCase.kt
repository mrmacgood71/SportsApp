package it.macgood.domain.usecase

import it.macgood.core.network.Resource
import it.macgood.domain.model.league.League
import it.macgood.domain.repository.SportsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetLeaguesUseCase @Inject constructor(
    private val repository: SportsRepository
) {
    operator fun invoke() : Flow<Resource<List<League>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getLeagues()
            if (response.isSuccessful) {
                response.body()?.let {
                    if (it.leagues != null) emit(Resource.Success<List<League>>(it.leagues))
                }
            }else {
                emit(Resource.Error<List<League>>("No data"))
            }
        } catch(e: HttpException) {
            emit(Resource.Error<List<League>>(e.localizedMessage ?: "Unexpected error occurred"))

        } catch(e: IOException) {
            emit(Resource.Error<List<League>>("IOException: Please check your Internet connection"))
        }
    }
}