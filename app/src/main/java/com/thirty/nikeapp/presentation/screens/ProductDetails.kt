package com.thirty.nikeapp.presentation.screens

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.ButtonColors
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.thirty.nikeapp.R
import com.thirty.nikeapp.Screens
import com.thirty.nikeapp.presentation.util.OnBoardingPage

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetails(modifier: Modifier = Modifier, navController: NavController) {

    val pagerState = rememberPagerState(initialPage = 1)
    val sliderList = listOf(
        R.drawable.nikefive,
        R.drawable.nikefour,
        R.drawable.nijethree,
        R.drawable.nikesix,
        R.drawable.greenshoe
    )
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                Icon(modifier = Modifier.clickable {
                     navController.navigate(Screens.ProductScreen.route)
                },
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back"
                )


            },
            title = { Text(text = "Details") },
            backgroundColor = MaterialTheme.colorScheme.primary
        )
    }) {

        val pages = listOf(
            OnBoardingPage.First,
            OnBoardingPage.Second,
            OnBoardingPage.Third
        )
        val activity = (LocalContext.current as? Activity)
        val pagerState = rememberPagerState()



        LazyColumn() {
            item {
                Column(modifier = Modifier.height(400.dp)) {
                    HorizontalPager(
                        modifier = Modifier.weight(10f),
                        count = 3,
                        state = pagerState,
                        verticalAlignment = Alignment.Top
                    ) { position ->
                        ProductPagerScreen(onBoardingPage = pages[position])
                    }
                    HorizontalPagerIndicator(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .weight(1f),
                        pagerState = pagerState
                    )

                }
            }
            item {

                Column(modifier = modifier.padding(start = 20.dp, top = 40.dp)) {
                    Text(
                        text = "Men's Shoes", color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Nike Air Force 1'07", color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "MRP : $100", color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "The Radiance lives on in the Nike Air Force 1'07," +
                                "the basketball original that plus afresh" +
                                "a fresh spin on what you know best" +
                                "a fresh spin on what you know best"+
                                "The Radiance lives on in the Nike Air Force 1'07," +
                                "the basketball original that plus afresh" +
                                "a fresh spin on what you know best" +
                                "a fresh spin on what you know best"+
                                "The Radiance lives on in the Nike Air Force 1'07," +
                                "the basketball original that plus afresh" +
                                "a fresh spin on what you know best" +
                                "a fresh spin on what you know best"
                        ,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = ". Shown: White/White", color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = ". Shown: White/White", color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                   Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)) {
                        Text(text = "Select Size", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)


                    ) {
                        Text(text = "Add To Bag",color = Color.White)
                    }

                }


            }
        }

    }
}


@Composable
fun ProductPagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.9f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )

    }
}