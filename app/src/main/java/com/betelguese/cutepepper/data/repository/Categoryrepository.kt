package com.betelguese.cutepepper.data.repository

import com.betelguese.cutepepper.data.models.Category
import com.betelguese.cutepepper.data.remote.remoteCategoryApi
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class Categoryrepo (
    val client: HttpClient,
    val getcategoryurl: String
) : remoteCategoryApi {
    override suspend fun getCategorylist(): List<Category> {
        return client.get<List<Category>>(getcategoryurl) {
            headers {
                ContentType.Any
            }
        }
    }

}