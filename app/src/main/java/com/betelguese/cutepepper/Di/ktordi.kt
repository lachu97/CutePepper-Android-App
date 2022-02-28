package com.betelguese.cutepepper.Di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import io.ktor.client.*
import io.ktor.client.features.json.*
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