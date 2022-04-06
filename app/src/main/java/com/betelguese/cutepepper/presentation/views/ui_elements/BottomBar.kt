package com.betelguese.cutepepper.presentation.views.ui_elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.betelguese.cutepepper.presentation.views.ui_views.BottomNavigationScreens

@Composable
fun bottomBar(
    navController: NavController
) {
    val bottomItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Profile,
        BottomNavigationScreens.Cart,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        contentColor = MaterialTheme.customcolor.Teal700,
        backgroundColor = MaterialTheme.customcolor.ScreenBackground700
    ) {
        bottomItems.forEach {
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { newit ->
                    newit.route == it.route
                } == true,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }, unselectedContentColor = MaterialTheme.customcolor.Teal500.copy(
                    alpha = 0.4f
                ),
                icon = {
                    Icon(painter = painterResource(id = it.icon), contentDescription = null)
                },
                label = {},


                )
        }
    }
}

@Composable
fun Home() {
    Text(text = "HomeScreen")
}

@Composable
fun Profile() {
    Text(text = "ProfileScreen")

}

@Composable
fun Cart() {
    Text(text = "CartScreen")

}

@Composable
fun NavHostgraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationScreens.Home.route) {
        composable(route =BottomNavigationScreens.Home.route) {
            Home()
        }

        composable(route =BottomNavigationScreens.Profile.route) {
            Profile()
        }

        composable(route =BottomNavigationScreens.Cart.route) {
            Cart()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SomePreview() {
    val navcontroll = rememberNavController()

    Scaffold(
        bottomBar = { bottomBar(navController = navcontroll) }
    ) {
        NavHostgraph(navController = navcontroll)
    }
}