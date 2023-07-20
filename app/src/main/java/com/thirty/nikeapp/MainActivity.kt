package com.thirty.nikeapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.thirty.nikeapp.data.repository.DataStoreRepository
import com.thirty.nikeapp.ui.theme.NikeAppTheme
import com.thirty.nikeapp.presentation.util.OnBoardingPage
import com.thirty.nikeapp.domain.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel
    @Inject
    lateinit var dataStoreRepository : DataStoreRepository
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NikeAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val modifier: Modifier

                val onboardingPage: OnBoardingPage = OnBoardingPage.First

                SetNavGraph(navController = navController ,  onBoardingPage = onboardingPage, dataStoreRepository = dataStoreRepository )
            }
        }
    }
}

