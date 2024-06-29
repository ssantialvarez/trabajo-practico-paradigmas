package edu.unlam.paradigmas.tp.entidades;

import java.util.LinkedList;
import java.util.List;

public class Usuarios {
	protected List<Usuario> regUsuarios = new LinkedList<>();
	
	
	public void descargaReg(String ruta) {
		String[] regAux = FileManager.abreArchivo(ruta);
		String[] aux;
		
		for(int i = 0; i < regAux.length; i++) {
			aux = regAux[i].split(",");
			aux[1] = aux[1].strip();
			//SE HACE EL STRIP PARA ELIMINAR POSIBLES ESPACIOS AL INICIO DE LA CADENA
			if(aux[1].compareTo("administrador") == 0) {
				this.regUsuarios.add(new Administrador(aux[0]));
			}else {
				this.regUsuarios.add(new Trader(aux[0],aux[1],aux[2].strip(),aux[3]));
			}
		}
		
	}
	
	public void updateRegUsuarios(String ruta) {
		
	}
	
	public Usuario ingresaUsuario(String username) {
		int i; 
		Usuario user = null;
		//DADO EL USERNAME BUSCA EL INDICE DEL OBJ QUE BUSCAMOS, SI NO EXISTE EL RESULTADO ES -1
		if((i = this.regUsuarios.indexOf(new Usuario(username))) != -1 ) {
			user = this.regUsuarios.get(i);
			//CON EL INDICE OBTENEMOS EL OBJ USUARIO QUE BUSCAMOS
		}
		
		return user;
	}
	
	public Usuario creaUsuarioTrader(String username, int numCuenta, String nombreBanco, double saldo) { 
		Trader user = new Trader(username,numCuenta,nombreBanco,saldo);
		if(!this.regUsuarios.contains(user)) {
			this.regUsuarios.add(user);
		} else {
			user = null;
		}
		return user;
	}
	
	public Usuario creaUsuarioAdministrador(String username) { 
		Usuario user = new Administrador(username);
		if(!this.regUsuarios.contains(user)) {
			this.regUsuarios.add(user);
		} else {
			user = null;
		}
		return user;
	}
	
	public List<Usuario> getRegUsuarios() {
		return this.regUsuarios;
	}
	
	public void muestraReg() {
		for(Usuario user : this.regUsuarios) {
			System.out.println(user.toString());
		}
	}
	
	
}
