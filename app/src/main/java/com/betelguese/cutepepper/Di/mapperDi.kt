package com.betelguese.cutepepper.Di

import com.betelguese.cutepepper.domain.Mappers.CategoryEntityMapper
import com.betelguese.cutepepper.domain.Mappers.ProductEntityMapper
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
    fun provideproductmapper(): ProductEntityMapper {
        return ProductEntityMapper()
    }
    @Provides
    @Singleton
    fun providecategorymapper():CategoryEntityMapper{
        return CategoryEntityMapper()
    }
}