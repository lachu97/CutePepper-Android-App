package com.betelguese.cutepepper.presentation.views.ui_elements

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.betelguese.cutepepper.ui.theme.CutePepperTheme
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import kotlinx.coroutines.delay


@Composable
fun CategoryList(
    listItems: List<String>

) {
    val ctx = LocalContext.current
    LazyRow(
        modifier = Modifier
            .padding(MaterialTheme.custompadding.medium)
            .fillMaxWidth()
    ) {
        itemsIndexed(listItems) { idx, item ->
            CategoryCard(
                onclick = {
                    Toast.makeText(
                        ctx, "CLicked item name -${idx} and ${item}",
                        Toast.LENGTH_LONG
                    ).show()
                },
                itemName = item
            )
        }
    }

}

@Composable
fun CategoryCard(
    onclick: () -> Unit,
    itemName: String,
) {
    Card(
        modifier = Modifier
            .padding(MaterialTheme.custompadding.medium)
            .clickable(onClick = onclick),
        elevation = MaterialTheme.customelevation.high,
        backgroundColor = MaterialTheme.customcolor.Background500,
        border = BorderStroke(1.dp, color = MaterialTheme.customcolor.Border700),
        shape = RoundedCornerShape(MaterialTheme.customsize.verysmall)
    ) {
        NewText(
            title = itemName,
            modifier = Modifier.padding(MaterialTheme.custompadding.xtralarge)
        )
    }
}

data class Pro(
    val name: String,
    val price: Int,
    val descrip: String,
    val image: String = "http://blacky.tech/categoryimg/snacks.png"
)

@Composable
fun ProductCard(
    onclick: () -> Unit,
    pitems: Pro,

    ) {
    Card(
        modifier = Modifier
            .padding(MaterialTheme.custompadding.large)
            .clickable(onClick = onclick),
        elevation = MaterialTheme.customelevation.normal,
        shape = RoundedCornerShape(MaterialTheme.custom_corneradius.medium),
        backgroundColor = MaterialTheme.customcolor.Background500,
        border = BorderStroke(1.dp, color = Color.Black.copy(alpha = 0.6f))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(MaterialTheme.custompadding.medium),
            horizontalArrangement = Arrangement.Center
        ) {
            pitems.image.let {
                CoilImage(
                    imageModel = it,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(MaterialTheme.customsize.xxl)
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
                DefaultButton(
                    title = "Add to Cart",
                    onclick = { /*TODO*/ },
                    modifier = Modifier.padding(5.dp),
                    elevation = 1.dp,
                    cornerradius = 4.dp
                )
            }
        }
    }
}

@Composable
fun ProductMainList() {
    val ctx = LocalContext.current
    val listofpro = listOf<Pro>(
        Pro("product 1",67,"somedescription"),
        Pro("product 2",467,"somedescription"),
        Pro("product 3",657,"somedescription"),
        Pro("product 4",667,"somedescription"),
        Pro("product 5",677,"somedescription"),
    )
    LazyColumn {
        itemsIndexed(listofpro){ _,items ->
            ProductCard(
                onclick = { Toast.makeText(
                    ctx,
                    "Clicked items name =${items.name}",
                    Toast.LENGTH_LONG
                ).show() }, pitems = items
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    CutePepperTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val ctx = LocalContext.current
            val listofpro = listOf<Pro>(
                Pro("product 1",67,"somedescription"),
                Pro("product 2",467,"somedescription"),
                Pro("product 3",657,"somedescription"),
                Pro("product 4",667,"somedescription"),
                Pro("product 5",677,"somedescription"),
            )
            LazyColumn {
                itemsIndexed(listofpro){ _,items ->
                    ProductCard(
                        onclick = { Toast.makeText(
                            ctx,
                            "Clicked items name =${items.name}",
                            Toast.LENGTH_LONG
                        ).show() }, pitems = items
                    )
                }
            }

        }
    }
}