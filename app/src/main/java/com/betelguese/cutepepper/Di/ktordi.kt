package com.betelguese.cutepepper.Di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ktorclient {
    @Provides
    @Singleton
    fun providektorclient(): HttpClient {
        return HttpClient(CIO) {
            install(JsonFeature) {
                serializer = GsonSerializer()
                install(Logging) {
                    level = LogLevel.BODY
                }
            }
        }

    }
}