package com.betelguese.cutepepper.viewmodels

import androidx.lifecycle.*
import com.betelguese.cutepepper.Database.cartdao
import com.betelguese.cutepepper.Database.cartorderdao
import com.betelguese.cutepepper.Hilt.ktorclient
import com.betelguese.cutepepper.models.cart
import com.betelguese.cutepepper.models.products
import com.betelguese.cutepepper.utils.MyDatastore
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class sharedviewmodel @Inject constructor(
val cartdao: cartdao,
val dtst:MyDatastore,
val codao:cartorderdao,
val client: HttpClient
):ViewModel(){
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