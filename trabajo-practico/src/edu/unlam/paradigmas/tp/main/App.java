package edu.unlam.paradigmas.tp.main;

import java.util.Scanner;

import edu.unlam.paradigmas.tp.entidades.FileManager;
import edu.unlam.paradigmas.tp.entidades.Criptomonedas;
import edu.unlam.paradigmas.tp.entidades.Usuario;
import edu.unlam.paradigmas.tp.entidades.Usuarios;

public class App {
	public static void main(String[] args) {
		Criptomonedas listaCripto = new Criptomonedas();
		Usuarios listaUsuarios = new Usuarios();
		Usuario usuarioActual = null;
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
			
		App.descargaArchivos(listaUsuarios, listaCripto);
		
		opcion = App.menuInicio(teclado);
		if(opcion == 1)
			usuarioActual = App.ingresaUsuario(usuarioActual, listaUsuarios, teclado);
		else
			if(opcion == 2)
				usuarioActual = App.creaUsuarioTrader(listaUsuarios, teclado);
			else
				usuarioActual = App.creaUsuarioAdministrador(listaUsuarios, teclado);
		
		while(opcion != -1) {
			usuarioActual.menu();
			opcion = teclado.nextInt();
			teclado.nextLine();
			opcion = usuarioActual.ingresaOpcion(opcion, listaCripto, teclado);
		}
		
		
		teclado.close();
		
		
		
		
		
		
		//Al finalizar el programa se deben actualizar los archivos
		//listaCripto.updateRegCripto(FileManager.rutaCriptomonedas);
		//listaCripto.updateRegMercados(FileManager.rutaMercados);
		//falta actualizar
		//listaUsuarios.updateRegUsuarios(FileManager.rutaUsuarios);
		
		//ESTO ES UNICAMENTE DE CONTROL
		//SE DEBERIA SACAR
		System.out.println("---------------------------------------------------");
		listaCripto.muestraReg();
		System.out.println("---------------------------------------------------");
		listaUsuarios.muestraReg();
		
		
	}
	
	public static void descargaArchivos(Usuarios listaUsuarios, Criptomonedas listaCripto) {
		//SE DESCARGAN LOS ARCHIVOS CSV
		listaCripto.descargaRegCripto(FileManager.rutaCriptomonedas);
		listaCripto.descargaRegMercados(FileManager.rutaMercados);
		listaUsuarios.descargaReg(FileManager.rutaUsuarios);
		
		for(Usuario user : listaUsuarios.getRegUsuarios()) {
			user.descargaHistorico(FileManager.rutaHistoricos.concat(user.getNombre().concat(".csv")));
		}
		
		
	}
	
	public static Usuario ingresaUsuario(Usuario posibleUsuario, Usuarios listaUsuarios, Scanner teclado) {
		String username;
		
		System.out.println("Ingresar nombre de usuario:");
		
		while(posibleUsuario == null) {
			username = teclado.nextLine();
			posibleUsuario = listaUsuarios.ingresaUsuario(username);
			if(posibleUsuario == null) {
				System.out.println("No se encontro el usuario. Ingrese otro usuario:");
			} else {
				System.out.println(posibleUsuario.toString());
				//Esta linea tambien es de control. se deberia sacar
			}
		}
		
		return posibleUsuario;
	}
	
	public static Usuario creaUsuarioTrader(Usuarios listaUsuarios, Scanner teclado) {
		Usuario nuevoUsuario = null;
		String nombre, nombreBanco;
		double saldo;
		int numCuenta;
		while(nuevoUsuario == null) {
			System.out.println("Ingrese nombre de usuario:");
			nombre = teclado.nextLine();
			System.out.println("Ingrese numero de cuenta bancaria:");
			numCuenta = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Ingrese nombre del Banco de su cuenta:");
			nombreBanco = teclado.nextLine();
			System.out.println("Ingrese saldo actual de su cuenta bancaria:");
			saldo = teclado.nextDouble();
			teclado.nextLine();
			
			nuevoUsuario = listaUsuarios.creaUsuarioTrader(nombre, numCuenta, nombreBanco, saldo);
			if(nuevoUsuario == null)
				System.out.println("El usuario o la cuenta Bancaria ya existen. Reingresar.");
		}
		
		
		return nuevoUsuario;
	}
	
	public static Usuario creaUsuarioAdministrador(Usuarios listaUsuarios, Scanner teclado) {
		Usuario nuevoUsuario = null;
		String nombre;

		while(nuevoUsuario == null) {
			System.out.println("Ingrese nombre de usuario:");
			nombre = teclado.nextLine();
			
			nuevoUsuario = listaUsuarios.creaUsuarioAdministrador(nombre);
			if(nuevoUsuario == null)
				System.out.println("El nombre de usuario ya existe. Reingresar.");
		}
		
		
		return nuevoUsuario;
	}
	
	public static int menuInicio(Scanner teclado) {
		int opcion;
		
		System.out.println("Menú inicio ");
		System.out.println("------------------");
		System.out.println(" 1) Iniciar sesión");
		System.out.println(" 2) Crear usuario Trader");
		System.out.println(" 3) Crear usuario Administrador");
		System.out.println("Ingrese su opción: ");
		opcion = teclado.nextInt();
		teclado.nextLine();
		
		while(opcion < 1 || opcion > 3) {
			System.out.println("Opcion incorrecta. Reingresar.");
			opcion = teclado.nextInt();
			teclado.nextLine();
		}
		
		
		
		return opcion;
	}
	
}
