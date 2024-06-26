package edu.unlam.paradigmas.tp;

import java.util.LinkedList;
import java.util.List;

public class Criptomonedas {
	protected List<Criptomoneda> regCriptomonedas = new LinkedList<>();
	
	public void  descargaReg(String ruta) {
		String[] regAux = Archivo.abreArchivo(ruta);
		String[] aux;
		
		for(int i = 0; i < regAux.length; i++) {
			aux = regAux[i].split(",");
			this.regCriptomonedas.add(new Criptomoneda(aux[0],aux[1],aux[2]));	
		}
		
	}
	
	
	public void muestraReg() {
		for(Criptomoneda cp : this.regCriptomonedas) {
			System.out.println(cp.toString());
		}
	}
	
	
	
	
}
