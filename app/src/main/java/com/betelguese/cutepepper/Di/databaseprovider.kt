package com.betelguese.cutepepper.Di

import android.app.Application
import androidx.room.Room
import com.betelguese.cutepepper.data.local.DB
import com.betelguese.cutepepper.data.local.cartdao
import com.betelguese.cutepepper.data.local.cartorderdao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object database {

    @Provides
    @ActivityRetainedScoped
    fun providedb(app: Application?): DB {
        return Room.databaseBuilder(app!!, DB::class.java, "BlackPepperDB").
        fallbackToDestructiveMigration().build()
    }

    @Provides
    @ActivityRetainedScoped
    fun providecartdoa(db: DB): cartdao {
        return db.cdao()
    }
    @Provides
    @ActivityRetainedScoped
    fun providecartorderdao(db: DB): cartorderdao {
        return db.codao()
    }
}