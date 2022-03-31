package com.betelguese.cutepepper.presentation.views.ui_elements


import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
    bgcolor: Color = MaterialTheme.customcolor.Teal500,
    textcolor: Color = MaterialTheme.customcolor.Text700,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 17.sp,
    fontFamily: FontFamily = FontFamily.SansSerif
) {
    Button(
        onClick = onclick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = bgcolor),
        border = BorderStroke(1.dp, color = MaterialTheme.customcolor.Border700),
        elevation = ButtonDefaults.elevation(defaultElevation = MaterialTheme.customelevation.high)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(MaterialTheme.custompadding.medium),
            color = textcolor,
            fontWeight = fontWeight,
            fontSize = fontSize,
            fontStyle = FontStyle.Normal,
            fontFamily = fontFamily
        )
    }

}

@Composable
fun DefaultIconButton(
    title: String,
    onclick: () -> Unit,
    icon: Int,
    modifier: Modifier = Modifier.padding(MaterialTheme.custompadding.xtralarge),
    bgcolor: Color = MaterialTheme.customcolor.Background700,
    textcolor: Color = MaterialTheme.customcolor.Teal700,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 17.sp,
    fontFamily: FontFamily = FontFamily.SansSerif
) {
    Button(onClick = onclick) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,

            )
        Spacer(modifier = Modifier.padding(MaterialTheme.custompadding.medium))
        Text(
            text = title,
            modifier = Modifier
                .padding(MaterialTheme.custompadding.medium),
            color = textcolor,
            fontWeight = fontWeight,
            fontSize = fontSize,
            fontStyle = FontStyle.Normal,
            fontFamily = fontFamily
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CutePepperTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DefaultButton(title = "Mytitle", onclick = { })
            DefaultIconButton(title = "Extra Title", onclick = { /*TODO*/ },
                icon = R.drawable.ic_dehaze)
        }
    }
}
