package com.nhoang.algosimulation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nhoang.algosimulation.ui.AlgorithmExecutionScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlgorithmExecutionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgorithmExecutionScreen()
        }
    }
}