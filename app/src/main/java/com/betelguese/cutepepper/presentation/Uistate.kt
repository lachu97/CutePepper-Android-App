package com.betelguese.cutepepper.presentation

import com.betelguese.cutepepper.domain.Mappers.Product

data class Uistate(
    val loading: Boolean = false,
    val resultlist: List<Product> = emptyList(),
    val error: String? = null
)