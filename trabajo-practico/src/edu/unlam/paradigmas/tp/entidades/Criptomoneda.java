package edu.unlam.paradigmas.tp.entidades;

import java.util.Objects;

public class Criptomoneda {
	private String nombre;
	private String simbolo;
	private double precio;
	//DISCLAIMER
	//Dentro de esta clase irian los valores que estan en mercado.csv
	//Mi duda era si armar una clase aparte para el mercado o que los valores del mercado esten dentro de esta clase
	//Por el momento las funcionalidades relacionadas a mercado.csv y su contenido no estan hechas --> 27/06/2024
	
	public Criptomoneda(String nombre, String simbolo, double precio) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precio = precio;
	}
	
	public Criptomoneda(String nombre, String simbolo, String precio) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precio = Double.parseDouble(precio);
	}
	
	public Criptomoneda(String nombre, String simbolo) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precio = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return nombre + ", " + simbolo + ", " + precio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, simbolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criptomoneda other = (Criptomoneda) obj;
		return Objects.equals(nombre.toLowerCase(), other.nombre.toLowerCase()) 
				|| Objects.equals(simbolo.toUpperCase().strip(), other.simbolo.toUpperCase().strip());
	}

	

}
