package edu.unlam.paradigmas.tp;

public class Criptomoneda {
	protected String nombre;
	protected String simbolo;
	protected double precio;
	
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
	
	public String getNombre() {
		return nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Criptomoneda [nombre=" + nombre + ", simbolo=" + simbolo + ", precio=" + precio + "]";
	}

}
