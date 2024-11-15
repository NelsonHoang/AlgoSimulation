package com.nhoang.algosimulation.domain.usecase

interface AlgorithmUseCaseInterface {
    fun execute(array : IntArray, target : Int) : Int

    fun getPrimaryInputLabel() : String

    fun getSecondaryInputLabel() : String
}