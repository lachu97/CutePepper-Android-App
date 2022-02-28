package com.betelguese.cutepepper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.betelguese.cutepepper.ui.theme.CutePepperTheme
import com.betelguese.cutepepper.utils.sharedviewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewmodel by viewModels<sharedviewmodel>()

        setContent {
            CutePepperTheme {
                val state = viewmodel.newstate.value
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                    if (state.loading){
                        Log.i("MainActivity","Loading ${state.loading}")
                    }
                    state.resultlist.forEach {
                        Log.i("MainActivity","Value = ${it}")
                    }
                    state.error.let {
                        Log.i("mainActivity","Error =${it}")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CutePepperTheme {
        Greeting("Android")
    }
}