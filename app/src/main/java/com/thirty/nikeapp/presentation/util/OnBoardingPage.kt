package com.thirty.nikeapp.presentation.util

import androidx.annotation.DrawableRes
import com.thirty.nikeapp.R


sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.detailsimageones,
        title = "Welcome",
        description = "Step into a World of Stylish Sneakers"
    )

    object Second : OnBoardingPage(
        image = R.drawable.detailsimagetwoos,
        title = "Explore a World of Possibilities",
        description = "Our user-friendly interface allows you to browse, filter, and compare shoes effortlessly. Save your favorite styles, check real-time availability, and enjoy secure and convenient payment options. "
    )

    object Third : OnBoardingPage(
        image = R.drawable.detailsimagethrees,
        title = "Seamless Shopping Experience",
        description = "Upgrade Your Shoe Game Hassle-Free"
    )
}