package com.mayab.calidad.dbunit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestAlumnos {
	
	DAOFake alumnosDB;
	Alumno alumno;
	
	@Before
	public void beforeTest() {
		alumnosDB = mock(DAOFake.class);
		alumno =  new Alumno(2, "Ivanna", 20, 6.5, "ivannamarcelle@gmail.com");
		setupHashMap();
	}
	
	public void setupHashMap() {
		when(alumnosDB.getHashMap()).thenReturn(new HashMap<Integer, Alumno>());
	}
	
	

	@Test
	public void testAddAlumno() {
		when(alumnosDB.addAlumno((Alumno) any())).thenAnswer(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable{
				Alumno arg = (Alumno) invocation.getArguments()[0];
				alumnosDB.getHashMap().putIfAbsent(arg.getId(), arg);
				return true;
			}
		});
		int size = alumnosDB.getHashMap().size();
		alumnosDB.addAlumno(alumno);
		assertThat(alumnosDB.getHashMap().size(), is(size+1));
 	}
	
}
