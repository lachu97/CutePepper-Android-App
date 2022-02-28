package com.betelguese.cutepepper.utils

import androidx.lifecycle.*
import com.betelguese.cutepepper.data.local.cartdao
import com.betelguese.cutepepper.data.local.cartorderdao
import com.betelguese.cutepepper.data.models.cart
import com.betelguese.cutepepper.data.models.products
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class sharedviewmodel @Inject constructor(
    val cartdao: cartdao,
    val dtst: MyDatastore,
    val codao: cartorderdao,
    val client: HttpClient
) : ViewModel() {
    //List of Cart Items
    val cartitems = cartdao.getcart().asLiveData()

    //Order List After Successful Payment
    val myorderlist = codao.getorders().asLiveData()

    //Write False for Logout Option in Datastore
    //Selected Item in Detail Fragment
    private val mutableSelectedItem = MutableLiveData<products>()
    val selectedItem: LiveData<products> get() = mutableSelectedItem
    fun writefalse() {
        viewModelScope.launch {
            dtst.writeloggedin(false)
        }
    }

    //Insert Data to Cart
    fun insertcart(cart: cart) {
        viewModelScope.launch {
            cartdao.insertcart(cart)
        }
    }

    //Delete Item from Cart
    fun delete(id: Int) {
        viewModelScope.launch {
            cartdao.delete(id)
        }
    }
}