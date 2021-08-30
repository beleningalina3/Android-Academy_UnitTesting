package com.example.calculatorapp


import org.junit.Test
import org.junit.Assert
import org.junit.Assert.*
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println("Addition Test")
        Assert.assertEquals("La suma es correcta para 2+3 = 5",4, 2 + 3)
        //El message se ve solo cuando hay un error
    }

    @Test
    fun minus_isCorrect() {
        println("Minus Test")
        assertEquals(0,2-2)
    }
    @Test
    fun multiplication_isCorrect() {
        println("Multplication Test")
        assertEquals(4, 2*2)
    }
    @Test
    fun division_isCorrect (){
        println("Division Test")
        assertEquals(1, 2/2)
    }
}