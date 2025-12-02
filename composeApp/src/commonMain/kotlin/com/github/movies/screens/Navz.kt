package com.github.movies.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.github.movies.screens.detail.DetailScreen
import com.github.movies.screens.home.HomeScreen
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun Navz() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {

        composable<HomeRoute> {
            HomeScreen(
                onMovieClick = { movie ->
                    navController.navigate(DetailRoute(movie.id))
                }
            )
        }
        composable<DetailRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<DetailRoute>()
            DetailScreen(
                vm = koinViewModel(parameters = { parametersOf(args.movieId) }),
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Serializable
data class DetailRoute(val movieId: Int)

@Serializable
object HomeRoute