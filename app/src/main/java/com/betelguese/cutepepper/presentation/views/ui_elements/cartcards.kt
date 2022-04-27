package com.betelguese.cutepepper.presentation.views.ui_elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.betelguese.cutepepper.R
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CartCard(
    onclick: () -> Unit,
    pitems: Pro,
) {
    Card(
        modifier = Modifier
            .padding(MaterialTheme.custompadding.large)
            .fillMaxWidth()
            .clickable(onClick = onclick),
        elevation = MaterialTheme.customelevation.normal,
        shape = RoundedCornerShape(MaterialTheme.custom_corneradius.medium),
        backgroundColor = MaterialTheme.customcolor.Background500,
        border = BorderStroke(1.dp, color = Color.Black.copy(alpha = 0.6f))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(MaterialTheme.custompadding.medium),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            pitems.image.let {
                CoilImage(
                    imageModel = it,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(MaterialTheme.customsize.pxl)
                        .padding(
                            MaterialTheme.custompadding.default
                        )
                        .clip(RoundedCornerShape(MaterialTheme.custom_corneradius.medium)),
                    shimmerParams = ShimmerParams(
                        baseColor = MaterialTheme.customcolor.ShimmerBg,
                        highlightColor = Color.LightGray.copy(alpha = 0.6f),
                        durationMillis = 250,
                        dropOff = 0.65f,
                        tilt = 24f,
                    ),
                )
            }
            Spacer(modifier = Modifier.padding(MaterialTheme.custompadding.large))

            Column(horizontalAlignment = Alignment.Start) {
                pitems.name.let {
                    NewText(title = it)
                }
                Spacer(modifier = Modifier.padding(MaterialTheme.custompadding.small))
                Row {
                    NewText(title = "Price")
                    Spacer(modifier = Modifier.padding(MaterialTheme.custompadding.default))
                    pitems.price.let {
                        NewText(title = it.toString())
                    }
                }
                Spacer(modifier = Modifier.padding(MaterialTheme.custompadding.small))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    var count by remember {
                        mutableStateOf(0)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.minus), contentDescription = null,

                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                if (count > 0) {
                                    count--
                                }
                            }
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = count.toString(),
                    modifier = Modifier
                            .size(24.dp))
                    Spacer(modifier = Modifier.padding(2.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                count++
                            }

                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previewmycomponent() {
    Surface() {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            repeat(4) {
                CartCard(
                    onclick = {},
                    Pro(
                        name = "Title",
                        price = 99,
                        descrip = "SOme Random Description"
                    )
                )
            }
        }
    }
}