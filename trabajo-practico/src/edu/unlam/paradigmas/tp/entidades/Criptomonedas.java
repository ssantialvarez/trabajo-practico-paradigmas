package edu.unlam.paradigmas.tp.entidades;

import java.util.LinkedList;
import java.util.List;

public class Criptomonedas {
	private List<Criptomoneda> regCriptomonedas = new LinkedList<>();
	
	public void descargaRegCripto(String ruta) {
		String[] regAux = FileManager.abreArchivo(ruta);
		String[] aux;
		
		for(int i = 0; i < regAux.length; i++) {
			aux = regAux[i].split(",");
			this.regCriptomonedas.add(new Criptomoneda(aux[0],aux[1].strip(),aux[2]));	
		}	
	}
	
	public List<Criptomoneda> getRegCriptomonedas() {
		return this.regCriptomonedas;
	}
	
	public void descargaRegMercados(String ruta) {
		String[] regAux = FileManager.abreArchivo(ruta);
		String[] aux;
		
		for(int i = 0; i < regAux.length; i++) {
			Criptomoneda crip;
			int j;
			
			aux = regAux[i].split(",");
			aux[2] = aux[2].replace("%", "\0");
			aux[3] = aux[3].replace("%", "\0");
			crip = new Criptomoneda("",aux[0]);
			
			if((j = this.regCriptomonedas.indexOf(crip)) != -1) {
				crip = this.regCriptomonedas.get(j);
				crip.setCapacidad(Double.parseDouble(aux[1]));
				crip.setVolumen(Double.parseDouble(aux[2]));
				crip.setVariacion(Double.parseDouble(aux[3]));
			}
				
		}
		
	}
	
	public void updateRegCripto(String ruta) {
		int largo = this.regCriptomonedas.size();
		String[] regAux = new String[largo];
		//FALTARIAN ALGUNAS VALIDACIONES
		
		for(int i = 0; i < largo; i++) {
			regAux[i] = this.regCriptomonedas.get(i).toString();
		}
		
		FileManager.updateArchivo(ruta, regAux);
	}
		
	public void updateRegMercados(String ruta) {
		int largo = this.regCriptomonedas.size();
		String[] regAux = new String[largo];
		
		
		for(int i = 0; i < largo; i++) {
			Criptomoneda aux = this.regCriptomonedas.get(i);
			
			regAux[i] = aux.getSimbolo()+", "+aux.getCapacidad()+", "+aux.getVolumen()+", "+aux.getVariacion();
			//System.out.println(regAux[i]);
		}
		
		FileManager.updateArchivo(ruta, regAux);
	}

	public int crearCriptomoneda(String nombre, String simbolo, double precio) {
		int i = 0;
		Criptomoneda nCripto = new Criptomoneda(nombre, simbolo.toUpperCase(), precio, 500, 1, 1); 
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
	public boolean modificarCriptomoneda(String simbolo, double precio) {
		Criptomoneda aux = new Criptomoneda("",simbolo);
		int i;
		boolean band = false;
		
		if((i = this.regCriptomonedas.indexOf(aux)) != -1) {
			aux = this.regCriptomonedas.get(i);
			aux.setPrecio(precio);
			band = true;
		}
		
		return band;
	}
	
	public boolean modificarCriptomoneda(String simbolo, String nuevoParametro, int op) {
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
			return true;
		}
		
		return false;
	}
		
	public Criptomoneda getCriptomoneda(String simbolo) {
		Criptomoneda cripto = new Criptomoneda("", simbolo);
		int i;
		
		if((i = this.regCriptomonedas.indexOf(cripto)) != -1)
			cripto = this.regCriptomonedas.get(i);
		else
			cripto = null;
		
		return cripto;
	}
	
	public Criptomoneda recomendarCriptomoneda() {
		Criptomoneda maxValor = this.criptoMayorValor(), maxPorcentaje = null;
		double porcentaje = -1;
		
		for(Criptomoneda aux : this.regCriptomonedas) {
			double auxPercent = ((maxValor.getCapacidad()/aux.getPrecio())*100);
			if(porcentaje == -1 || porcentaje < auxPercent) {
				maxPorcentaje = aux;
				porcentaje = auxPercent;
			}
		}
		
		return maxPorcentaje;
	}
	
	
	private Criptomoneda criptoMayorValor() {
		Criptomoneda max = null;
		for(Criptomoneda aux : this.regCriptomonedas) {
			if(max == null || max.getPrecio() < aux.getPrecio())
				max = aux;
			
			
			
		}
		
		return max;
	}
	
	
	public void muestraReg() {
		for(Criptomoneda cp : this.regCriptomonedas) {
			System.out.println(cp.toString());
		}
	}
	
}
