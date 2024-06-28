package edu.unlam.paradigmas.tp.entidades;

import java.util.Objects;


public class CuentaBancaria {
	protected int numCuenta;
	protected String nombreBanco;
	private double saldo;
	
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
	
	public boolean saldoDisponible(double monto) {
		return this.saldo >= monto;
	}
	
	public void acreditar(double monto) {
		saldo += monto;
	}
	
	public void debitar(double monto) {
		saldo -= monto;
	}
	
	public boolean depositar(double monto) {
		if(monto >= 0) {
			acreditar(monto);
		} else {
			return false;
		}
		
		return true;
	}
	
	public boolean extraer(double monto) {
		
		if(saldoDisponible(monto))
			debitar(monto);
		else 
			return false;
		
		return true;
	}
	

	@Override
	public String toString() {
		return "CuentaBancaria [numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreBanco, numCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		return Objects.equals(nombreBanco.strip().toLowerCase(), other.nombreBanco.strip().toLowerCase()) && numCuenta == other.numCuenta;
	}
	
	
	
}
