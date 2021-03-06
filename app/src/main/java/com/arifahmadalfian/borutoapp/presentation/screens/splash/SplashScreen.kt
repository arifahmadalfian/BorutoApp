package com.arifahmadalfian.borutoapp.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.arifahmadalfian.borutoapp.R
import com.arifahmadalfian.borutoapp.navigation.Screen
import com.arifahmadalfian.borutoapp.ui.theme.Black000
import com.arifahmadalfian.borutoapp.ui.theme.Purple500
import com.arifahmadalfian.borutoapp.ui.theme.Purple700

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()

    val degrees = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(Screen.Home.route)
        } else {
            navController.navigate(Screen.Welcome.route)
        }
    }

    if (isSystemInDarkTheme()) {
        Splash(
            brush = Brush.verticalGradient(listOf(Black000, Black000)),
            degrees = degrees.value
        )
    } else {
        Splash(
            brush = Brush.verticalGradient(listOf(Purple700, Purple500)),
            degrees = degrees.value
        )
    }
}

@Composable
fun Splash(brush: Brush, degrees: Float) {
    Box(
        modifier = Modifier
            .background(brush)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.rotate(degrees = degrees),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_logo)
        )
    }
}

//@Preview
//@Composable
//fun PreviewScreenLight() {
//    Splash(color = Brush.verticalGradient(listOf(Purple700, Purple500)))
//}
//
//@Composable
//@Preview(uiMode = UI_MODE_NIGHT_YES)
//fun PreviewScreenNight() {
//    Splash(color = Brush.verticalGradient(listOf(Black000)))
//}