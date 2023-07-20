package com.thirty.nikeapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.thirty.nikeapp.data.dummySneakersEight
import com.thirty.nikeapp.data.dummySneakersFive
import com.thirty.nikeapp.data.dummySneakersFour
import com.thirty.nikeapp.data.dummySneakersNine
import com.thirty.nikeapp.data.dummySneakersOne
import com.thirty.nikeapp.data.dummySneakersSeven
import com.thirty.nikeapp.data.dummySneakersSix
import com.thirty.nikeapp.data.dummySneakersThree
import com.thirty.nikeapp.data.dummySneakersTwo
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductScreen(modifier: Modifier = Modifier, navController: NavController) {
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


            LazyColumn(
                modifier = modifier.padding(
                    start = 20.dp, end = 20.dp, bottom = 20.dp,
                    top = 40.dp


                )
            ) {


                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersOne){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }

                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersTwo){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }

                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersThree){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }

                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersFour){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }

                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersFive){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }


                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersSix){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }

                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersSeven){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }

                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersEight){ sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }

                item {


                    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {


                        items(dummySneakersNine){sneakerOne->
                            Card(
                                colors = CardDefaults.cardColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                                modifier = modifier.clickable {


                                }.padding(start = 15.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(sneakerOne.imageUrl),
                                    contentDescription = sneakerOne.name,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(150.dp).clickable {
                                            navController.navigate(Screens.ProductDetailsScreen.route)
                                        }
                                )


                                var isFilled by remember { mutableStateOf(false) }
                                Text(
                                    text = sneakerOne.name,
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )

                                Text(
                                    text = "Price : 4590",
                                    modifier = Modifier.padding(start = 16.dp),
                                    MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = "Add to Cart",
                                    modifier = Modifier.padding(start = 16.dp).clickable {

                                        localCoroutineScope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Added to Cart"
                                            )
                                        }
                                    },
                                    Color.Blue
                                )


                            }
                        }
                    }










                }


            }


        }


    }
}









