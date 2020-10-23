package com.mayab.calidad.dbunit;

public class AlumnoDriver{
	public static void main() {
		AlumnoDAOOracle a = new AlumnoDAOOracle();
		a.getConnection();
		
	}
}
