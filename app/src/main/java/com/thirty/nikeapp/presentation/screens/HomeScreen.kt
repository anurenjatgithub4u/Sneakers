package com.thirty.nikeapp.presentation.screens

import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.app.Activity
import android.widget.GridLayout.FILL
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.thirty.nikeapp.R
import com.thirty.nikeapp.Screens
import com.thirty.nikeapp.presentation.home_screen_composables.ExpandableCard
import com.thirty.nikeapp.presentation.home_screen_composables.ThisWeekHighLight
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreens(
    navController: NavController, modifier: Modifier = Modifier, painter: Painter = painterResource(
        id = R.drawable.ic_launcher_background
    ), drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val systemUiController: SystemUiController = rememberSystemUiController()
    val activity = (LocalContext.current as? Activity)
    val background = MaterialTheme.colorScheme.surface

    BackHandler(true) {
        activity?.finish()
    }

    SideEffect {
        with(systemUiController) {
            setSystemBarsColor(
                color = background

            )
        }
    }




        Scaffold(

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
            ) {

            LazyColumn(Modifier.padding(bottom = 90.dp)) {


                item {

                    Text(
                        text = "Best Sneakers",
                        modifier = modifier.padding(top = 100.dp, start = 20.dp),
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )

                    val pagerState = rememberPagerState(initialPage = 1)
                    val sliderList = listOf(
                        R.drawable.nikefive,
                        R.drawable.nikefour,
                        R.drawable.nijethree,
                        R.drawable.nikesix,
                        R.drawable.nikeseven,
                        R.drawable.niketen,
                        R.drawable.nikeeleven,
                        R.drawable.niketwelve,
                        R.drawable.nikethirteen,
                        R.drawable.nikefourteen,

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalPager(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            ,
                        count = sliderList.size, state = pagerState,
                        contentPadding = PaddingValues(horizontal = 150.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) { page ->
                        Card(
                            colors = CardDefaults.cardColors(Color.Transparent),
                            shape = RoundedCornerShape(10.dp),
                            elevation = CardDefaults.cardElevation(0.dp),
                            modifier = Modifier
                                .graphicsLayer {

                                    val pageOffset =
                                        calculateCurrentOffsetForPage(page).absoluteValue

                                    androidx.compose.ui.util.lerp(
                                        start = .45f,
                                        stop = 2.3f,
                                        fraction = .95f - pageOffset.coerceIn(0.35f, 1f)
                                    ).also { scale ->
                                        scaleX = scale
                                        scaleY = scale
                                    }
                                    alpha = androidx.compose.ui.util.lerp(
                                        start = 0.8f,
                                        stop = 1.6f,
                                        fraction = 1f - pageOffset.coerceIn(0.3f, 1.2f)
                                    )
                                }
                            // .aspectRatio(0.5f)
                        ) {
                            Image(
                                painter = painterResource(id = sliderList[page]),
                                contentDescription = null,
                                modifier = Modifier
                                    .offset {
                                        // Calculate the offset for the current page from the
                                        // scroll position
                                        val pageOffset =
                                            this@HorizontalPager.calculateCurrentOffsetForPage(page)
                                        // Then use it as a multiplier to apply an offset
                                        IntOffset(
                                            x = (70.dp * pageOffset).roundToPx(),
                                            y = 0,
                                        )
                                    }
                                    .clickable {
                                        navController.navigate(Screens.ProductScreen.route)
                                    }
                            )
                        }

                    }

                }

                item {

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "This Weeks HighLight", modifier = Modifier.padding(start = 20.dp),
                        fontSize = 20.sp,color = MaterialTheme.colorScheme.tertiary

                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    ThisWeekHighLight(modifier = modifier.clickable {
                        navController.navigate(Screens.ProductScreen.route)
                    })



                    Spacer(modifier = Modifier.height(40.dp))

                    ExpandableCard(painter = painterResource(id = R.drawable.expandfour), textOne = "New Release", textTwo = "Best Seller", textThree = "Member Shop", textFour = "Air Max")
                    ExpandableCard(painter = painterResource(id = R.drawable.expandthree), textOne = "Air Force", textTwo = "FootBall", textThree = "Cricket", textFour = "Air Max")
                    ExpandableCard(painter = painterResource(id = R.drawable.expandtwo), textOne = "Air Force", textTwo = "FootBall", textThree = "Cricket", textFour = "Air Max")
                    ExpandableCard(painter = painterResource(id = R.drawable.expandone), textOne = "Air Force", textTwo = "FootBall", textThree = "Cricket", textFour = "Air Max")


                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "New Collections",
                        modifier = modifier.padding(start = 20.dp)

                        , color = MaterialTheme.colorScheme.tertiary,fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ThisWeekHighLight(modifier = modifier.clickable {
                        navController.navigate(Screens.ProductScreen.route)
                    })
                }

                item {

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "Shop by collections",
                        modifier = modifier.padding(start = 20.dp)

                        , color = MaterialTheme.colorScheme.tertiary,fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ThisWeekHighLight(modifier = modifier.clickable {
                        navController.navigate(Screens.ProductScreen.route)
                    })
                }

                item {
                    Spacer(modifier = Modifier.height(40.dp))



                        OutlinedButton(
                            onClick = {
                                      navController.navigate(Screens.ProductScreen.route)
                            },
                            modifier = modifier
                                .align(Center)
                                .padding(start = 150.dp)
                        ) {
                            Text(text = "View All", color = MaterialTheme.colorScheme.tertiary)
                        }



                }

                item {

                    Spacer(modifier = modifier.height(40.dp))

                    Text(
                        text = "Popular Searches",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 20.dp)
                        , color = MaterialTheme.colorScheme.tertiary
                    )

                    Spacer(modifier = modifier.height(20.dp))

                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                         Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Dunk",
                            fontSize = 15.sp,
                             color = MaterialTheme.colorScheme.tertiary

                        )
                    }

                    Spacer(modifier = modifier.height(20.dp))

                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Air Max",
                            fontSize = 15.sp,
                             color = MaterialTheme.colorScheme.tertiary

                            )
                    }


                    Spacer(modifier = modifier.height(20.dp))

                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Air Jordan",
                            fontSize = 15.sp,
                             color = MaterialTheme.colorScheme.tertiary

                            )
                    }

                    Spacer(modifier = modifier.height(20.dp))

                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Air",
                            fontSize = 15.sp
                            , color = MaterialTheme.colorScheme.tertiary

                            )
                    }


                    Spacer(modifier = modifier.height(20.dp))

                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Casual",
                            fontSize = 15.sp
                            , color = MaterialTheme.colorScheme.tertiary

                            )
                    }



                }

            }
        }


    }
}