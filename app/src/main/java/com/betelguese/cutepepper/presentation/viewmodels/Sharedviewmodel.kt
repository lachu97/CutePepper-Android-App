package com.betelguese.cutepepper.utils

import androidx.compose.runtime.State
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betelguese.cutepepper.data.models.products
import com.betelguese.cutepepper.domain.use_case.product.ProductUseCase
import com.betelguese.cutepepper.presentation.Uistate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class sharedviewmodel @Inject constructor(
//    val cartdao: cartdao,
//    val dtst: MyDatastore,
//    val codao: cartorderdao,
    val productUseCase: ProductUseCase
) : ViewModel() {
    //List of Cart Items
//    val cartitems = cartdao.getcart().asLiveData()
//
//    //Order List After Successful Payment
//    val myorderlist = codao.getorders().asLiveData()

    //Write False for Logout Option in Datastore
    //Selected Item in Detail Fragment
    private val mutableSelectedItem = MutableLiveData<products>()
    val selectedItem: LiveData<products> get() = mutableSelectedItem
//    fun writefalse() {
//        viewModelScope.launch {
//            dtst.writeloggedin(false)
//        }
//    }

    init {

        getproductsfromurl()
    }

    private val _productstate = mutableStateOf<Uistate>(Uistate())
    val newstate: State<Uistate> = _productstate



    fun getproductsfromurl() {
        productUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _productstate.value = Uistate(loading = true,)
                }
                is Resource.Success -> {
                    _productstate.value = Uistate(
                        resultlist = result.data!!
                    )
                }
                is Resource.Error -> {
                    _productstate.value = Uistate(error = result.message ?: "[]")
                }
            }

        }.launchIn(viewModelScope)
    }

    //Insert Data to Cart
//    fun insertcart(cart: cart) {
//        viewModelScope.launch {
//            cartdao.insertcart(cart)
//        }
//    }
//
//    //Delete Item from Cart
//    fun delete(id: Int) {
//        viewModelScope.launch {
//            cartdao.delete(id)
//        }
//    }
}