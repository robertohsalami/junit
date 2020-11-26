package com.exacta;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraTestJUnit5 {

    @BeforeEach
    public void beforeTest(){
        System.out.println("Antes de cada teste");
    }

    @Test
    @DisplayName("1 + 1 = 2")
    public void addTestSuccess(){
        Calculadora calculadora = new Calculadora();
        Assertions.assertEquals(2, calculadora.add(1,1), "1 + 1 dever ser igual a 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({"0, 1, 1",
    "1, 2, 3",
    "49, 51, 100",
    "1, 100, 101"})
    public void addTestSuccess1(int first, int second, int expectedResult){
        Calculadora calculadora = new Calculadora();
        Assertions.assertEquals(expectedResult, calculadora.add(first, second),
                () -> first + " + " + second + " deve ser " + expectedResult);
    }

}
