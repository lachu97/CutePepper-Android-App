package com.betelguese.cutepepper.Hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object urls{
    @Provides
    @Singleton
    @Named("productread")
    fun provideproductsurl():String{
        return "https://www.blacky.tech/productread.php"
    }
    @Provides
    @Singleton
    @Named("categoryread")
    fun providecategoryurl():String{
        return "https://www.blacky.tech/catread.php"
    }
}