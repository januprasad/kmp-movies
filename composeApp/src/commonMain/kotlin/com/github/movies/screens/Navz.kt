package com.github.movies.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.movies.screens.detail.DetailScreen
import com.github.movies.screens.home.HomeScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun Navz(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Home.path
    ){

        composable(Routes.Home.path) {
            HomeScreen(
                onMovieClick = { navController.navigate("detail/${it.id}") },
            )
        }

        composable(
            route = Routes.Detail.path,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = checkNotNull(backStackEntry.arguments?.getInt("movieId"))
            DetailScreen(
                vm = koinViewModel(parameters = { parametersOf(movieId) }),
                onBack = { navController.popBackStack() })
        }
    }
}

sealed class Routes(open val path: String){
    object Home : Routes("home")
    object Detail : Routes("detail/{movieId}")
}