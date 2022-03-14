package com.betelguese.cutepepper.domain.use_case.category

import com.betelguese.cutepepper.data.repository.Categoryrepo
import com.betelguese.cutepepper.domain.Mappers.CategoryEntityMapper
import com.betelguese.cutepepper.domain.Mappers.category
import com.betelguese.cutepepper.utils.Resource
import io.ktor.client.call.*
import io.ktor.util.network.*
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryUsecase @Inject constructor(
    val categoryrepo: Categoryrepo,
    val categoryEntityMapper: CategoryEntityMapper
) {
    operator fun invoke(): Flow<Resource<List<category>>> {
        return flow {
            try {
                emit(Resource.Loading<List<category>>())
                delay(250L)
                val categorylist = categoryrepo.getCategorylist().map {
                    categoryEntityMapper.mapto(it)
                }
                delay(150L)
                emit(Resource.Success<List<category>>(categorylist))
            } catch (e: IOException) {
                emit(Resource.Error<List<category>>(e.localizedMessage))
            } catch (e: NoTransformationFoundException) {
                emit(Resource.Error<List<category>>("Some Error Occured" + e.localizedMessage))
            } catch(e : UnresolvedAddressException){
                emit(Resource.Error<List<category>>("Some Error Occured" + e.localizedMessage +e.message))
            }
        }
    }
}