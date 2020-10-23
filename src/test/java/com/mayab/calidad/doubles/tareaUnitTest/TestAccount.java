package com.mayab.calidad.doubles.tareaUnitTest;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class TestAccount {

		
		private AlertListener Alert;
		private CuentaGuardar BD;

		
		ArrayList<transaction> transactions = new ArrayList<transaction>();
		
		
		@Before
		public void setUpMocks()
		{
			Alert= mock(AlertListener.class);
			BD= mock(CuentaGuardar.class);

		}
		
		
		@Test
		public void TestAbono() 
		{
			cuenta c = new cuenta("Ivanna Nouel",347999, 0, Alert, 2);
			
			c.setBD(BD);

			when(c.saveTransaction(anyDouble())).thenAnswer(new Answer <transaction> () 
			{
				
				public transaction answer(InvocationOnMock invocation) throws Throwable
				{
					
					transaction t = (transaction)invocation.getArguments() [0];
					
					
					transactions.add(t);
					
					return t;
				}
			}
		);
			
			c.credit(200);
			c.credit(500);
			c.credit(100);

			System.out.println("Your new balance is: "+c.getBalance());
			
			double comisionT= 0; 
			
			for(transaction t : transactions) {
				
				comisionT += t.com;
				
				
			}
			
			assertThat(c.getBalance(),is(784));
			assertThat(comisionT,is(16.0));
			
			
		}
			
	
		
		@Test
		public void testAlert() 
		{
			cuenta c =new cuenta("Ivanna Nouel",347999,100, Alert, 2);
			c.setBD(BD);
			c.debit(50);	
			verify(Alert).sendAlert("Ivanna Nouel, your account balance is below 100");
			
		}
		

		@Test
		public void testT() 
		{
			cuenta c1 =new cuenta("Ivanna Nouel",347999,100, Alert, 1);
			cuenta c2 =new cuenta("Melissa Puerto",345678,500, Alert, 2);
			cuenta c3 =new cuenta("Veronica Rodriguez",23456,300, Alert, 3);
			
			assertThat(c1.getBalance(),is(100));
			assertThat(c2.getBalance(),is(500));
			assertThat(c3.getBalance(),is(300));


		}


	}