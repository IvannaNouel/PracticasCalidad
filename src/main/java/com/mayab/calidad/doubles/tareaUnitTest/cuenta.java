package com.mayab.calidad.doubles.tareaUnitTest;

public class cuenta {

	int balance;
	String holder;
	AlertListener alerts;
	CuentaGuardar BD;
	int Zone;
	int ID;

	public int sum = 0;

	public cuenta(String holder, int ID, int initialBalance, AlertListener alerts, int Zone) {
		this.holder = holder;
		this.balance = initialBalance;
		this.alerts = alerts;
		this.Zone = Zone;
		this.ID = ID;
	}

	public cuenta(String holder, int balance, int Zone) {

		this.holder = "Person";
		this.balance = balance;
		this.Zone = 1;
	}

	public void setBD(CuentaGuardar bD) {
		this.BD = bD;
	}

	public int getBalance() {
		return this.balance;
	}

	public String getHolder() {
		return this.holder;
	}

	public void debit(int monto) {
		if (this.balance <= 0) {
			System.out.println("Not enough money on your account");
		}
		transaction t = this.saveTransaction(monto * -1);
		this.balance += (int) t.getMonto() - t.getCom();

		if (this.balance < 100) {
			this.alerts.sendAlert(this.holder + ", your account balance is below 100");
		}
	}

	public void credit(int monto) {
		
		transaction t = this.saveTransaction(monto);
		System.out.println(" Credit: "+this.balance);
		this.balance += (int) t.getMonto() - t.getCom();

		if (this.balance < 100) {
			this.alerts.sendAlert(this.holder + ", your account balance is below 100");
		}
	}

	public void setBalance(int balance) {
		this.balance = balance;
		if (this.balance < 100) {
			this.alerts.sendAlert(this.holder + ", your account balance is below 100");
		}
	}

	void setAlertListener(AlertListener listener) {
		this.alerts = listener;
	}


	public transaction saveTransaction(double monto) {

		double comision = (monto * (0.01 * this.Zone));
		double ncom = monto - comision;
		
		transaction t = new transaction(this.ID, monto, comision);
		this.BD.guardar(t);
		System.out.println(" Monto : " + monto + " Comision : " + comision);
		return t;

	}
}