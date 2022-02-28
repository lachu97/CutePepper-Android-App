package com.betelguese.cutepepper.data.remote

import com.betelguese.cutepepper.data.models.products
//Interface for Remote API Endpoints
interface remoteProductApi {
    //Remote Function to get Products List
    suspend fun getProductsList():List<products>
}