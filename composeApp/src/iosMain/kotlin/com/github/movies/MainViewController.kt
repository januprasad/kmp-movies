package com.github.movies

import androidx.compose.ui.window.ComposeUIViewController
import com.github.movies.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }