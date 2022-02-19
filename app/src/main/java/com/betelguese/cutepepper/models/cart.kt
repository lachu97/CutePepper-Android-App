package com.betelguese.cutepepper.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Cart")
data class cart(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val image:String,
    val title:String,
    val price:Int,
    val keywords:String,
    val webname:String,
    val supplier:String,
    val quantity:String
)
