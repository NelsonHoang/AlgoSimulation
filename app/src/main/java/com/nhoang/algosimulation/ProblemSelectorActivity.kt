package com.nhoang.algosimulation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nhoang.algosimulation.ui.ProblemSelectorScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProblemSelectorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProblemSelectorScreen()
        }
    }
}