package com.betelguese.cutepepper.data.repository

import com.betelguese.cutepepper.data.models.products
import com.betelguese.cutepepper.data.remote.remoteProductApi
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class Productrepo constructor(
    val client: HttpClient,
    val getproducturl: String
) : remoteProductApi {

    override suspend fun getProductsList(): List<products> {
        return client.get<List<products>>(getproducturl) {
            headers {
                ContentType.Any
            }
        }
    }

}