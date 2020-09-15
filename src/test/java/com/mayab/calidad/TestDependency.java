package com.mayab.calidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;


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

}
