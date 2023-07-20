package com.thirty.nikeapp

sealed class Screens(val route: String) {

    object AddItem : Screens("add_item_screen")

    object SplashScreen : Screens("splash_screen")

    object WelComeScreen : Screens("welcome_screen")

    object HomeScreen : Screens("Home")

    object Categories : Screens("Categories")

    object ProductScreen : Screens("Product")

    object ProductDetailsScreen : Screens("Details")

    object  ProductSearchScreen : Screens("Search")

}