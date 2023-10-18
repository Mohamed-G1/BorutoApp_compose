package com.example.borutoapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.borutoapp.domain.model.OnBoardingPages
import com.example.borutoapp.navigation.Screen
import com.example.borutoapp.ui.theme.LARGE_PADDING
import com.example.borutoapp.ui.theme.MEDIUM_PADDING
import com.example.borutoapp.ui.theme.PAGING_INDICATOR_WIDTH
import com.example.borutoapp.ui.theme.activeIndicatorColor
import com.example.borutoapp.ui.theme.descriptionColor
import com.example.borutoapp.ui.theme.finishButtonBackgroundColor
import com.example.borutoapp.ui.theme.inactiveIndicatorColor
import com.example.borutoapp.ui.theme.titleColor
import com.example.borutoapp.ui.theme.welcomeScreenBackgroundColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navHostController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPages.FirstScreen,
        OnBoardingPages.SecondScreen,
        OnBoardingPages.ThirdScreen,
    )

    val pagesState = rememberPagerState(
        pageCount = { 3 }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.welcomeScreenBackgroundColor)
    ) {
        HorizontalPager(
            modifier = Modifier
                .weight(10f),
            state = pagesState
        ) { position ->
            PagerScreen(onBoardingPages = pages[position])
        }

        CustomPagerIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            pageCount = 3,
            pagerState = pagesState
        )

        FinishButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = LARGE_PADDING),
            pagerState = pagesState
        ) {
            // on click
            navHostController.popBackStack()
            navHostController.navigate(Screen.Home.route)
            welcomeViewModel.saveOnBoardingState(completed = true)
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomPagerIndicator(
    modifier: Modifier,
    pageCount: Int,
    pagerState: PagerState
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .height(50.dp)
        ) {
            repeat(pageCount) { iteration ->
                val color = when (pagerState.currentPage == iteration) {
                    true -> {
                        MaterialTheme.colors.activeIndicatorColor
                    }

                    false -> {
                        MaterialTheme.colors.inactiveIndicatorColor
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(PAGING_INDICATOR_WIDTH)
                )
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = { onClick() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.finishButtonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Finish",
                )
            }
        }
    }

}

@Composable
fun PagerScreen(onBoardingPages: OnBoardingPages) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPages.image),
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPages.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING),
            text = onBoardingPages.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}