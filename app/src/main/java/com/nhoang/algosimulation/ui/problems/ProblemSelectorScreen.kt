package com.nhoang.algosimulation.ui.problems

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nhoang.algosimulation.AlgorithmExecutionActivity
import com.nhoang.algosimulation.data.repository.AlgorithmRepository

@Composable
fun ProblemSelectorScreen(problemSelectorViewModel: ProblemSelectorViewModel) {
    val problems by problemSelectorViewModel.getArrayProblems()
        .collectAsState(initial = emptyList())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(
            problems.size
        ) { problemIndex ->
            val context = LocalContext.current
            OutlinedButton(
                onClick = {
                    context.startActivity(Intent(context, AlgorithmExecutionActivity::class.java))
                },
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(50)
            ) {
                Text(problems[problemIndex].title)
            }
        }

    }
}

@Preview
@Composable
fun ProblemSelectorScreenPreview() {
    ProblemSelectorScreen(ProblemSelectorViewModel(AlgorithmRepository()))
}