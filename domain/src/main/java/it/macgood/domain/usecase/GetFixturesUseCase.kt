package it.macgood.domain.usecase

import it.macgood.core.network.Resource
import it.macgood.domain.model.fixture.Fixture
import it.macgood.domain.repository.SportsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFixturesUseCase @Inject constructor(
    val repository: SportsRepository
) {
    operator fun invoke(): Flow<Resource<List<Fixture>>> = flow {
        try {
            emit(Resource.Loading<List<Fixture>>())
            val response = repository.getFixtures()
            if (response.isSuccessful) {
                response.body()?.let {
                    if (it.fixtures != null) emit(Resource.Success<List<Fixture>>(it.fixtures))
                }
            } else {
                emit(Resource.Error("There is no data"))
            }
        } catch(e: HttpException) {
            emit(Resource.Error<List<Fixture>>(e.localizedMessage ?: "Unexpected error occurred"))

        } catch(e: IOException) {
            emit(Resource.Error<List<Fixture>>("IOException: Please check your Internet connection"))
        }
    }
}