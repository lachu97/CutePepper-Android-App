package com.betelguese.cutepepper.presentation.views.ui_elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun normalButton(
    title: String,
    onclick: () -> Unit,
    modifier: Modifier = Modifier.padding(MaterialTheme.custompadding.xtralarge)
) {
    Button(
        onClick = onclick,
        modifier = modifier
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(MaterialTheme.custompadding.small)
        )
    }

}