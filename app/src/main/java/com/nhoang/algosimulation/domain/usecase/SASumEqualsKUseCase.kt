package com.nhoang.algosimulation.domain.usecase

import android.content.Context
import com.nhoang.algosimulation.R

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

    override fun getPrimaryInputLabel(context: Context): String {
        return context.getString(R.string.array_text_edit_label)
    }

    override fun getSecondaryInputLabel(context: Context): String {
        return context.getString(R.string.sa_sum_equal_k_secondary_label)
    }
}
