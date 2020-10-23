package com.mayab.calidad.DBIntegration;

public class ALumnoDriver{
	public static void main(String[] args) {
		AlumnoDAOOracle a = new AlumnoDAOOracle();
		a.getConnection();
		
	}
}