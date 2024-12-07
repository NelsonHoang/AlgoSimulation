package com.nhoang.algosimulation.domain.model

data class Problem(
    val categoryId: String,
    val title: String,
    val description: String,
    val difficulty: Difficulty,
    val examples: List<Example>,
    val constraints: List<String>
)