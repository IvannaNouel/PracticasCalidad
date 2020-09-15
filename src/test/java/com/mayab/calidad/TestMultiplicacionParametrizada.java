package com.mayab.calidad;

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
public class TestMultiplicacionParametrizada {

    /**
     *
     * @return
     */
    @Parameters
	public static Iterable data() {
		return Arrays.asList(new Object[][]
				{
			{4,2,2},{6,3,2},{5,5,1},{10,5,2}
				});
			
	}
	
	private float multiplierOne;
	private float expected;
	private float multiplierTwo;
	
    /**
     *
     * @param expected
     * @param multiplierOne
     * @param multiplierTwo
     */
    public TestMultiplicacionParametrizada(float expected, float multiplierOne, float multiplierTwo)
	{
		this.multiplierOne= multiplierOne;
		this.expected = expected;
		this.multiplierTwo= multiplierTwo;
		
	}

    /**
     *
     */
    @Test
	public void givenTwoNumbersShouldBeMultiplyResult()
	{
		//Assert.assertEquals(expected, multiplierOne*multiplierTwo);
		assertThat(multiplierOne*multiplierTwo,is(expected));
	}
}
