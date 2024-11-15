package com.nhoang.algosimulation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nhoang.algosimulation.R
import com.nhoang.algosimulation.ui.model.AlgorithmViewModel
import com.nhoang.algosimulation.ui.model.AlgorithmViewModel.AlgorithmViewModelFactory

@Composable
fun AlgorithmExecutionScreen() {
    val algorithmViewModel =
        hiltViewModel<AlgorithmViewModel, AlgorithmViewModelFactory> { factory ->
            factory.create(0)
        }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = algorithmViewModel.inputFieldInput.value,
            onValueChange = { algorithmViewModel.inputFieldInput.value = it },
            label = { Text(algorithmViewModel.getInputLabel()) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = { algorithmViewModel.execute() }) {
            Text(stringResource(R.string.execute_button))
        }


    }
}

@Preview
@Composable
fun InputScreenPreview() {
    Surface(modifier = Modifier.background(color = Color.White)) {
        AlgorithmExecutionScreen()
    }
}