package edu.unlam.paradigmas.tp.entidades;

import java.util.Scanner;

public class Administrador extends Usuario{

	public Administrador(String nombre) {
		super(nombre);
	}
	
	
	public void crearCriptomoneda(Criptomonedas regCripto, Scanner teclado) {
		String nombre, simbolo, opcion;
		double precio;
		int band = -1;

		while(band != 0) {
			System.out.println("Ingrese nombre de la criptomoneda:");
			nombre = teclado.nextLine();
			
			System.out.println("Ingrese simbolo de la criptomoneda:");
			simbolo = teclado.nextLine();

			System.out.println("Ingrese precio de la criptomoneda:");
			precio = teclado.nextDouble();
			teclado.nextLine();
			
			band = regCripto.crearCriptomoneda(nombre, simbolo, precio);
			
			if(band == -1) {
				System.out.println("El nombre y/o el simbolo ya existen, por lo que no se pudo agregar la criptomoneda.");
				System.out.println("¿Desea volver a crear una Criptomoneda?Y/N");
				opcion = teclado.nextLine();
				band = (opcion.toUpperCase().compareTo("Y") == 0) ? -1 : 0;
				// Aca basicamente pense en que si el usuario quiere volver a crear la moneda, que ponga Y de yes para que el valor de band(la bandera)
				// se mantenga en -1 y se quedase dentro del bucle. Caso contrario toma el 0 y sale del while.
			}
		}	
		//Si la criptomoneda que se desea dar de alta existe en el archivo criptomonedas.csv, 
		//se debe emitir un mensaje aclaratorio indicando que no se puede agregar y se debe consultar al usuario 
		//si desea modificar algún parámetro de esta, en caso afirmativo el sistema lo redireccionará a dicha funcionalidad.
	}
	
	public void modificarCriptomoneda(Criptomonedas regCripto, Scanner teclado) {
		String simbolo, opcion;
		int band = 0;
		
		System.out.println("Ingresar simbolo de la criptomoneda a modificar:");
		simbolo = teclado.nextLine();
		
		//ESTO NO ME GUSTA 
		System.out.println("Parametro a modificar. Ingrese N para nombre, S para simbolo o P para el precio");
		opcion = teclado.nextLine();
		if(opcion.toUpperCase().compareTo("P") == 0) {
			double nuevoPrecio;
			
			System.out.println("Ingresar el nuevo precio dólar base:");
			nuevoPrecio = teclado.nextDouble();
			teclado.nextLine();//esto al parecer limpia el buffer
			
			band++;
			regCripto.modificarCriptomoneda(simbolo,nuevoPrecio);
		}
		if(band != 1 && opcion.toUpperCase().compareTo("N") == 0) {
			String nuevoNombre;
			
			System.out.println("Ingresar el nuevo nombre de la criptomoneda:");
			nuevoNombre = teclado.nextLine();
			
			band++;
			regCripto.modificarCriptomoneda(simbolo, nuevoNombre, 0);//OP = 0 representa que se modifica el nombre
		}
		if(band != 1 && opcion.toUpperCase().compareTo("S") == 0) {
			String nuevoSimbolo;
			
			System.out.println("Ingresar el nuevo simbolo de la criptomoneda:");
			nuevoSimbolo = teclado.nextLine();
			
			band++;
			regCripto.modificarCriptomoneda(simbolo, nuevoSimbolo, 1);//OP = 1 representa que se modifica el simbolo
		}
		
		//nota: por ahora la logica es que si el simbolo NO se encuentra no se modifica NADA y no se le avisa al usuario.
		//no me parece mal simplemente porque no quiero pensar en mas logica para pedir que se reingrese el simbolo
		//si quieren agreganlo
			
	}
	
	public void eliminarCriptomoneda(Criptomonedas regCripto, Scanner teclado) {
		String simbolo;
		
		System.out.println("Ingresar simbolo de la criptomoneda a eliminar:");
		simbolo = teclado.nextLine();
		
		regCripto.eliminarCriptomoneda(simbolo);	
	}
	
	
	@Override
	public void menu() {
		System.out.println("Menú de opciones ");
		System.out.println("------------------");
		System.out.println();
		System.out.println(" 1) Crear Criptomoneda");
		System.out.println(" 2) Modificar Criptomoneda");
		System.out.println(" 3) Eliminar Criptomoneda");
		System.out.println(" 4) Consultar Criptomoneda");
		System.out.println(" 5) Consultar estado actual del mercado");
		System.out.println(" 6) Salir");
		System.out.println();
		System.out.println("Ingrese su opción (1 - 6): _ ");
	}
	
	@Override
	public int ingresaOpcion(int opcion, Criptomonedas regCripto, Scanner teclado) {
		switch(opcion) {
			case 1:
				System.out.println("Eligio crear una criptomoneda.");
				this.crearCriptomoneda(regCripto, teclado);
				break;
			case 2:
				System.out.println("Eligio modificar una criptomoneda.");
				this.modificarCriptomoneda(regCripto, teclado);
				break;
			case 3:
				System.out.println("Eligio eliminar una criptomoneda.");
				this.eliminarCriptomoneda(regCripto, teclado);
				break;
			case 4:
				System.out.println("Eligio consultar una criptomoneda.");
				this.consultarCriptomoneda(regCripto, teclado);
				break;
			case 5:
				System.out.println("Eligio consultar estado actual del mercado.");
				this.verEstadoActualMercado(regCripto);
				break;
			case 6:
				System.out.println("Eligio salir.");
				opcion = -1; //-1 es el valor que elegi para que finalice el bucle en main. podria cambiarse pero funciona
				break;
			default:
				System.out.println("Opcion incorrecta. Reingresar.");
		}
		return opcion;
	}
	
}
