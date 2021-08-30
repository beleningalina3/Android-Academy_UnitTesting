package com.example.calculatorapp

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import org.junit.function.ThrowingRunnable
import java.lang.Exception

class ParkingMachineTest{

    private val parkingMachine = ParkingMachine()
    //Este es el objeto que quiero probar


    //<0 Exception invalido
    //0-15 Gratis
    //16-30 $20
    //Cada 30 min $20 mas
    //Mas de 3 hs (180 min): Exception

    @Test
    fun `Test that less than 0 throws exception`() {
        Assert.assertThrows(//Es mas correcto, para validar excepciones, mejor control
            Exception::class.java,
            ThrowingRunnable {
                parkingMachine.calculateCost(-1)
            }
        )

        Assert.assertThrows(
            Exception::class.java,
            ThrowingRunnable {
                parkingMachine.calculateCost(-100)
            }
        )
    }

    @Test (expected = Exception::class)
    fun `Test that less than 0 throws exception 2`() {
        parkingMachine.calculateCost(-1)
        //Este me debe dar un error, por que al lanzarse un error, no sigue la ejecucion
        //

    }

    @Test
    fun `Test that from 0 to 15 will be free`() {
        Assert.assertEquals("Test 0 give free", 0, parkingMachine.calculateCost(0))
        //Si tengo una prueba con muchos assert,si uno falla se para la prueba y los test siguientes no se ejecutan
        //Hay que dividirlos por la lógica en común
    }

    @Test
    fun `Test 10 give free`() {
        Assert.assertEquals("Test 10 give free", 0, parkingMachine.calculateCost(10))
    }

    @Test
    fun `Test 15 give free`() {
        Assert.assertEquals("Test 15 give free", 0, parkingMachine.calculateCost(15))
    }

    @Test
    fun `More than 15 is not free`() {
        Assert.assertTrue("More than 15 is not free", parkingMachine.calculateCost(16)>0 )
    }

    @Test
    fun `Test that from 16 to 30 will cost $20` () {
        Assert.assertEquals("Test  16 give 20", 20, parkingMachine.calculateCost(16))
        Assert.assertEquals("Test  18 give 20", 20, parkingMachine.calculateCost(18))
        Assert.assertEquals("Test  20 give 20", 20, parkingMachine.calculateCost(29))
    }

    @Test
    fun `Test from 30 to 3 hours, give 20 every 30 min`() {
        Assert.assertEquals("1",40, parkingMachine.calculateCost((31)))
        Assert.assertEquals("2",40, parkingMachine.calculateCost(59))
        Assert.assertEquals("3",40, parkingMachine.calculateCost(60))
        Assert.assertEquals("4",60, parkingMachine.calculateCost(61))
        Assert.assertEquals("5",120, parkingMachine.calculateCost(179))
        //Assert.assertEquals("6",120, parkingMachine.calculateCost(180))
    }
}