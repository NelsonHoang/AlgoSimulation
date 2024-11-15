package com.nhoang.algosimulation.ui.model

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nhoang.algosimulation.domain.usecase.AlgorithmUseCaseInterface
import com.nhoang.algosimulation.domain.usecase.SASumEqualsKUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = AlgorithmViewModel.AlgorithmViewModelFactory::class)
class AlgorithmViewModel @AssistedInject constructor(
    @Assisted val id: Int
) : ViewModel() {
    private val _arrayInputFieldInput = mutableStateOf("")
    private val _targetInputFieldInput = mutableIntStateOf(0)
    private val _result = mutableIntStateOf(-1)

    val arrayInputFieldInput = _arrayInputFieldInput
    val targetInputFieldInput = _targetInputFieldInput
    val result = _result

    private val _algorithmUseCaseInterface = getAlgorithmViewModel(id)

    @AssistedFactory
    interface AlgorithmViewModelFactory {
        fun create(id: Int): AlgorithmViewModel
    }

    fun execute() {
        result.value = _algorithmUseCaseInterface.execute(
            _arrayInputFieldInput.value.split(",").map { it.trim().toInt() }.toIntArray(),
            _targetInputFieldInput.intValue
        )
    }

    fun getPrimaryInputLabel(): String {
        return _algorithmUseCaseInterface.getPrimaryInputLabel()
    }

    fun getSecondaryInputLabel(): String {
        return _algorithmUseCaseInterface.getSecondaryInputLabel()
    }

    private fun getAlgorithmViewModel(id: Int): AlgorithmUseCaseInterface {
        when (id) {
            0 -> return SASumEqualsKUseCase()
        }
        return SASumEqualsKUseCase()
    }
}