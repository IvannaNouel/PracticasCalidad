package com.mayab.calidad.doubles.tareaUnitTest;

public class transaction {
	
	int idCuenta;
	double monto;
	double com;
	
	public transaction(int idCuenta, double monto, double com) {
		super();
		this.idCuenta = idCuenta;
		this.monto = monto;
		this.com = com;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getCom() {
		return com;
	}

	public void setCom(double com) {
		this.com = com;
	}
	
	

}
