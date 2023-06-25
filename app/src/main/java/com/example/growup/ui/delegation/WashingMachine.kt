package com.example.growup.ui.delegation

interface WashingMachine {
    fun wash()
    fun dry()
}

class LG(private val machineSerialNum: String, private val capacity: Int) : WashingMachine {
    override fun wash() {
        println("$machineSerialNum washes using $capacity watt")
    }

    override fun dry() {
        println("$machineSerialNum dries using $capacity watt")
    }
}

class Electrolux(washingMachine: WashingMachine) : WashingMachine by washingMachine

fun main() {

    val machineSerialNum = "P8675RRT"
    val capacity = 1000
    val lg = LG(machineSerialNum, capacity)
    val electrolux = Electrolux(lg)
    electrolux.wash()
    electrolux.dry()
}