package com.mayab.calidad.DBIntegration;

import java.io.File;

import org.junit.Test;

public class TestAlumnoDocker {
	
	@Test
	public void insertAlumnoTest() {
		Alumno a = new Alumno();
		a.setId(1);
		a.setNombre("Ivanna");
		
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		dao.addAlumno(a);
		
		try {
		//	IDataSet expectedDataSet = new FlatXmDataSetBuilder().build(new File("src/resources/insert_result.xml"));
		//	ITable expectedTable = expectedDataSet.getTable("alumno");
			
		//	ITable actualData = getConnection()
			//		.createdQueryTable(
				//			"result_alumno",
				//			"SELECT * FROM alumno");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
