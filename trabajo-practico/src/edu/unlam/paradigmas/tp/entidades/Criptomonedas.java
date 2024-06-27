package edu.unlam.paradigmas.tp.entidades;

import java.util.LinkedList;
import java.util.List;

public class Criptomonedas {
	protected List<Criptomoneda> regCriptomonedas = new LinkedList<>();
	
	public void descargaReg(String ruta) {
		String[] regAux = Archivo.abreArchivo(ruta);
		String[] aux;
		
		for(int i = 0; i < regAux.length; i++) {
			aux = regAux[i].split(",");
			this.regCriptomonedas.add(new Criptomoneda(aux[0],aux[1],aux[2]));	
		}
		
	}
	
	public int crearCriptomoneda(String nombre, String simbolo, double precio) {
		int i = 0;
		Criptomoneda nCripto = new Criptomoneda(nombre, simbolo.toUpperCase(), precio); 
		if(!this.regCriptomonedas.contains(nCripto))
			this.regCriptomonedas.add(nCripto);
		else
			i--;
		
		return i; 
	}
	
	//Se elimina buscando el SIMBOLO, tambien podria ser buscandolo por NOMBRE, podria mejorarse
	public void eliminarCriptomoneda(String simbolo) {
		Criptomoneda nCripto = new Criptomoneda("",simbolo.toUpperCase()); 
		
		this.regCriptomonedas.remove(nCripto);
	}
	
	//tambien se modifica buscando el Simbolo
	public void modificarCriptomoneda(String simbolo, double precio) {
		Criptomoneda aux = new Criptomoneda("",simbolo);
		int i;
		
		if((i = this.regCriptomonedas.indexOf(aux)) != -1) {
			aux = this.regCriptomonedas.get(i);
			aux.setPrecio(precio);
		}
	}
	
	public void modificarCriptomoneda(String simbolo, String nuevoParametro, int op) {
		Criptomoneda aux = new Criptomoneda("",simbolo);
		int i;
		
		if((i = this.regCriptomonedas.indexOf(aux)) != -1) {
			aux = this.regCriptomonedas.get(i);
			//OP = 0 representa que se modifica el nombre y OP = 1 representa que se modifica el simbolo
			//DEBEN HABER MEJORES FORMAS DE HACER ESTO PERO SON LAS 2 y tengo sueño
			if(op == 0) 
				aux.setNombre(nuevoParametro);
			else
				aux.setSimbolo(simbolo.toUpperCase());
			
			
		}
	}
	
	public void consultarCriptomoneda(String simbolo) {
		Criptomoneda aux = new Criptomoneda("",simbolo);
		int i;
		
		if((i = this.regCriptomonedas.indexOf(aux)) != -1) {
			aux = this.regCriptomonedas.get(i);
			System.out.println("Nombre:"+aux.getNombre()+"   Simbolo:"+aux.getSimbolo()+"   Precio en dolares:"+aux.getPrecio());
			
			
		}
	}
	
	public void muestraReg() {
		for(Criptomoneda cp : this.regCriptomonedas) {
			System.out.println(cp.toString());
		}
	}
	
	
	
	
}
