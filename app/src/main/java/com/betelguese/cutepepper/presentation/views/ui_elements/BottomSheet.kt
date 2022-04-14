package com.betelguese.cutepepper.presentation.views.ui_elements

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.betelguese.cutepepper.R
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun bottomSheet() {
    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetContent = {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(MaterialTheme.custompadding.medium),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = {
                        Text(text = "Type your Info")
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = null
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Send
                    ),
                    keyboardActions = KeyboardActions(
                        onSend = {
                            Log.i("imeAction","Value of Text=${text.text}")
                        }
                    )
                )
            }

        },
        sheetState = state,
        sheetBackgroundColor = MaterialTheme.customcolor.ScreenBackground700.copy(
            alpha = 0.4f
        ),

        ) {
        Button(onClick = { scope.launch { state.show() } }) {
            Text(text = "SHow Sheet")
        }
//        if (text.text.isNotBlank()) {
//            val values = text.copy()
//            Log.i("Modal sheet", "Value of Text=${values.text}")
//        }

    }
}

@Preview(showBackground = true)
@ExperimentalMaterialApi
@Composable
fun ValuePreview() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        bottomSheet()
    }
}