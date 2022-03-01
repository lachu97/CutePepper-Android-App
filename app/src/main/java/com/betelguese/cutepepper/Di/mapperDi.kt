package com.betelguese.cutepepper.Di

import com.betelguese.cutepepper.domain.Mappers.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object mappers {
    @Provides
    @Singleton
    fun provideproductmapper(): EntityMapper {
        return EntityMapper()
    }
}