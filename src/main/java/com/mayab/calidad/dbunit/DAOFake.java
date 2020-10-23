package com.mayab.calidad.dbunit;

import java.util.HashMap;

public class DAOFake implements DAO{
	
	HashMap<Integer, Alumno> alumnosHashMap = new HashMap<Integer, Alumno>();

	public boolean addAlumno(Alumno a) {
		alumnosHashMap.put(a.getId(), a);
		return false;
	}

	public void deleteAlumno(Alumno a) {
		alumnosHashMap.remove(a.getId());
		
	}

	public void updatePromedio(Alumno a, double nuevoPromedio) {
		alumnosHashMap.get(a.getId()).setCalificacion(nuevoPromedio);
	}

	public int getNumeroAlumnos() {
		return alumnosHashMap.size();
	}

	public Alumno getAlumno(int id) {
		return alumnosHashMap.get(id);
	}
	
	public HashMap<Integer, Alumno> getHashMap(){
		return alumnosHashMap;
	}
}