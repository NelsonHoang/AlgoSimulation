package com.nhoang.algosimulation.domain.usecase

interface AlgorithmUseCaseInterface {
    fun execute(array : IntArray) : Int

    fun getInputLabel() : String
}