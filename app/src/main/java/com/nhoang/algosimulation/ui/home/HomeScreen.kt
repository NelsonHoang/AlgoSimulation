package com.nhoang.algosimulation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nhoang.algosimulation.navigation.Screen

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavController) {
    val categories by homeViewModel.getCategories()
        .collectAsState(initial = emptyList())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(
            categories.size
        ) { categoriesIndex ->
            val categoryName = categories[categoriesIndex].name
            OutlinedButton(
                onClick = {
                    navController.navigate(route = Screen.Problems.route + "?category=${categoryName}")
                },
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(50)
            ) {
                Text(categoryName)
            }
        }
    }
}