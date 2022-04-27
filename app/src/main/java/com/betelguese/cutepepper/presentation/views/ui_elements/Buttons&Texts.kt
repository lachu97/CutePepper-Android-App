package com.betelguese.cutepepper.presentation.views.ui_elements


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.betelguese.cutepepper.R
import com.betelguese.cutepepper.ui.theme.CutePepperTheme


@Composable
fun DefaultButton(
    title: String,
    onclick: () -> Unit,
    modifier: Modifier = Modifier.padding(MaterialTheme.custompadding.xtralarge),
    bgcolor: Color = MaterialTheme.customcolor.Background700,
    elevation: Dp = MaterialTheme.customelevation.default,
    cornerradius : Dp = MaterialTheme.custom_corneradius.default
) {
    Button(
        onClick = onclick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = bgcolor),
        border = BorderStroke(1.dp, color = MaterialTheme.customcolor.Border700),
        elevation = ButtonDefaults.elevation(defaultElevation = elevation),
        shape = RoundedCornerShape(cornerradius)
    ) {
       NewText(title = title, fontSize = 12.sp)
    }

}


@Composable
fun DefaultIconButton(
    title: String,
    onclick: () -> Unit,
    icon: Int,
    iconsize: Dp = 24.dp,
    modifier: Modifier = Modifier.padding(MaterialTheme.custompadding.xtralarge),
    bgcolor: Color = MaterialTheme.customcolor.Background700,
) {
    Button(onClick = onclick,
        colors = ButtonDefaults.buttonColors(backgroundColor = bgcolor),
        modifier = modifier,
        border = BorderStroke(1.dp, color = MaterialTheme.customcolor.Border700),
        elevation = ButtonDefaults.elevation(defaultElevation = MaterialTheme.customelevation.high)
        ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,

            modifier = Modifier
                    .size(iconsize)
            )
        NewText(title = title, fontSize = 14.sp)
    }
}

@Composable
fun Paragraph(
    title: String,
    modifier: Modifier = Modifier.padding(MaterialTheme.custompadding.medium),
    textcolor: Color = MaterialTheme.customcolor.Text700,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 20.sp,
    fontFamily: FontFamily = FontFamily.SansSerif,
    maxlines : Int = 5
) {
    Text(
        text = title,
        modifier = modifier,
        color = textcolor,
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontStyle = FontStyle.Italic,
        fontFamily = fontFamily,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxlines

    )
}
@Composable
fun NewText(
    title: String,
    modifier: Modifier = Modifier.padding(MaterialTheme.custompadding.medium),
    textcolor: Color = MaterialTheme.customcolor.Text700,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 17.sp,
    fontFamily: FontFamily = FontFamily.SansSerif

) {
    Text(
        text = title,
        modifier = modifier,
        color = textcolor,
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontStyle = FontStyle.Normal,
        fontFamily = fontFamily,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1

    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val myitems = listOf<String>(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
    )
    CutePepperTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DefaultButton(title = "Mytitle", onclick = { })
            DefaultIconButton(title = "Extra Title", onclick = { /*TODO*/ },
                icon = R.drawable.ic_dehaze)
            CategoryList(listItems = myitems)
        }
    }
}
