package com.betelguese.cutepepper.utils

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.betelguese.cutepepper.data.local.cartdao
import com.betelguese.cutepepper.data.local.cartorderdao
import com.betelguese.cutepepper.data.models.cart
import com.betelguese.cutepepper.data.models.products
import com.betelguese.cutepepper.domain.Mappers.Product
import com.betelguese.cutepepper.domain.use_case.product.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class sharedviewmodel @Inject constructor(
    val cartdao: cartdao,
    val dtst: MyDatastore,
    val codao: cartorderdao,
    val productUseCase: ProductUseCase
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

    init {
        getproductsfromurl()
    }

    private val _productstate = mutableStateOf<Uistate>(Uistate())
    val newstate: State<Uistate> = _productstate

    data class Uistate(
        val loading: Boolean = false,
        val resultlist: List<Product> = emptyList(),
        val error: String = "null"
    )

    fun getproductsfromurl() {
        productUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _productstate.value = Uistate(loading = true)
                }
                is Resource.Success -> {
                    _productstate.value = Uistate(
                        loading = false,
                        resultlist = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _productstate.value = Uistate(loading = false, error = result.message ?: "[]")
                }
            }

        }.launchIn(viewModelScope)
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