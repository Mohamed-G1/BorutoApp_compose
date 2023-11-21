package com.example.borutoapp.component

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.borutoapp.R
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.ui.theme.LARGE_PADDING
import com.example.borutoapp.ui.theme.MEDIUM_PADDING
import com.example.borutoapp.ui.theme.SMALL_PADDING
import com.example.borutoapp.ui.theme.Shapes
import com.example.borutoapp.ui.theme.topAppBarContentColor
import com.example.borutoapp.utils.Constants

@Composable
fun ContentList(
    heroes: LazyPagingItems<Hero>,
    navHostController: NavHostController
) {
    Log.d("HEROESLIST", heroes.itemCount.toString())

    LazyColumn(
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    )
    {
//        items(heroes.itemCount) { index ->
//            val item = heroes[index]
//            item?.let { hero ->
//                HeroItem(hero = hero, navHostController = navHostController)
//
//            }
//
//        }


//        items(
//            items = heroes,
//            key = { hero ->
//                hero.id
//            }
//        ) { hero ->
//            hero?.let {
//                HeroItem(hero = it, navController = navController)
//            }
//        }

        items(
            count = heroes.itemCount,
            key = heroes.itemKey { it.id }
        ) { index ->
            val item = heroes[index]
            item?.let { hero ->
                HeroItem(hero = hero, navHostController = navHostController)
            }
        }
    }

}

@Composable
fun HeroItem(
    hero: Hero,
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .height(400.dp)
//            .clickable { navHostController.navigate(Screen.Details.passHeroId(heroId = hero.id)) }
        ,
        contentAlignment = Alignment.BottomStart
    )
    {
        Surface(
            shape = Shapes.large
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${Constants.BASE_URL}${hero.image}")
                    .crossfade(true)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            ),

            ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING)
            ) {
                Text(
                    text = hero.name,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = hero.about,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )


                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(
                        modifier = Modifier.padding(end = SMALL_PADDING),
                        rating = hero.rating
                    )
                    Text(
                        text = "(${hero.rating})",
                        color = Color.White.copy(alpha = ContentAlpha.medium),
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroItemPreview() {
    HeroItem(
        hero = Hero(
            id = 4797,
            name = "Marguerite Mayer",
            image = "possit",
            about = "quaestio",
            rating = 2.3,
            power = 7049,
            month = "nascetur",
            day = "dolores",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()

        ), navHostController = rememberNavController()
    )
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroItemNightModePreview() {
    HeroItem(
        hero = Hero(
            id = 4797,
            name = "Marguerite Mayer",
            image = "possit",
            about = "quaestio",
            rating = 2.3,
            power = 7049,
            month = "nascetur",
            day = "dolores",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()

        ), navHostController = rememberNavController()
    )
}