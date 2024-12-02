package com.nhoang.algosimulation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.nhoang.algosimulation.R
import com.nhoang.algosimulation.ui.model.AlgorithmViewModel
import com.nhoang.algosimulation.ui.model.AlgorithmViewModel.AlgorithmViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AlgorithmExecutionScreen() {
    val algorithmViewModel =
        hiltViewModel<AlgorithmViewModel, AlgorithmViewModelFactory> { factory ->
            factory.create(0)
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            modifier = Modifier.padding(8.dp),
            value = algorithmViewModel.arrayInputFieldInput.value,
            onValueChange = { algorithmViewModel.arrayInputFieldInput.value = it },
            label = { Text(algorithmViewModel.getPrimaryInputLabel(LocalContext.current)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            modifier = Modifier.padding(8.dp),
            value = algorithmViewModel.targetInputFieldInput.intValue.toString(),
            onValueChange = {
                algorithmViewModel.targetInputFieldInput.intValue =
                    if (it.isEmpty()) 0 else it.toInt()
            },
            label = { Text(algorithmViewModel.getSecondaryInputLabel(LocalContext.current)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        val result = algorithmViewModel.result
        Text(
            text = stringResource(
                R.string.result_text,
                if (result.intValue >= 0) result.intValue.toString() else -1
            ),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(modifier = Modifier.background(Color.Gray),
            onClick = {
                algorithmViewModel.viewModelScope.launch(Dispatchers.IO) {
                    algorithmViewModel.execute()
                }
            }) {
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