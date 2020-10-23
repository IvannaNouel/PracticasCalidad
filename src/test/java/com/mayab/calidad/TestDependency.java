package com.mayab.calidad;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;
public class TestDependency {
	
	private Dependency dependency;
	
	@Before
	public void setupMocks() {
		
		dependency = mock(Dependency.class);

	}
	

	@Test
	public void test() {
		when(dependency.getClassName()).thenReturn("Mi Nombre");
		
		assertNull(dependency.getClassName(),is("Mi Nombre"));
		assertNull(dependency.getClassName());
		assertNull(dependency.getClassNameUpperCase());
		assertNull(dependency.getSubdependencyClassname());


	}
	@Test
	(expected= IllegalArgumentException.class)
	public void testException() {
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
	

	}
	
	@Test
	public void testAddTwo()
	{
		when(dependency.addTwo(1)).thenReturn(5);
		assertEquals(5, dependency.addTwo(1));
		assertEquals(0, dependency.addTwo(27));
	}
	
	@Test
	public void testAnswer()
	{
		when (dependency.addTwo(anyInt())).thenAnswer(new Answer <Integer> () {
			
		public Integer answer(InvocationOnMock invocation) throws Throwable
		{
			int arg = (Integer) invocation.getArguments() [0];
			return arg +20;
		}
		});
		assertEquals(30, dependency.addTwo(10));
	}
	
}
