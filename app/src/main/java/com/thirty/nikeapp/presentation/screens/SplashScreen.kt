package com.thirty.nikeapp.presentation.screens

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.thirty.nikeapp.R
import com.thirty.nikeapp.Screens
import com.thirty.nikeapp.presentation.home_screen_composables.animations.DotsCollision
import com.thirty.nikeapp.data.repository.DataStoreRepository
import kotlinx.coroutines.delay


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreenOne(navController: NavController, dataStoreRepository: DataStoreRepository) {


    val scale = remember {
        Animatable(0f)
    }

    val overShootInterpolator = remember {
        OvershootInterpolator(2f)
    }


    val context = LocalContext.current


    val systemUiController: SystemUiController = rememberSystemUiController()

    val background = MaterialTheme.colorScheme.surface

    //systemUiController.isNavigationBarVisible = false // Navigation bar

    SideEffect {
        with(systemUiController) {
            setSystemBarsColor(
                color = background

            )
        }
    }



    LaunchedEffect(key1 = true) {


        scale.animateTo(
            targetValue = 0.5f, animationSpec = tween(durationMillis = 500, easing = {
                // systemUiController.isNavigationBarVisible = false
                //systemUiController.isSystemBarsVisible = false // Status & Navigation bars
                overShootInterpolator.getInterpolation(it)
            })
        )

        delay(2000L)
        navController.popBackStack()
        dataStoreRepository.readOnBoardingState().collect { completed ->
            if (completed) {
                navController.navigate(Screens.HomeScreen.route)
            } else {
                navController.navigate(Screens.WelComeScreen.route)
            }
        }
    }




    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        var isVisible by remember { mutableStateOf(true) }

        val slideOffset by animateDpAsState(
            if (isVisible) 0.dp else 200.dp,
            tween(durationMillis = 500)
        )

        val alpha by animateFloatAsState(
            if (isVisible) 1f else 0f,
            tween(durationMillis = 500)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(x = slideOffset), contentAlignment = Alignment.Center
        ) {

            Column {
                Image(
                    painter = painterResource(id = R.drawable.nijethree),
                    contentDescription = "",
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                )
                
                Spacer(modifier = Modifier.height(10.dp))

               DotsCollision()

            }

        }
//        LaunchedEffect(key1 = true) {
//            isVisible = !isVisible
//        }


    }
}







