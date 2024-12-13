package com.nhoang.algosimulation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nhoang.algosimulation.navigation.Screen
import com.nhoang.algosimulation.ui.home.HomeScreen
import com.nhoang.algosimulation.ui.problems.ProblemSelectorScreen

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
        composable(route = Screen.Problems.route) {
            ProblemSelectorScreen(problemSelectorViewModel = hiltViewModel())
        }
    }
}