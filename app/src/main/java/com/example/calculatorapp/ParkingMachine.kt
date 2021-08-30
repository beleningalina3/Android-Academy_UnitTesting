package com.example.calculatorapp

import java.lang.Exception
import java.lang.RuntimeException

class ParkingMachine {
    //Clicj derechho clase, crear clase de prueba
    //Con TDD

    fun calculateCost(minutes: Int): Int {
        if(minutes <0) throw Exception("Invalid number")
        if(minutes <= MAX_TIME_OF_FREE) return 0
        if(minutes>15 && minutes <30) return 20
        if(minutes>30 && minutes<180) return Math.ceil(minutes/30.0).toInt() * COST_OF_HALF_HOUR


        return 100
    }

    companion object {
        const val MAX_TIME_OF_FREE = 15
        const val COST_OF_HALF_HOUR = 20
    }

}