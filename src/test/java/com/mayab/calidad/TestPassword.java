package com.mayab.calidad;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ivannanouel
 */
public class TestPassword {
	static Password miPassword;
	
    /**
     *
     */
    @BeforeClass
	public static void setup() {
		System.out.println("Before test --->");
	miPassword  = new Password();
	}
	
    /**
     *
     */
    @Test
    public void testCadenaVacia()
    {
    //inicializar
    Password pass = new Password();
    pass.setValue("");
    //Ejercicio
     String value = pass.getValue();
    assertEquals(pass.getValue(),is(""));
    }
	
    /**
     *
     */
    @Test
	public void TestChecarMaximo()
	{
		int operador1 = 12;
		//inicializar
	    Password pass = new Password();
	    pass.setValue("abcdefghijklmn12345");
	    //Ejercicio
	     int longitud = pass.value.length();
	     if (longitud>12)
	     {
	    	 System.out.println("Error"+longitud);
	     }
	 
		
	}
	/*
	@Test
	public void DivisionPositivosTest()
	{
		float dividendo = 10;
		float divisor= 5;
		float expectedResult=2;
		float resultado = -1;
		System.out.println("Ultimo resultado = " + miCalculadora.getUltimaResultado());
		resultado = miCalculadora.division(dividendo, divisor);
		
		//assertEquals(expectedResult,resultado,0); //verify
		assertThat(resultado,is(expectedResult));
		
	}
	
	@Test
	public void DivisionCeroEntreCero()
	{
		float dividendo = 0;
		float divisor= 0;
		float expectedResult=Float.NaN;
		float resultado = -1;
		System.out.println("Ultimo resultado = " + miCalculadora.getUltimaResultado());
		resultado = miCalculadora.division(dividendo, divisor);
		
		//assertEquals(expectedResult,resultado,0); //verify
		assertThat(resultado,is(expectedResult));
		
	}
	@Test
	public void DivisionEntreCeroTest()
	{
		float dividendo = 10;
		float divisor= 0;
		float expectedResult= Float.POSITIVE_INFINITY;
		float resultado = -1;
		System.out.println("Ultimo resultado = " + miCalculadora.getUltimaResultado());
		resultado = miCalculadora.division(dividendo, divisor);
		
		//assertEquals(expectedResult,resultado,0); //verify
		assertThat(resultado,is(expectedResult));
		
	}
	
	@After
	public void despues()
	{
		System.out.println(">>> Despuues de la prueba");
	}
	@AfterClass
	public static void fin()
	{
		System.out.println(">>>Ya termine");
	}*/

}
