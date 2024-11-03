package com.github.movies

import androidx.compose.runtime.*
import com.github.movies.screens.Navz
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        Navz()
    }
}