package edu.unlam.paradigmas.tp.entidades;

public class Trader extends Usuario{
	protected CuentaBancaria cuentaTrader;
	
	public Trader(String nombre, int numCuenta, String nombreBanco, double saldo) {
		super(nombre);
		cuentaTrader = new CuentaBancaria(numCuenta,nombreBanco,saldo);
	}
	
	public Trader(String nombre, String numCuenta, String nombreBanco, String saldo) {
		super(nombre);
		cuentaTrader = new CuentaBancaria(Integer.parseInt(numCuenta),nombreBanco,Double.parseDouble(saldo));
	}

	@Override
	public String toString() {
		return "Trader [nombre=" + nombre + ", numCuenta="+this.cuentaTrader.getNumCuenta()+"]";
	}
	
	
}
