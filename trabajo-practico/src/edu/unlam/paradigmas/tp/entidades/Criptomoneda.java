package edu.unlam.paradigmas.tp.entidades;

import java.util.Objects;

public class Criptomoneda {
	private String nombre;
	private String simbolo;
	private double precio = 0;
	
	
	// 27-06 15:56 ingreso los atributos del archivo mercado.csv, 
	// creo que lo correcto es que esten en la clase Criptomoneda pero se podria ver de otra forma
	
	private double capacidad = 0;
	private double volumen = 0;
	private double variacion = 0;
	
	
	//DISCLAIMER
	//Dentro de esta clase irian los valores que estan en mercado.csv
	//Mi duda era si armar una clase aparte para el mercado o que los valores del mercado esten dentro de esta clase
	//Por el momento las funcionalidades relacionadas a mercado.csv y su contenido no estan hechas --> 27/06/2024
	
	public Criptomoneda(String nombre, String simbolo, double precio, double capacidad, double volumen, double variacion) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precio = precio;
		this.capacidad = capacidad;
		this.volumen = volumen;
		this.variacion = variacion;
	}
	
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

	public double getCapacidad() {
		return capacidad;
	}

	public double getVolumen() {
		return volumen;
	}

	public double getVariacion() {
		return variacion;
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

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public void setVariacion(double variacion) {
		this.variacion = variacion;
	}
	
	public void esComprada(double totalComprado) {
		this.capacidad -= totalComprado;
		this.variacion *= 1.05;
		this.volumen *= 1.05;
		if(totalComprado > 1000)
			this.precio *= 1.1;
	}
	
	public void esVendida(double totalVendido) {
		this.capacidad += totalVendido;
		this.variacion *= 0.93;
		this.volumen *= 0.93;
		if(totalVendido > 1000)
			this.precio *= 0.9;
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
				|| Objects.equals(simbolo.toUpperCase().trim(), other.simbolo.toUpperCase().trim());
	}

	

}
