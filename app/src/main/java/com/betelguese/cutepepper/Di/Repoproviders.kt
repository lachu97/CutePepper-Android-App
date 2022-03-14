package com.betelguese.cutepepper.Di

import com.betelguese.cutepepper.data.repository.Categoryrepo
import com.betelguese.cutepepper.data.repository.Productrepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object repoproviders {
    @Provides
    @Singleton
    fun provideProductRepo(
        client: HttpClient,
        @Named("productread") getproducturl: String
    ): Productrepo {
        return Productrepo(
            client = client,
            getproducturl = getproducturl
        )
    }

    @Provides
    @Singleton
    fun provideCategoryrepo(
        client: HttpClient,
        @Named("categoryread") getcategoryurl: String
    ): Categoryrepo {
        return Categoryrepo(
            client = client,
            getcategoryurl = getcategoryurl
        )
    }
}