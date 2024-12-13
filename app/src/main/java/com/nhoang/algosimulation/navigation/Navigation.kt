package com.nhoang.algosimulation.navigation

import com.nhoang.algosimulation.navigation.Destination.HOME
import com.nhoang.algosimulation.navigation.Destination.PROBLEMS

object Destination {
    const val HOME = "home"
    const val PROBLEMS = "problems"
}

sealed class Screen(
    val route: String,
) {
    data object Home : Screen(route = HOME)
    data object Problems : Screen(route = PROBLEMS)
}