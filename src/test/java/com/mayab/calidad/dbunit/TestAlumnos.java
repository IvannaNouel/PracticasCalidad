package com.mayab.calidad.dbunit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestAlumnos extends DBTestCase {
	
	DAO alumnosDB;
	Alumno alumno;
	Connection con;
	
	public TestAlumnos(String name) {
		super(name);
		System.out.println("HEJDKASJKDSAJKDJKASLDJKLAS");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1521:xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "dbunit");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "dbunit");
		
		this.alumnosDB = new AlumnoDAOOracle();
	}
	
	@Before
	public void beforeTest() throws SQLException {
		System.out.println("HUEHUEHUEHEUE");
		con = ((AlumnoDAOOracle) this.alumnosDB).getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute((IDatabaseConnection) con, getDataSet());
		} catch (Exception e) {
			System.out.println("Error connecting to the db");
		} finally {
			con.close();
		}
	}
	

	@Test
	public void testCountAlumnos() {
		int size = alumnosDB.getNumeroAlumnos();
		
		assertThat(size, is(3));
 	}

	@Test
	public void testAddAlumno() {
		alumno = new Alumno(4, "James Bond", 35, 98.5, "james007@bond.com");
		
		boolean result = alumnosDB.addAlumno(alumno);
		
		assertThat(result, is(true));
		assertThat(alumnosDB.getNumeroAlumnos(), is(4));
 	}
	@Test
	
	public void testremove() {
		
		alumno = new Alumno(1, "Ivanna Nouel", 20, 69, "ivannan@hotmail.com");
		
		alumnosDB.deleteAlumno(alumno.getId());
				try {
					Alumno result = alumnosDB.getAlumno(alumno.getId());
					assertThat(result, is(true));
					assertThat(alumnosDB.getNumeroAlumnos(), is(3));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		
	}

	}
	@Test
	public void testUpdatePromedio() {
		
	
		alumno = new Alumno(1, "Ivanna Nouel", 20, 60, "ivannan@hotmail.com");
		
		alumnosDB.updatePromedio(alumno, alumno.getCalificacion());
				try {
					
					Alumno result = alumnosDB.getAlumno(alumno.getCalificacion());
					assertThat(result, is(true));
					assertThat(alumnosDB.getNumeroAlumnos(), is(3));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		
	}


	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new File("src/test/mock-data/alumnos-mock.xml"));
	}
	
	
}