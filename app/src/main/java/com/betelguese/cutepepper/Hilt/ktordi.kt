package com.betelguese.cutepepper.Hilt

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.serializer
import javax.inject.Singleton

@Module
@InstallIn
object ktorclient {
    @Provides
    @Singleton
    fun providektorclient(): HttpClient {
        val client = HttpClient{
            install(JsonFeature){
                serializer=GsonSerializer()
            }
        }
        return client
    }
}