package com.thirty.nikeapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.thirty.nikeapp.Screens
import com.thirty.nikeapp.data.dummySneakers
import com.thirty.nikeapp.data.dummySneakersTwo
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductScreen(modifier: Modifier=Modifier,navController: NavController) {
    val snackbarHostState = remember { SnackbarHostState() }

    val localCoroutineScope = rememberCoroutineScope()
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back"
                )
            },
            title = { androidx.compose.material.Text(text = "Shop") },
            backgroundColor = MaterialTheme.colorScheme.primary
        )
    }, snackbarHost = {
        SnackbarHost(snackbarHostState)
    }

    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {

            Row() {

                LazyColumn(
                    modifier = modifier.padding(
                        start = 20.dp, end = 20.dp, bottom = 20.dp,
                        top = 40.dp


                    )
                ) {


                    items(dummySneakers) { sneaker ->


                        Card(
                            colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                            modifier = modifier.clickable {
                                navController.navigate(Screens.ProductDetailsScreen.route)

                            }) {
                            Image(
                                painter = rememberAsyncImagePainter(sneaker.imageUrl),
                                contentDescription = sneaker.name,
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(150.dp)
                            )


                            Row() {
                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneaker.name,
                                    modifier = Modifier.padding(16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                IconButton(onClick = {

                                    localCoroutineScope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "Added to Favourites"
                                        )
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Toggleable Icon",

                                    )
                                }
                            }

                        }


                    }







                }

                Spacer(modifier = Modifier.width(10.dp))

                LazyColumn(
                    modifier = modifier.padding(
                        start = 20.dp, end = 20.dp, bottom = 20.dp,
                        top = 40.dp


                    )
                ) {


                    items(dummySneakersTwo){sneakersTwo->

                        Card(modifier = modifier.clickable {
                            navController.navigate(Screens.ProductDetailsScreen.route)

                        },colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary)) {
                            Image(
                                painter = rememberAsyncImagePainter(sneakersTwo.imageUrl),
                                contentDescription = sneakersTwo.name,
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(150.dp)
                            )


                            Row() {
                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakersTwo.name,
                                    modifier = Modifier.padding(16.dp),
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                                IconButton(onClick = {   localCoroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Added to Favourites"
                                    )
                                }}) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Toggleable Icon",

                                    )
                                }
                            }

                        }
                    }







                }
            }



        }
    }

}







