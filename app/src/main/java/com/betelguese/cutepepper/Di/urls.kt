package com.betelguese.cutepepper.Di

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
    fun provideproductsapiurl():String{
        return "https://www.blacky.tech/bpapi/productread.php"
    }
    @Provides
    @Singleton
    @Named("categoryread")
    fun providecategoryapiurl():String{
        return "https://www.blacky.tech/bpapi/catread.php"
    }
}