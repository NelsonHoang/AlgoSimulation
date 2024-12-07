package com.nhoang.algosimulation.ui.problems

import androidx.lifecycle.ViewModel
import com.nhoang.algosimulation.data.repository.AlgorithmRepository
import com.nhoang.algosimulation.data.repository.AlgorithmRepository.Companion.ARRAY_CATEGORY
import com.nhoang.algosimulation.domain.model.Problem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProblemSelectorViewModel @Inject constructor(
    private val repository: AlgorithmRepository
) : ViewModel() {
    fun getArrayProblems(): Flow<List<Problem>> {
        return repository.getProblemsByCategory(ARRAY_CATEGORY)
    }
}