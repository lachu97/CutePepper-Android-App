package com.betelguese.cutepepper.presentation.views.ui_elements

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.betelguese.cutepepper.R

@Composable
fun topBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.customcolor.ScreenBackground700
    ) {
        val ctx= LocalContext.current
        IconButton(
            onClick = {
                Toast.makeText(ctx,"Drawer",Toast.LENGTH_LONG).show()
            },
            
            modifier = Modifier
                    .size(64.dp)
        ){
            Icon(painter = painterResource(id = R.drawable.ic_dehaze)
                , contentDescription = null,
            
            modifier = Modifier
                    .size(42.dp),
            tint = MaterialTheme.customcolor.Background700)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopbar() {
    topBar()
}