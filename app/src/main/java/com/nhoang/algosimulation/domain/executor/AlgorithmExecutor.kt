package com.nhoang.algosimulation.domain.executor

import android.content.Context

interface AlgorithmExecutor {
    fun execute(array : IntArray, target : Int) : Int

    fun getPrimaryInputLabel(context: Context): String

    fun getSecondaryInputLabel(context: Context) : String
}