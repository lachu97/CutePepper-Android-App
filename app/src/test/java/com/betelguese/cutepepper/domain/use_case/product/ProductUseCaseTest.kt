package com.betelguese.cutepepper.domain.use_case.product

import com.betelguese.cutepepper.data.models.products
import com.betelguese.cutepepper.domain.Mappers.Product
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class ProductUseCaseTest {
    lateinit var productslist: List<products>
    lateinit var product: products
    lateinit var FakeMapper: FakeMapper
    lateinit var geterror: String

    @Before
    fun setup() {
        val fakerepo = FakeProductRepository()
        FakeMapper = FakeMapper()
        runBlocking {
            productslist = fakerepo.getProductsList()
            product = productslist.get(Random.nextInt(productslist.size))
            // geterror = throwerror().toString()
        }
    }

    @Test
    fun `getproductslists from Api successfully and check for nullability`() {
        assertNotNull(productslist)
    }

    @Test
    fun `get single product and check for nullability`() {
        val singleproduct: Product = FakeMapper.mapto(product)
        assertNotNull(singleproduct)
    }
//    @Test
//    fun `get error from network`(){
//        assertEquals("Network Not Available",geterror)
//
//    }

}