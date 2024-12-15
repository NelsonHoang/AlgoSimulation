package com.nhoang.algosimulation.ui.problems

import androidx.lifecycle.ViewModel
import com.nhoang.algosimulation.data.repository.AlgorithmRepository
import com.nhoang.algosimulation.domain.model.Problem
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow

@HiltViewModel(assistedFactory = ProblemSelectorViewModel.ProblemSelectorViewModelFactory::class)
class ProblemSelectorViewModel @AssistedInject constructor(
    private val repository: AlgorithmRepository,
    @Assisted val category: String
) : ViewModel() {

    @AssistedFactory
    interface ProblemSelectorViewModelFactory {
        fun create(category: String): ProblemSelectorViewModel
    }

    fun getArrayProblems(): Flow<List<Problem>> {
        return repository.getProblemsByCategory(category)
    }
}