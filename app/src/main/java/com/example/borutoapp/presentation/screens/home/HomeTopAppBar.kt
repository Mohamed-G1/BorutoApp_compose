package com.example.borutoapp.presentation.screens.home

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.borutoapp.ui.theme.topAppBarBackgroundColor
import com.example.borutoapp.ui.theme.topAppBarContentColor

@Composable
fun HomeTopAppBar(onSearchClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(
                text = "Search",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },

        actions = {
            IconButton(onClick = { onSearchClicked() }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            }
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}

@Preview
@Composable
fun TopBar() {
    HomeTopAppBar {}
}