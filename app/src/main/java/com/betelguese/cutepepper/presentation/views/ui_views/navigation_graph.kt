package com.betelguese.cutepepper.presentation.views.ui_views

sealed class Screen(val route: String) {
    object HomeScreen : Screen(route = "home")
    object SplashScreen : Screen(route = "splash")
    object LoginScreen : Screen(route = "login")
    object SignUpScreen : Screen(route = "signup")
    object DetailScreen : Screen(route = "detail")
    object CartScreen : Screen(route = "cart")
    object SearchScreen : Screen(route = "search")
    object SuccessScreen : Screen(route = "success")
    object FailureScreen : Screen(route = "failure")
    object ProfileScreen : Screen(route = "profile")
    object MyOrdersScreen : Screen(route = "myorders")
}