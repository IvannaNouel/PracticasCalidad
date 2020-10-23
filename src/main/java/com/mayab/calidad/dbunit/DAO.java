package com.mayab.calidad.dbunit;

public interface DAO {
	
	boolean addAlumno(Alumno a);
	
	void deleteAlumno(Alumno a);
	
	void updatePromedio(Alumno a, double nuevoPromedio);
	
	int getNumeroAlumnos();
	
	Alumno getAlumno(int id);
	
}
