package com.betelguese.cutepepper.presentation.views.ui_elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun bottomSheet() {
    var skipHalfExpanded by remember { mutableStateOf(false) }
    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(sheetContent = {
           Text(text = "Sheet 1")
           Text(text = "Sheet 3")
           Text(text = "Sheet 7")
           Text(text = "Sheet 9")
           Text(text = "Sheet 11")
    }, sheetState = state){
        Button(onClick = { scope.launch { state.show() } }) {
            Text(text = "SHow Sheet")
        }
    }
}
@Preview(showBackground = true)
@ExperimentalMaterialApi
@Composable
fun ValuePreview() {
    Surface(
    modifier = Modifier
            .fillMaxSize()) {
        bottomSheet()
    }
}