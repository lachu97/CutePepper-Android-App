package com.betelguese.cutepepper.data.remote

import com.betelguese.cutepepper.data.models.Category

//Interface for Remote API for Category
interface remoteCategoryApi {
    //function to get Category List
    suspend fun getCategorylist():List<Category>
}