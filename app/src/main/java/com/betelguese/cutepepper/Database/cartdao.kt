package com.betelguese.cutepepper.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.betelguese.cutepepper.models.cart
import kotlinx.coroutines.flow.Flow

@Dao
interface cartdao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertcart(cart: cart)
    @Query("Select * from Cart")
    fun getcart(): Flow<List<cart>>
    @Query("DELETE FROM Cart WHERE id=:id")
    suspend fun delete(id:Int)
    @Query("DELETE FROM Cart")
    suspend fun deletecart()
}