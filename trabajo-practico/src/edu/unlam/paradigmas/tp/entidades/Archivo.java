package edu.unlam.paradigmas.tp.entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class Archivo {
	
	
	public static final String rutaUsuarios = "C:\\Users\\Santiago\\eclipse-workspace\\trabajo-practico\\res\\csv\\usuarios.csv";
	public static final String rutaMercados = "C:\\Users\\Santiago\\eclipse-workspace\\trabajo-practico\\res\\csv\\mercados.csv";
	public static final String rutaCriptomonedas = "C:\\Users\\Santiago\\eclipse-workspace\\trabajo-practico\\res\\csv\\criptomonedas.csv";
	
	
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
	
	public static void updateArchivo(String ruta, String[] lineas) {
		try  {  
			File file=new File(ruta);
			OutputStream os;
	        OutputStreamWriter osw;
	        BufferedWriter bw = null;
			
			
			
			file.delete();
			file.createNewFile();
			
            os = (OutputStream) new FileOutputStream(file);
            osw = new OutputStreamWriter(os, "UTF8");
            bw = new BufferedWriter(osw);
			
			
            for(int i = 0; i < lineas.length; i++) {
            	bw.write(lineas[i]);
            	bw.newLine();
            }
            
			
			bw.close();
		}  catch(IOException e)  {  
			e.printStackTrace();  
		}
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
