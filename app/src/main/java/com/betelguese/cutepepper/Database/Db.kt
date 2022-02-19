package com.betelguese.cutepepper.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.betelguese.cutepepper.models.CartOrders
import com.betelguese.cutepepper.models.cart


@Database(entities = arrayOf(cart::class, CartOrders::class),version = 1,exportSchema = false)
abstract class DB: RoomDatabase() {
    abstract fun cdao():cartdao
    abstract fun codao():cartorderdao
}