package edu.unlam.paradigmas.tp.main;

import java.util.Scanner;

import edu.unlam.paradigmas.tp.entidades.Archivo;
import edu.unlam.paradigmas.tp.entidades.Criptomonedas;
import edu.unlam.paradigmas.tp.entidades.Usuario;
import edu.unlam.paradigmas.tp.entidades.Usuarios;

public class App {
	public static void main(String[] args) {
		Criptomonedas c1 = new Criptomonedas();
		Usuarios u1 = new Usuarios();
		Usuario u2 = null;
		Scanner teclado = new Scanner(System.in);
		String username;
		int opcion = 0;
			
		//SE DESCARGAN LOS ARCHIVOS CSV
		c1.descargaRegCripto(Archivo.rutaCriptomonedas);
		c1.descargaRegMercados(Archivo.rutaMercados);
		u1.descargaReg(Archivo.rutaUsuarios);
		
		System.out.println("Ingresar nombre de usuario:");
		
		while(u2 == null) {
			username = teclado.nextLine();
			u2 = u1.ingresaUsuario(username);
			if(u2 == null) {
				System.out.println("No se encontro el usuario. Ingrese otro usuario:");
			} else {
				System.out.println(u2.toString());
			}
		}
		while(opcion != -1) {
			u2.menu();
			opcion = teclado.nextInt();
			teclado.nextLine();
			opcion = u2.ingresaOpcion(opcion, c1, teclado);
		}
		
		
		teclado.close();
		
		//Al finalizar el programa se deben actualizar los archivos
		c1.updateRegCripto(Archivo.rutaCriptomonedas);
		c1.updateRegMercados(Archivo.rutaMercados);
		//u1.updateRegUsuarios(Archivo.rutaUsuarios);
		
		System.out.println("---------------------------------------------------");
		c1.muestraReg();
		System.out.println("---------------------------------------------------");
		u1.muestraReg();
		
	}
	

}
