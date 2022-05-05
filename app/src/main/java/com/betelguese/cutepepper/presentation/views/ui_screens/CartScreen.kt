package com.betelguese.cutepepper.presentation.views.ui_screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.betelguese.cutepepper.presentation.views.ui_elements.*

@Composable
fun CartScreenUI() {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = MaterialTheme.customcolor.ScreenBackground700, bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.custompadding.default),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var total by remember {
                    mutableStateOf(90)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.custompadding.small),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NewText(
                        title = "Total",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace,
                        textcolor = Color.White.copy(alpha = 0.8f)
                    )
                    NewText(
                        title = "$ ${total}",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Monospace,
                        textcolor = Color.White.copy(alpha = 0.8f)
                    )
                }
                DefaultButton(
                    title = "Place Order", onclick = { total++ },
                    bgcolor = Color.Cyan.copy(alpha = 0.8f),
                    elevation = MaterialTheme.customelevation.normal,
                    cornerradius = 10.dp,
                    modifier = Modifier
                        .padding(MaterialTheme.custompadding.medium)
                        .fillMaxWidth(0.8f)
                )
            }
        }
    ) { innerpad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpad),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackTopBar()
            Divider(thickness = 1.dp, color = Color.White.copy(0.4f))
            NewText(
                title = "Cart",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace,
                textcolor = Color.White.copy(alpha = 0.6f)
            )
            Divider(thickness = 1.dp, color = Color.White.copy(0.4f))
            CartList(
                listitems = listOf(
                    Pro("Title", 90, "SOme Ds"),
                    Pro("Title 3", 910, "SOme Ds 2"),
                    Pro("Title 4", 10, "SOme Ds 2"),
                    Pro("Title 7", 108, "SOme Ds 2"),
                )
            )

        }
    }
}

@Composable
fun CartList(listitems: List<Pro>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(listitems) { _, item ->
            CartCard(onclick = { /*TODO*/ }, pitems = item)
            Divider(thickness = 1.dp, color = Color.White.copy(0.4f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    CartScreenUI()
}