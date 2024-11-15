package com.nhoang.algosimulation.domain.usecase

class SASumEqualsKUseCase : AlgorithmUseCaseInterface{

    override fun execute(array: IntArray, target : Int): Int {
        var count = 0
        var sum = 0

        val map = mutableMapOf(0 to 1)
        for (num in array) {
            sum += num
            val difference = map[sum - target]
            difference?.let {
                count += it
            }
            map[sum] = map.getOrDefault(sum, 0) + 1
        }

        return count
    }

    override fun getPrimaryInputLabel(): String {
        return "Enter Array"
    }

    override fun getSecondaryInputLabel(): String {
        return "Enter Target Sum"
    }
}
