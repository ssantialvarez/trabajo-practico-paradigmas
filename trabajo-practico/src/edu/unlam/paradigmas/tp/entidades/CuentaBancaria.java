package edu.unlam.paradigmas.tp.entidades;

public class CuentaBancaria {
	protected int numCuenta;
	protected String nombreBanco;
	protected double saldo;
	
	public CuentaBancaria(int numCuenta, String nombreBanco, double saldo) {
		this.numCuenta = numCuenta;
		this.nombreBanco = nombreBanco;
		this.saldo = saldo;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + ", saldo=" + saldo + "]";
	}
	
	
	
}
