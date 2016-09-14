package juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOpen {
	
	/**
	 * Ejemplo de como abrir y recorrer un archivo de texto. 
	 * El ejemplo recorre el archivo leyendo el contenido y accionando en consecuencia. 
	 * @param args
	 */
    public static void main(String[] args) {

        BufferedReader br = null;

        String fileName = "mapa.txt";
        
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(fileName));

            // Para cada linea del archivo
            while ((sCurrentLine = br.readLine()) != null) {
            	// Para cada letra de la linea
            	for(int i = 0; i < sCurrentLine.length(); i++){
            		char letra = sCurrentLine.charAt(i);
            		switch (letra) {
            		case 'B' : // Si aparece una a
            			System.out.print("ladrillo "); // Imprimo una d
            			break;
            		case ' ' :
            			System.out.print("espacio ");
            			break;
            		case 'c' :
            			System.out.print("f");
            			break;
            		default :
            			System.out.print("x"); // Caracter no esperado
            		}
            	}
            	System.out.println("");
            }
        } catch (IOException e) { // Esto es por si ocurre un error
            e.printStackTrace();
        } finally { // Esto es para que, haya ocurrido error o no
            try {
                if (br != null)br.close(); // Cierre el archivo
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}