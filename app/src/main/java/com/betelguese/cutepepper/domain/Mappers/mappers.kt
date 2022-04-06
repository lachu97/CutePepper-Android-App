package com.betelguese.cutepepper.domain.Mappers

import com.betelguese.cutepepper.data.models.Category
import com.betelguese.cutepepper.data.models.products

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val category: String,
    val category_id: Int,
    val description: String,
    val quantity: String
)
data class category(
    val id:Int,
    val name: String
)
fun products.toProduct(): Product {
    return Product(
        id = pid,
        name = product_name,
        price = price,
        category = category,
        category_id = categoryid,
        description = description,
        quantity = quantity
    )
}
fun <T,E> mapperTo(data: T):E{
    TODO("dkdlk")
}

interface Mapper<in T,out E> {
    fun mapto(data: T): E //input T, output E
    //fun mapfrom(data: E): T // input E out T
}

class ProductEntityMapper() : Mapper<products, Product> {
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
class CategoryEntityMapper : Mapper<Category,category>{
    override fun mapto(data: Category): category {
        return category(
            id = data.id,
            name = data.name
        )
    }

}
