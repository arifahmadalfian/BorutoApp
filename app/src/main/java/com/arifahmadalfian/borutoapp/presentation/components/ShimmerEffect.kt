package com.arifahmadalfian.borutoapp.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.arifahmadalfian.borutoapp.ui.theme.*

@Composable
fun ShimmerEffect() {
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(space = SMALL_PADDING)
    ) {
        items(count = 3) {
            AnimateShimmerEffect()
        }
    }
}

@Composable
fun AnimateShimmerEffect() {
    val shimmerColor = listOf(
        if (isSystemInDarkTheme())
            ShimmerDarkGray else ShimmerMediumGray,
        if (isSystemInDarkTheme())
            ShimmerDarkGray.copy(alpha = 0.3f) else ShimmerMediumGray.copy(alpha = 0.3f),
        if (isSystemInDarkTheme())
            ShimmerDarkGray else ShimmerMediumGray,
    )
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
    )
    val brush = Brush.linearGradient(
        colors = shimmerColor,
        start = Offset.Zero,
        end = Offset(x = translateAnim, y = translateAnim)
    )
    ShimmerItem(brush = brush)
}

@Composable
fun ShimmerItem(brush: Brush) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_ITEM_HEIGHT),
        color = if (isSystemInDarkTheme())
            Color.Black else ShimmerLightGray,
        shape = RoundedCornerShape(LARGE_PADDING)
    ) {
        Column(
            modifier = Modifier.padding(all = MEDIUM_PADDING),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(NAME_PLACE_HOLDER_HEIGHT)
                    .clip(shape = RoundedCornerShape(size = SMALL_PADDING))
                    .background(brush = brush)
            )
            Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
            repeat(3) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ABOUT_PLACEHOLDER_HEIGHT)
                        .clip(shape = RoundedCornerShape(size = EXTRA_SMALL_PADDING))
                        .background(brush = brush)
                )
                Spacer(modifier = Modifier.padding(all = EXTRA_SMALL_PADDING))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                repeat(5) {
                    Spacer(
                        modifier = Modifier
                            .size(RATING_PLACEHOLDER_HEIGHT)
                            .clip(shape = RoundedCornerShape(size = EXTRA_SMALL_PADDING))
                            .background(brush = brush)
                    )
                    Spacer(modifier = Modifier.padding(all = EXTRA_SMALL_PADDING))
                }
            }
        }
    }
}

//@Composable
//@Preview
//fun Shimmer() {
//    AnimateShimmerEffect()
//}