package edu.unlam.paradigmas.tp.entidades;

import java.util.Objects;
import java.util.Scanner;

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
	
	public void compraCriptomoneda(Criptomonedas regCripto, Scanner teclado) {
		Criptomoneda cripto = null;
		String simbolo;
		
		
		while(cripto == null) {
			System.out.println("Ingrese simbolo de la criptomoneda a comprar:");
			simbolo = teclado.nextLine();
			cripto = regCripto.getCriptomoneda(simbolo);
			if(cripto == null)
				System.out.println("No se encontro el simbolo. Reingresar.");
		}
		
		
		
	}
	
	

	@Override
	public void menu() {
		System.out.println("Menú de opciones ");
		System.out.println("------------------");
		System.out.println();
		System.out.println(" 1) Comprar Criptomoneda");
		System.out.println(" 2) Vender Criptomoneda");
		System.out.println(" 3) Consultar Criptomoneda");
		System.out.println(" 4) Recomendar Criptomoneda");
		System.out.println(" 5) Consultar estado actual del mercado");
		System.out.println(" 6) Visualizar archivo de transacciones (histórico).");
		System.out.println(" 7) Salir");
		System.out.println();
		System.out.println("Ingrese su opción (1 - 6): _ ");
	}
	
	@Override
	public int ingresaOpcion(int opcion, Criptomonedas regCripto, Scanner teclado) {
		switch(opcion) {
			case 1:
				System.out.println("Eligio comprar una criptomoneda.");
				
				break;
			case 2:
				System.out.println("Eligio vender una criptomoneda.");
				
				break;
			case 3:
				System.out.println("Eligio consultar una criptomoneda.");
				this.consultarCriptomoneda(regCripto, teclado);
				break;
			case 4:
				System.out.println("Eligio recomendar una criptomoneda.");
				
				break;
			case 5:
				System.out.println("Eligio consultar estado actual del mercado.");
				this.verEstadoActualMercado(regCripto);
				break;
			case 6:
				System.out.println("Eligio visualizar archivo de transacciones (histórico).");
				
				break;
			case 7:
				System.out.println("Eligio salir.");
				opcion = -1; //-1 es el valor que elegi para que finalice el bucle en main. podria cambiarse pero funciona
				break;
			default:
				System.out.println("Opcion incorrecta. Reingresar.");
		}
		return opcion;
	}

	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuentaTrader);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trader other = (Trader) obj;
		return Objects.equals(cuentaTrader, other.cuentaTrader) || Objects.equals(nombre, other.nombre);
	}
	
	
}
