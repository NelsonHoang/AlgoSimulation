package com.nhoang.algosimulation.ui

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nhoang.algosimulation.AlgorithmExecutionActivity

@Composable
fun ProblemSelectorScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        val context = LocalContext.current
        OutlinedButton (
            onClick = {
                context.startActivity(Intent(context, AlgorithmExecutionActivity::class.java))
            },
            border = BorderStroke(1.dp, Color.LightGray),
            shape = RoundedCornerShape(50)
        ) {
            Text("Run Sub Array Sum Equals K")
        }
    }
}

@Preview
@Composable
fun ProblemSelectorScreenPreview() {
    ProblemSelectorScreen()
}