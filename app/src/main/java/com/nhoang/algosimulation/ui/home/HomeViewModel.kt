package com.nhoang.algosimulation.ui.home

import androidx.lifecycle.ViewModel
import com.nhoang.algosimulation.data.repository.AlgorithmRepository
import com.nhoang.algosimulation.domain.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: AlgorithmRepository) : ViewModel() {
    fun getCategories(): Flow<List<Category>> {
        return repository.getCategories()
    }
}