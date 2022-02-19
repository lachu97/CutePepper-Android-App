package com.betelguese.cutepepper.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.betelguese.cutepepper.models.CartOrders
import kotlinx.coroutines.flow.Flow

@Dao
interface cartorderdao {
    @Insert
    suspend fun insertorders(orders :List<CartOrders>)
    @Query("SELECT * FROM CartOrder")
    fun getorders(): Flow<List<CartOrders>>
}