package com.betelguese.cutepepper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.betelguese.cutepepper.presentation.viewmodels.randomviewmodel
import com.betelguese.cutepepper.presentation.views.ui_elements.*
import com.betelguese.cutepepper.ui.theme.CutePepperTheme
import com.betelguese.cutepepper.utils.ConnectionLiveData
import com.betelguese.cutepepper.utils.getWindowInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mycinemodel by viewModels<randomviewmodel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val hasinternet = ConnectionLiveData(this)
        hasinternet.observe(this) {
            Log.i("MainActivity", "Internet Connection =${it}")
        }
        val myitems = listOf<String>(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
        )
        setContent {
            CutePepperTheme {
                val navControl = rememberNavController()
                val randomviewmodel: randomviewmodel = hiltViewModel()
//                val viewmodel:sharedviewmodel= hiltViewModel()
                val state = randomviewmodel.newstate.value
                val widowInfo = getWindowInfo()
                val catstate = randomviewmodel.categorynewstate.value
                // A surface container using the 'background' Mycolors from the theme
                Scaffold(backgroundColor = MaterialTheme.customcolor.ScreenBackground700,
                bottomBar = { bottomBar(navController = navControl)}
                    ) { innerpadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerpadding), horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
//                        Greeting("Android")
//                        CategoryList(listItems = myitems)
//                        ProductCard(onclick = { /*TODO*/ }, pitems = Pro(
//                            name = "Pnames",
//                            price = 89,
//                            descrip = "LoemIpsum..."
//                        )
//                        )
                        NavHostgraph(navController = navControl)
                    }

                    Log.i("Screen","WindowINfos = ${widowInfo.screenHeightInfo}," +
                            "ScreenHeight =${widowInfo.screenHeight}" +
                            "ScreenWidth=${widowInfo.screenWidth}")
                    state.let {
                        if (it.loading) {
                            Log.i("MainActivity", "Loading ${it.loading}")
                        }
                        it.resultlist.forEach {
                            Log.i("MainActivity", "Value = ${it}")
                        }
                        it.error.let {
                            Log.i("mainActivity", "Error =${it}")
                        }
                    }
                    catstate.let {
                        if (it.loading) {
                            Log.i("MainActivity", "Loading category ${it.loading}")

                        }
                        it.resultlist.forEach {
                            Log.i("MainActivity", "Value = ${it}")
                        }
                        it.error.let {
                            Log.i("mainActivity", "Error =${it}")
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