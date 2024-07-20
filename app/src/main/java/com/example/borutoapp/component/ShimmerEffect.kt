package com.example.borutoapp.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.borutoapp.ui.theme.EXTRA_SMALL_PADDING
import com.example.borutoapp.ui.theme.LARGE_PADDING
import com.example.borutoapp.ui.theme.MEDIUM_PADDING
import com.example.borutoapp.ui.theme.SMALL_PADDING
import com.example.borutoapp.ui.theme.ShimmerDarkGray
import com.example.borutoapp.ui.theme.ShimmerLightGray
import com.example.borutoapp.ui.theme.ShimmerMediumGray

@Composable
fun ShimmerEffect() {
    LazyColumn(
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(2) {
            AnimatedShimmerItem()
        }
    }
}

@Composable
fun AnimatedShimmerItem() {
    val transition = rememberInfiniteTransition(label = "FloatAnimation")
    val alphaAnime by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "FloatAnimation"
    )
    ShimmerItem(alphaAnime = alphaAnime)
}

@Composable
fun ShimmerItem(alphaAnime: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        color = if (isSystemInDarkTheme()) Color.Black else ShimmerLightGray,
        shape = RoundedCornerShape(LARGE_PADDING)
    ) {
        Column(
            modifier = Modifier
                .padding(all = MEDIUM_PADDING),
            verticalArrangement = Arrangement.Bottom
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .alpha(alphaAnime)
                    .height(30.dp),
                color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                shape = RoundedCornerShape(EXTRA_SMALL_PADDING)
            ) {}
            Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
            repeat(3) {
                Surface(
                    modifier = Modifier
                        .alpha(alphaAnime)
                        .fillMaxWidth()
                        .height(15.dp),
                    color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                    shape = RoundedCornerShape(EXTRA_SMALL_PADDING)
                ) {}
                Spacer(modifier = Modifier.padding(all = EXTRA_SMALL_PADDING))
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                repeat(5) {
                    Surface(
                        modifier = Modifier
                            .alpha(alphaAnime)
                            .size(20.dp),
                        color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                        shape = RoundedCornerShape(SMALL_PADDING)
                    ) {}
                    Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
                }
            }
        }

    }

}

@Preview
@Composable
fun ShimmerEffectPreview() {
    AnimatedShimmerItem()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerEffectPreviewNightMode() {
    ShimmerEffect()
}