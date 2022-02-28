package com.betelguese.cutepepper.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.betelguese.cutepepper.data.models.CartOrders
import com.betelguese.cutepepper.data.models.cart


@Database(entities = arrayOf(cart::class, CartOrders::class),version = 1,exportSchema = false)
abstract class DB: RoomDatabase() {
    abstract fun cdao(): cartdao
    abstract fun codao(): cartorderdao
}