package com.exacta;

import org.junit.*;

public class CalculadoraTest {

    @BeforeClass
    public static void inicializar(){
        System.out.println("Inicializando recursos necessários para realização dos testes");
    }

    @Before
    public void antesDeCadaTest(){
        System.out.println("Antes de cada teste");
    }

    @Test
    public void addTestSuccess(){
        System.out.println("Teste addTestSuccess");
        Calculadora calculadora = new Calculadora();
        int total = calculadora.add(1, 2);
        Assert.assertEquals(3, total);
    }

    @Test
   // @Ignore
    public void addTestSuccess1(){
        System.out.println("Teste addTestSuccess1");
        Calculadora calculadora = new Calculadora();
        int total = calculadora.add(-1, 1);
        Assert.assertEquals(0, total);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){
        System.out.println("Teste divisao por zero");
        Calculadora calculadora = new Calculadora();
        calculadora.division(1, 0);
    }

    @Test
    public void divisionSuccess(){
        System.out.println("Teste divisao Success 1");
        Calculadora calculadora = new Calculadora();
        int total = calculadora.division(1, 1);
        Assert.assertEquals(1, total);
    }

    @After
    public void depoisDeCadaTest(){
        System.out.println("Após cada teste");
    }

    @AfterClass
    public static void finalizar(){
        System.out.println("Destruir recursos abertos pelo metodo anotado com @BeforeClass");
    }

}
