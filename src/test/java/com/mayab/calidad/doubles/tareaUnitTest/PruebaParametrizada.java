package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



/**
 *
 * @author ivannanouel
 */
@RunWith(Parameterized.class)
public class PruebaParametrizada {

    /**
     *
     * @return
     */
	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]
				{
			{"Ivanna",200,2},{"Melissa",500,1},{"Veronica",100,3}
				});
			
	}
		   
	  String holder;
	  int initialBalance;
	  int zone;
	   
	  /**
	     *
	     * @param holder
	     * @param zone
	     * @param initialBalance
	     */
	public void TestCuentaParametrizada(String holder, int initialBalance, int zone)
	{
		this.holder = holder;
        this.initialBalance = initialBalance;
        this.zone=zone;
		
	}
	
	@Test
	public void Cuenta()
	{
		cuenta Cuenta = new cuenta(holder,initialBalance,zone);
		
		assertThat(Cuenta,is("{"+holder+"=Account [balance="+initialBalance+", holder="+holder+", zona="+zone+"]}"));
	
	}


}
