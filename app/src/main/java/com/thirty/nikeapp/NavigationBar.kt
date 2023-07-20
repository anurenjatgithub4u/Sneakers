package com.thirty.nikeapp

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.thirty.nikeapp.presentation.home_screen_composables.navigation_drawer.AppDrawer
import com.thirty.nikeapp.data.repository.DataStoreRepository
import com.thirty.nikeapp.presentation.screens.AddItemScreen
import com.thirty.nikeapp.presentation.screens.Categories
import com.thirty.nikeapp.presentation.screens.HomeScreens
import com.thirty.nikeapp.presentation.screens.ProductDetails
import com.thirty.nikeapp.presentation.screens.ProductScreen
import com.thirty.nikeapp.presentation.screens.ProductSearchScreen
import com.thirty.nikeapp.presentation.screens.SplashScreenOne
import com.thirty.nikeapp.presentation.screens.WelComeScreen
import com.thirty.nikeapp.presentation.util.OnBoardingPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetNavGraph(
    navController: NavHostController, onBoardingPage: OnBoardingPage,
    dataStoreRepository: DataStoreRepository
) {


    BottomNavigationBar(
        items = listOf(
            BottomNavItem(
                name = "Home",
                route = "Home",
                icon = Icons.Default.Home
            ),
            BottomNavItem(
                name = "Categories",
                route = "Categories",
                icon = Icons.Default.Notifications
            ),
//        BottomNavItem(
//            name = "Discover",
//            route = "discover",
//            icon = Icons.Default.Book
//        )
        ),
        navController = navController,
        modifier = Modifier.padding(10.dp),
        onItemClick = { navController.navigate(it.route) },
        onBoardingPage = onBoardingPage, dataStoreRepository = dataStoreRepository


        )

}


@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

data class ShowAppBar(val show: ActionBar?)

internal val LocalAppBar = compositionLocalOf<ShowAppBar> { error("No ActionBar provided") }

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint(
    "UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState",
    "SuspiciousIndentation", "RememberReturnType"
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(coroutineScope: CoroutineScope = rememberCoroutineScope(),
                        drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
                        dataStoreRepository: DataStoreRepository,
                        onBoardingPage: OnBoardingPage,

                        items: List<BottomNavItem>,
                        navController: NavHostController,
                        modifier: Modifier,
                        onItemClick: (BottomNavItem) -> Unit,

                        ) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val bottomBarState = rememberSaveable { (mutableStateOf(false)) }

    val topBarState = rememberSaveable { (mutableStateOf(false)) }
    // var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: Screens.ProductScreen.route
    val navigationActions = remember(navController) {

    }

    val snackbarHostState = remember { SnackbarHostState() }
    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { },
            navigateToSettings = {  },
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = Modifier,
            navController = navController
        )
    }, drawerState = drawerState) {


        Scaffold( topBar = {

            if (currentRoute(navController) != Screens.WelComeScreen.route && currentRoute(
                    navController
                ) != Screens.SplashScreen.route
            ) {
                AnimatedVisibility(visible = topBarState.value) {

                    TopAppBar(title = { Text(text = currentRoute) }, actions = {
                        IconButton(onClick = {
                           navController.navigate(Screens.ProductSearchScreen.route)
                        }, content = {
                            Icon(
                                imageVector = Icons.Default.Search, contentDescription = null
                            )
                        })
                    },
                        modifier = Modifier.fillMaxWidth(),
                        navigationIcon = { IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }, content = {
                            Icon(
                                imageVector = Icons.Default.Menu, contentDescription = null
                            )
                        })
                        })


                }


                }
            } ,snackbarHost = {
            SnackbarHost(snackbarHostState, modifier = Modifier.padding(bottom = 170.dp))
        }
            ,

            bottomBar = {


            if (currentRoute(navController) != Screens.WelComeScreen.route && currentRoute(
                    navController
                ) != Screens.SplashScreen.route
            ) {
                AnimatedVisibility(visible = bottomBarState.value) {
                    BottomAppBar(
                        modifier = modifier
                            .height(75.dp)
                            .padding(5.dp)
                            .clip(shape = RoundedCornerShape(60.dp)),
                        containerColor = MaterialTheme.colorScheme.onSecondary,
                        tonalElevation = 5.dp
                    ) {
                        items.forEach { items ->

                            val selected = items.route == backStackEntry.value?.destination?.route
                            NavigationBarItem(
                                selected = items.route == navController.currentDestination?.route,
                                onClick = { onItemClick(items) },
                                icon = {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        if (items.badgeCount > 0) {

                                            BadgedBox(badge = {
                                                Text(text = items.badgeCount.toString())


                                            }) {
                                                Icon(
                                                    imageVector = items.icon,
                                                    contentDescription = items.name
                                                )
                                            }
                                        } else {
                                            Icon(
                                                imageVector = items.icon,
                                                contentDescription = items.name
                                            )
                                        }

                                        if (selected) {

                                            Text(
                                                text = items.name,
                                                textAlign = TextAlign.Center,
                                                fontSize = 10.sp
                                            )
                                        }
                                    }

                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color.Blue,
                                    unselectedIconColor = MaterialTheme.colorScheme.tertiary,
                                    selectedTextColor = Color.Blue,
                                    indicatorColor = MaterialTheme.colorScheme.onSecondary
                                )
                            )
                        }

                    }
                }
            } else {

            }

        }) {

            NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {

                composable(Screens.SplashScreen.route) {
                    SplashScreenOne(
                        navController = navController,
                        dataStoreRepository = dataStoreRepository
                    )

                    LaunchedEffect(Unit) {
                        bottomBarState.value = true
                    }
                }

                composable(Screens.WelComeScreen.route) {
                    WelComeScreen(onBoardingPage = onBoardingPage, navController = navController)


                }

                composable(Screens.HomeScreen.route) {
                    HomeScreens(navController = navController)

                    LaunchedEffect(Unit) {
                        bottomBarState.value = true
                        topBarState.value = true
                    }
                }

                composable(Screens.Categories.route) {
                    Categories(navController = navController, dataRepository = dataStoreRepository)

                    LaunchedEffect(Unit) {
                        bottomBarState.value = true
                        topBarState.value = true
                    }
                }
                composable(Screens.ProductScreen.route) {
                    ProductScreen(navController = navController)

                    LaunchedEffect(Unit) {
                        bottomBarState.value = false

                    }
                }
                composable(Screens.ProductDetailsScreen.route) {
                    ProductDetails(navController = navController)

                    LaunchedEffect(Unit) {
                        bottomBarState.value = false
                    }
                }
                composable(Screens.AddItem.route) {
                    AddItemScreen(navController = navController)

                    LaunchedEffect(Unit) {
                        bottomBarState.value = false
                    }
                }



                composable(Screens.ProductSearchScreen.route) {
                    ProductSearchScreen()

                    LaunchedEffect(Unit) {
                        bottomBarState.value = false
                    }
                }

            }
        }
    }
}

