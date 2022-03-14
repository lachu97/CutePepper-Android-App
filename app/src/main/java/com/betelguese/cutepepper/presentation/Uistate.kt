package com.betelguese.cutepepper.presentation

import com.betelguese.cutepepper.domain.Mappers.Product
import com.betelguese.cutepepper.domain.Mappers.category

data class Uistate(
    val loading: Boolean = false,
    val resultlist: List<Product> = emptyList(),
    val error: String? = null
)
data class CategoryUistate (
    val loading:Boolean = false,
    val resultlist:List<category> = emptyList(),
    val error :String? = null
)