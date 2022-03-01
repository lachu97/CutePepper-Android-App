package com.betelguese.cutepepper.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betelguese.cutepepper.domain.use_case.product.ProductUseCase
import com.betelguese.cutepepper.presentation.Uistate
import com.betelguese.cutepepper.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class randomviewmodel @Inject constructor(
    val useCase: ProductUseCase
) : ViewModel(){
    private val _uistate = mutableStateOf<Uistate>(Uistate())
    val newstate: State<Uistate> = _uistate
    init {
        getproductsfromurl()
    }
    fun getproductsfromurl() {
        useCase().onEach { resultOf ->
            when (resultOf) {
                is Resource.Loading -> {
                    _uistate.value = Uistate(loading = true,)
                }
                is Resource.Success -> {
                    _uistate.value = Uistate(
                        resultlist = resultOf.data!!
                    )
                }
                is Resource.Error -> {
                    _uistate.value = Uistate(error = resultOf.message ?: "[]")
                }
            }

        }.launchIn(viewModelScope)
    }
}