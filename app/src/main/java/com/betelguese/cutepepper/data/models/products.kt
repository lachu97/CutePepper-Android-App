package com.betelguese.cutepepper.data.models
import com.google.gson.annotations.SerializedName
data class products(
    val pid: Int,
    @SerializedName("pname")
    val product_name: String,
    @SerializedName("pimage")
    val product_image: String,
    val price: Int,
    val code:String,
    @SerializedName("catid")
    val categoryid:Int,
    val category:String,
    @SerializedName("pdesc")
    val description: String,
    val quantity:String,
    val supplier:String
)
//Dataclass for User
data class user(
    val email:String,
    val phoneno:String,
    val name:String,
    val password:String
)
//Dataclass for Response From external network
data class response(
    val error:Boolean,
    val message:String
)
//For Email and Password
data class emailorderid(
    val orderid:String,
    val Email:String
)
//Category Dataclass
data class Category(
    val id:Int,
    val name:String,
    val image:String
)
