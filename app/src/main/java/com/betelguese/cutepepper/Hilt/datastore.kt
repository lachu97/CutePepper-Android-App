package com.betelguese.cutepepper.Hilt

import android.content.Context
import com.betelguese.cutepepper.utils.MyDatastore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object datastore {
    @Provides
    @Singleton
    fun providedtst(@ApplicationContext ctx: Context): MyDatastore {
        return MyDatastore(ctx)
    }
}