package com.nhoang.algosimulation.data.repository

import com.nhoang.algosimulation.domain.model.Category
import com.nhoang.algosimulation.domain.model.Difficulty
import com.nhoang.algosimulation.domain.model.Example
import com.nhoang.algosimulation.domain.model.Problem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlgorithmRepository @Inject constructor() {
    private val categories = listOf(
        Category("Arrays", "Array problems", 10),
    )

    private val problems = mapOf(
        "sub-array-sum-equals-k" to Problem(
            categoryId = ARRAY_CATEGORY,
            title = "Sub Array Sum Equals K",
            description = "Given an IntArray, nums, and an Int k, return the number of subarrays " +
                    "that equal K",
            difficulty = Difficulty.MEDIUM,
            examples = listOf(
                Example(
                    input = "[1,1,1], k = 2",
                    output = "2",
                    explanation = "There are two contiguous subarrays that equal 2"
                )
            ),
            constraints = listOf(
                "1 <= nums.length <= 2 * 104",
                "-1000 <= nums[i] <= 1000",
                "-107 <= k <= 107"
            )
        )
    )

    fun getProblemsByCategory(categoryId: String): Flow<List<Problem>> = flow {
        emit(problems.values.filter { it.categoryId == categoryId })
    }

    companion object {
        const val ARRAY_CATEGORY = "arrays"
    }
}