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
import com.betelguese.cutepepper.R
import com.betelguese.cutepepper.presentation.views.ui_elements.customcolor
import com.betelguese.cutepepper.presentation.views.ui_elements.custompadding

@Composable
fun DetailSearchScreen() {
    Scaffold(backgroundColor = MaterialTheme.customcolor.ScreenBackground700) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
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
            Divider(thickness = 1.dp, color = Color.White.copy(0.4f))
            Image(
                painter = painterResource(id = R.drawable.seo),
                contentDescription = null,
                
                modifier = Modifier
                        .size(120.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewmMyDetailScreen() {
    DetailSearchScreen()
}