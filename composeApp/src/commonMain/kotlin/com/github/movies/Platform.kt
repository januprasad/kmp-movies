package com.github.movies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform