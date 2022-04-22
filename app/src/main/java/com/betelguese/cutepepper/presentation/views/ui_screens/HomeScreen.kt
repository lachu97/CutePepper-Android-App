package com.betelguese.cutepepper.presentation.views.ui_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.betelguese.cutepepper.presentation.views.ui_elements.*

@Composable
fun homeScreen() {

        Column(
        modifier = Modifier
                .fillMaxSize()) {

            topBar()
            Spacer(modifier = Modifier.padding(MaterialTheme.custompadding.small))
            NewText(
                title = "Category",
                textcolor = Color.White.copy(
                alpha = 0.6f
            ),
                fontSize = 21.sp,
                modifier = Modifier.padding(MaterialTheme.custompadding.large)

            )
            Divider(color = Color.White.copy(alpha = 0.4f))
            CategoryList(listItems = listOf("one","two","2three","four4","scifi","5fi","8eight","6sixy","7seven"))
            NewText(
                title = "Product",
                textcolor = Color.White.copy(
                    alpha = 0.6f
                ),
                fontSize = 21.sp,
                modifier = Modifier.padding(MaterialTheme.custompadding.large)

            )
            Divider(color = Color.White.copy(alpha = 0.4f))
            ProductMainList()
        }
}

@Preview(showBackground = true)
@Composable
fun homescreenpreview() {
    homeScreen()
}