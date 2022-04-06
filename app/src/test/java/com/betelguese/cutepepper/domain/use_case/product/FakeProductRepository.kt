package com.betelguese.cutepepper.domain.use_case.product

import com.betelguese.cutepepper.data.models.products
import com.betelguese.cutepepper.data.remote.remoteProductApi
import com.betelguese.cutepepper.domain.Mappers.Mapper
import com.betelguese.cutepepper.domain.Mappers.Product

class FakeProductRepository : remoteProductApi {
    val products:List<products> = listOf(
        products(7,"some Random Product","",90,"",2,"","","",""),
        products(17,"some Random Product 345","",940,"",782,"","","",""),
    )
    override suspend fun getProductsList(): List<products> {
        return products
    }
}
suspend fun throwerror() {
    throw Exception("Network Not Available")
}
class FakeMapper : Mapper<products, Product> {
    override fun mapto(data: products): Product {
        return Product(
            id = data.pid,
            name = data.product_name,
            price = data.price,
            quantity = data.quantity,
            description = data.description,
            category_id = data.categoryid,
            category = data.category
        )
    }

}