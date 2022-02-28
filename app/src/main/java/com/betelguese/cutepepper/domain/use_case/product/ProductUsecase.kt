package com.betelguese.cutepepper.domain.use_case.product

import com.betelguese.cutepepper.data.repository.Productrepo
import javax.inject.Inject

class ProductUsecase @Inject constructor(
    val productrepo: Productrepo
){
    operator fun invoke(){

    }
}