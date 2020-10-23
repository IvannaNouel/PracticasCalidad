package com.mayab.calidad.dbunit;

import java.sql.Connection;
import java.sql.DriverManager;

public class AlumnoDAOOracle implements DAO {

	public boolean addAlumno(Alumno a) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteAlumno(Alumno a) {
		// TODO Auto-generated method stub

	}

	public void updatePromedio(Alumno a, double nuevoPromedio) {
		// TODO Auto-generated method stub

	}

	public int getNumeroAlumnos() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Connection getConnection() {
		Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:hr:hr@//localhost:1521/xepdb1","system","hr");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
	}

}
