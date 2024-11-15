package com.nhoang.algosimulation.ui.model

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
    private val _inputFieldInput = mutableStateOf("")
    val inputFieldInput = _inputFieldInput

    private val _algorithmUseCaseInterface = getAlgorithmViewModel(id)

    @AssistedFactory
    interface AlgorithmViewModelFactory {
        fun create(id: Int): AlgorithmViewModel
    }

    fun execute() {
        _algorithmUseCaseInterface.execute(intArrayOf())
    }

    fun getInputLabel(): String {
        return _algorithmUseCaseInterface.getInputLabel()
    }

    private fun getAlgorithmViewModel(id: Int): AlgorithmUseCaseInterface {
        when (id) {
            0 -> return SASumEqualsKUseCase()
        }
        return SASumEqualsKUseCase()
    }
}