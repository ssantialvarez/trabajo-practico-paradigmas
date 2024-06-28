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
		
		System.out.println("Ingresar simbolo de la criptomoneda a consultar:");
		simbolo = teclado.nextLine();
		
		regCripto.consultarCriptomoneda(simbolo);
	}
	
	public void verEstadoActualMercado(Criptomonedas regCripto) {
		System.out.println("El estado actual del mercado es muy bueno");
		//REVISAR
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
