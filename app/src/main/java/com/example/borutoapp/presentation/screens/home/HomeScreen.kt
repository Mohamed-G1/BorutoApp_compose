package com.example.borutoapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopAppBar(onSearchClicked = { })
        }
    ) {

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}