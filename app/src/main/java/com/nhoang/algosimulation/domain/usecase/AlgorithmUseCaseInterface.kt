package com.nhoang.algosimulation.domain.usecase

import android.content.Context

interface AlgorithmUseCaseInterface {
    fun execute(array : IntArray, target : Int) : Int

    fun getPrimaryInputLabel(context: Context): String

    fun getSecondaryInputLabel(context: Context) : String
}