package com.nhoang.algosimulation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nhoang.algosimulation.navigation.Screen
import com.nhoang.algosimulation.ui.home.HomeScreen
import com.nhoang.algosimulation.ui.problems.ProblemSelectorScreen
import com.nhoang.algosimulation.ui.problems.ProblemSelectorViewModel

/**
 * Responsible for navigating across screens
 */
@Composable
fun NavigationCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(homeViewModel = hiltViewModel(), navController = navController)
        }
        composable(
            route = Screen.Problems.route + "?category={category}",
            arguments = listOf(
                navArgument(CATEGORY) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) {
            ProblemSelectorScreen(problemSelectorViewModel = hiltViewModel<ProblemSelectorViewModel, ProblemSelectorViewModel.ProblemSelectorViewModelFactory> { factory ->
                val category = it.arguments?.getString(CATEGORY) ?: ""
                factory.create(category)
            })
        }
    }
}

const val CATEGORY = "category"