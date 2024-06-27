package edu.unlam.paradigmas.tp.entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Archivo {
	public static String[] abreArchivo(String ruta) {
		String[] lineas = new String[contarLineas(ruta)];
		try  {  
			File file=new File(ruta);   
			BufferedReader br=new BufferedReader(new FileReader(file));
			
			String linea;
			int i = 0;
			
			while((linea = br.readLine()) != null)  {  
				lineas[i++] = linea;
			}
			
			br.close();
		}  catch(Exception e)  {  
			e.printStackTrace();  
		}
		
		return lineas;
	}
	
	public static int contarLineas(String ruta) {
		int i = 0;
		try  {  
			File file=new File(ruta);   
			BufferedReader br=new BufferedReader(new FileReader(file));
			
			
			while(br.readLine() != null)  {  
				i++;
			}
			
			br.close();
			
		}  catch(Exception e)  {  
			e.printStackTrace();  
		}
		
		return i;
	}
	
	
	
}
