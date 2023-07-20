package com.thirty.nikeapp.presentation.screens

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thirty.nikeapp.R
import com.thirty.nikeapp.Screens
import com.thirty.nikeapp.data.repository.DataStoreRepository
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(
    navController: NavController,


    dataRepository: DataStoreRepository,
    outlineColor: Color = Color.Black,
    outlineStrokeWidth: Dp = 2.dp,
    imageSize: Dp = 120.dp,
    contentPadding: Dp = 8.dp,
    onClick: () -> Unit = {}
) {
    val infiniteTransition = rememberInfiniteTransition()
    val heartSize by infiniteTransition.animateFloat(
        initialValue = 40.0f,
        targetValue = 90.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, delayMillis = 100,easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    BackHandler(true) {
        navController.navigate(Screens.HomeScreen.route)
    }

    Scaffold(topBar = {

    },

        ) {

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {


        Column() {
            val degrees = 30f // The rotation angle in degrees

            Image(
                painter = painterResource(id = R.drawable.nikeseven), // Replace with your image resource
                contentDescription = null,
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)


                    .graphicsLayer(rotationZ = degrees)
            )

            Card(
                modifier = Modifier
                    .height(500.dp)
                    .width(500.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Nike AIR MAX PRE-DAY",
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.padding(start = 20.dp)) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "")

                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "5.0 (1120 reviews)",
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Take the classic look of heritage Nike",

                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "running in to a new realm ,",

                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(40.dp))
               val scope = rememberCoroutineScope()
                Row() {

                    Button(modifier = Modifier.padding(start = 20.dp),
                        onClick = {
                            navController.navigate(Screens.AddItem.route)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                    ) {
                        Text(text = "Add to Cart")
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    Image(
                        painter = painterResource(R.drawable.heartpng),

                        contentDescription = "heart",
                        modifier = Modifier
                            .size(heartSize.dp)
                    )
                }
               

            }
        }

    }
}