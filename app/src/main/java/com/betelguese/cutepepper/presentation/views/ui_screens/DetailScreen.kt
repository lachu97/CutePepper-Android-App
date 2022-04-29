package com.betelguese.cutepepper.presentation.views.ui_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.betelguese.cutepepper.R
import com.betelguese.cutepepper.presentation.views.ui_elements.*
import com.betelguese.cutepepper.utils.getWindowInfo

@Composable
fun DetailSearchScreen(
    selectedItems: Pro
) {
    val windowinfo = getWindowInfo()
    val cardwidth = windowinfo.screenWidth

    Scaffold(
        backgroundColor = MaterialTheme.customcolor.ScreenBackground700,
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DefaultButton(title = "My Button", onclick = { /*TODO*/ })
                DefaultButton(title = "My Button 2", onclick = { /*TODO*/ })
            }
        }
    ) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackTopBar()
            Divider(thickness = 1.dp, color = Color.White.copy(0.4f))
            Image(
                painter = painterResource(id = R.drawable.seo),
                contentDescription = null,

                modifier = Modifier
                    .size(cardwidth / 1.2f)
            )
            Divider(thickness = 1.dp, color = Color.White.copy(0.4f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.custompadding.small),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NewText(title = selectedItems.name, fontSize = 21.sp)
                NewText(title = "Price" + selectedItems.price.toString(), fontSize = 18.sp)

            }
            Divider(thickness = 1.dp, color = Color.White.copy(0.4f))

            Paragraph(
                title = selectedItems.descrip + "Lorem Ipsum with some dummy content"
                +"With More than anything else in this industry with the following app being successful ",
                modifier = Modifier
                    .padding(MaterialTheme.custompadding.medium)
            , maxlines = 8
            )


        }
    }
}

@Composable
fun BackTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,

            modifier = Modifier
                .padding(MaterialTheme.custompadding.small)
                .size(48.dp),
            tint = MaterialTheme.customcolor.Background700
        )


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewmMyDetailScreen() {
    DetailSearchScreen(
        Pro(
            "Product Name",
            450,
            "https://cdn.pixabay.com/photo/2022/04/21/19/47/lion-7148207_1280.jpg"
        )
    )
}