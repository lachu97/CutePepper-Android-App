package com.betelguese.cutepepper.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "CartOrder")
data class CartOrders(
    @PrimaryKey(autoGenerate = true)
    val pid:Int,
    val id:Int,
    val order_id:String,
    val image:String,
    val title:String,
    val price:Int,
    val keywords:String,
    val webname:String,
    val supplier:String
)
