package com.betelguese.cutepepper.presentation.views.ui_screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.betelguese.cutepepper.presentation.views.ui_elements.customcolor

@Composable
fun homeScreen() {
    Scaffold(
    modifier = Modifier
            .fillMaxSize(),
    backgroundColor = MaterialTheme.customcolor.ScreenBackground700) {

    }
}

@Preview(showBackground = true)
@Composable
fun homescreenpreview() {
    homeScreen()
}