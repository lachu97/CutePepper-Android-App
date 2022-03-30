package com.betelguese.cutepepper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.betelguese.cutepepper.presentation.viewmodels.randomviewmodel
import com.betelguese.cutepepper.ui.theme.CutePepperTheme
import com.betelguese.cutepepper.utils.ConnectionLiveData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val hasinternet : ConnectionLiveData = ConnectionLiveData(this)
        hasinternet.observe(this,){
            Log.i("MainActivity","Internet Connection =${it}")
        }
        setContent {
            CutePepperTheme {
                val random : randomviewmodel = hiltViewModel()
//                val viewmodel:sharedviewmodel= hiltViewModel()
                val state = random.newstate.value
                val catstate = random.categorynewstate.value
                // A surface container using the 'background' Mycolors from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                    state.let {
                        if (it.loading){
                            Log.i("MainActivity","Loading ${it.loading}")
                        }
                        it.resultlist.forEach {
                            Log.i("MainActivity","Value = ${it}")
                        }
                        it.error.let {
                            Log.i("mainActivity","Error =${it}")
                        }
                    }
                    catstate.let {
                        if (it.loading){
                            Log.i("MainActivity","Loading category ${it.loading}")

                        }
                        it.resultlist.forEach {
                            Log.i("MainActivity","Value = ${it}")
                        }
                        it.error.let {
                            Log.i("mainActivity","Error =${it}")
                        }
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