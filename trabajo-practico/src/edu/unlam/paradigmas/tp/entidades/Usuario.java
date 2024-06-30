package edu.unlam.paradigmas.tp.entidades;

import java.util.Objects;
import java.util.Scanner;

public class Usuario {
	protected String nombre;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public void menu() {
		
	}
	
	public int ingresaOpcion(int opcion, Criptomonedas regCripto, Scanner teclado) {
		return 0;
	}
	
	public void consultarCriptomoneda(Criptomonedas regCripto, Scanner teclado) {
		String simbolo;
		Criptomoneda aux;
		
		System.out.println("Ingresar simbolo de la criptomoneda a consultar:");
		simbolo = teclado.nextLine();
		
		aux = regCripto.getCriptomoneda(simbolo);
		if(aux == null)
			return ;
		
		System.out.println("Nombre: "+aux.getNombre()+"   Simbolo: "+aux.getSimbolo()+"   Precio en dolares:   "+aux.getPrecio());
		System.out.println("Datos del mercado:");
		System.out.println("Capacidad  volumen en las ultimas 24 horas  Variacion en los ultimos 7 dias");
		System.out.println("  "+aux.getCapacidad()+"                  "+aux.getVolumen()+"%                             "+aux.getVariacion()+"%");
	}
	
	public void verEstadoActualMercado(Criptomonedas regCripto) {
		String linea;
		for(Criptomoneda aux : regCripto.getRegCriptomonedas()) {
			linea = aux.getSimbolo()+", Capacidad: " + aux.getCapacidad()+", Volumen 24hrs: "+ aux.getVolumen();
			if(aux.getVariacion() > 0) {
				linea = linea.concat("%, Variacion 7 dias: +"+ aux.getVariacion()+"%");
			} else {
				linea = linea.concat("%, Variacion 7 dias: "+ aux.getVariacion()+"%");
			}
			System.out.println(linea);
		}
	}
	
	public void descargaHistorico(String ruta) {
		
	}
	
	
	public void updateHistorico(String ruta) {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		//SACO ESTO PARA QUE FUNCIONE EL METODO ingresaUsuario, DEBERIA FUNCIONAR DE OTRA MANERA PERO POR AHORA QUEDA ASI
		//if (getClass() != obj.getClass())
			//return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + "]";
	}
	
}
