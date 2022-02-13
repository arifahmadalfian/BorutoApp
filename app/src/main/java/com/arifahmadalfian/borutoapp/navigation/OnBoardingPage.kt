package com.arifahmadalfian.borutoapp.navigation

import androidx.annotation.DrawableRes
import com.arifahmadalfian.borutoapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greeting",
        description = "Are you Boruto fan? Because if your are them we have a great news for you!"
    )
    object Second: OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = "Find your favorite heroes and learn some of the things that you didn't know about."
    )
    object Third: OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Check our your hero's power and see how much are they strong comparing to others."
    )
}
