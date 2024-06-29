package edu.unlam.paradigmas.tp.entidades;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Trader extends Usuario{
	protected CuentaBancaria cuentaTrader;
	protected LinkedList<RegistroHistorico> regHist = new LinkedList<>();
	
	public Trader(String nombre, int numCuenta, String nombreBanco, double saldo) {
		super(nombre);
		cuentaTrader = new CuentaBancaria(numCuenta,nombreBanco,saldo);
	}
	
	public Trader(String nombre, String numCuenta, String nombreBanco, String saldo) {
		super(nombre);
		cuentaTrader = new CuentaBancaria(Integer.parseInt(numCuenta),nombreBanco,Double.parseDouble(saldo));
	}
	
	
	@Override
	public void descargaHistorico(String ruta) {
		String [] regAux = FileManager.abreArchivo(ruta);
		String [] aux;
		
		for(int i = 0; i < regAux.length; i++) {
			aux = regAux[i].split(",");
			this.regHist.add(new RegistroHistorico(aux[0],aux[1]));
		}
		
	}
	
	public void compraCriptomoneda(Criptomonedas regCripto, Scanner teclado) {
		Criptomoneda cripto = null;
		String simbolo;
		double totalCompra;
		
		do {
			System.out.println("Ingrese simbolo de la criptomoneda a comprar:");
			simbolo = teclado.nextLine();
			
			cripto = regCripto.getCriptomoneda(simbolo);
			if(cripto == null)
				System.out.println("No se encontro la criptomoneda a comprar. Reingresar.");
		} while(cripto == null);
		
		System.out.println("Simbolo: "+cripto.getSimbolo());
		System.out.println("Valor en dólares: $"+cripto.getPrecio());
		System.out.println("Total que se puede comprar (capacidad): "+cripto.getCapacidad());
		
		do {
			System.out.println("Ingrese el total a Comprar:");
			totalCompra = teclado.nextDouble();
		}while(totalCompra > cripto.getCapacidad() || totalCompra < 0);
	
		if(!this.cuentaTrader.extraer(totalCompra*cripto.getPrecio())) {
			System.out.println("Operación rechazada. Por favor ingresar el dinero faltante.");
			System.out.println("Saldo actual: $"+this.cuentaTrader.getSaldo());
			System.out.println("Total de la compra: $"+totalCompra*cripto.getPrecio());
			return ;
		}
		
		cripto.esComprada(totalCompra);
		this.actualizaRegHistorico(simbolo, totalCompra);
	}
	
	public void ventaCriptomoneda(Criptomonedas regCripto, Scanner teclado) {
		Criptomoneda cripto = null;
		String simbolo;
		double totalVenta, maxVenta;
		
		do {
			System.out.println("Ingrese simbolo de la criptomoneda a vender:");
			simbolo = teclado.nextLine();
			
			cripto = regCripto.getCriptomoneda(simbolo);
			if(cripto == null)
				System.out.println("No se encontro la criptomoneda a comprar. Reingresar.");
		} while(cripto == null);
		
		maxVenta = this.consultaRegHistorico(simbolo);
		if(maxVenta > 0) {
			System.out.println("Cantidad máxima que puede vender:"+maxVenta);
			System.out.println("Ingrese el total a vender:");
			totalVenta = teclado.nextDouble();
			if(totalVenta > maxVenta || totalVenta <= 0) {
				System.out.println("Operacion rechazada. El total a vender es invalido.");
				return ;
			}
			
			this.cuentaTrader.depositar(totalVenta*cripto.getPrecio());
			cripto.esVendida(totalVenta);
			this.actualizaRegHistorico(simbolo, totalVenta*-1);
		}
	}
	
	public void actualizaRegHistorico(String simbolo, double totalComprado) {
		RegistroHistorico aux = new RegistroHistorico(simbolo, 0);
		int i;
		if((i = this.regHist.indexOf(aux)) != -1) {
			aux = this.regHist.get(i);
			aux.setCantidad(aux.getCantidad() + totalComprado);
		} else {
			aux.setCantidad(totalComprado);
			this.regHist.add(aux);
		}
	}
	
	public double consultaRegHistorico(String simbolo) {
		RegistroHistorico aux = new RegistroHistorico(simbolo, 0);
		double i;
		if((i = this.regHist.indexOf(aux)) != -1) {
			aux = this.regHist.get((int)i);
			i = aux.getCantidad();
		}
		
		return i;
	}

	public void recomendarCriptomoneda(Criptomonedas regCripto) {
		Criptomoneda recomendada = regCripto.recomendarCriptomoneda();
		
		System.out.println("El sistema recomienda comprar la siguiente criptodivisa:");
		System.out.println(recomendada.toString());
		
	}
	
	public void visualizarHistorico() {
		
		System.out.println("---------");
		Collections.sort(this.regHist);
		for(RegistroHistorico aux: this.regHist) {
			System.out.println(aux.toString());
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
		System.out.println("Ingrese su opción (1 - 7): _ ");
	}
	
	@Override
	public int ingresaOpcion(int opcion, Criptomonedas regCripto, Scanner teclado) {
		switch(opcion) {
			case 1:
				System.out.println("Eligio comprar una criptomoneda.");
				this.compraCriptomoneda(regCripto, teclado);
				break;
			case 2:
				System.out.println("Eligio vender una criptomoneda.");
				this.ventaCriptomoneda(regCripto, teclado);
				break;
			case 3:
				System.out.println("Eligio consultar una criptomoneda.");
				this.consultarCriptomoneda(regCripto, teclado);
				break;
			case 4:
				System.out.println("Eligio recomendar una criptomoneda.");
				this.recomendarCriptomoneda(regCripto);
				break;
			case 5:
				System.out.println("Eligio consultar estado actual del mercado.");
				this.verEstadoActualMercado(regCripto);
				break;
			case 6:
				System.out.println("Eligio visualizar archivo de transacciones (histórico).");
				this.visualizarHistorico();
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
	public String toString() {
		return "Trader [nombre=" + nombre + ", numCuenta="+this.cuentaTrader.getNumCuenta()+", nombreBanco="+ this.cuentaTrader.getNombreBanco()+"]";
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
		if (super.equals(obj))
			return true;
		if (getClass() != obj.getClass())
			return false;
		Trader other = (Trader) obj;
		return Objects.equals(cuentaTrader, other.cuentaTrader);
	}
	
	
}
