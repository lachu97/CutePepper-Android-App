package com.betelguese.cutepepper.domain.use_case.product

import com.betelguese.cutepepper.data.repository.Productrepo
import com.betelguese.cutepepper.domain.Mappers.EntityMapper
import com.betelguese.cutepepper.domain.Mappers.Product
import com.betelguese.cutepepper.utils.Resource
import io.ktor.client.call.*
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    val productrepo: Productrepo,
    val mapper: EntityMapper
) {
    operator fun invoke(): Flow<Resource<List<Product>>> {
        return flow {

            try {
                emit(Resource.Loading<List<Product>>())
                delay(500L)
                val productslist = productrepo.getProductsList().map {
                    //it.toProduct()
                    mapper.mapto(it)
                }
                delay(250L)
                emit(Resource.Success<List<Product>>(productslist))
            } catch (e: IOException) {
                emit(Resource.Error<List<Product>>("Some Error Occured" + e.localizedMessage))

            } catch (e: NoTransformationFoundException) {
                emit(Resource.Error<List<Product>>("Some Error Occured" + e.localizedMessage))

            }
        }
    }
}