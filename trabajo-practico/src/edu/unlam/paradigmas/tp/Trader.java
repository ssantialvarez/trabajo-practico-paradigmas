package edu.unlam.paradigmas.tp;

public class Trader extends Usuario{
	protected CuentaBancaria cuentaTrader;
	
	public Trader(String nombre, int numCuenta, String nombreBanco, double saldo) {
		super(nombre);
		cuentaTrader = new CuentaBancaria(numCuenta,nombreBanco,saldo);
	}
	
	
}
