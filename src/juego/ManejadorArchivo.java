package juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import TDALista.PositionList;
import grafica.Ventana;
import obstaculos.*;

public class ManejadorArchivo {
	
	public ManejadorArchivo(){}
	
	public void cargarMapa(PositionList<Obstaculo> misObstaculos,Ventana gui,int posX,int posY,int pixelesAncho,int pixelesAlto) {
		BufferedReader br = null;

		String fileName = "mapa5.txt";

		try {
			/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();
			int pixelesAncho = (int) (width / 30);
			int pixelesAlto = (int) (height / 30);*/
			int width= 64*20;
			int height= 64*11;		
			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			// Para cada linea del archivo
			while ((sCurrentLine = br.readLine()) != null) {
				// Para cada letra de la linea
				for (int i = 0; i < sCurrentLine.length(); i++) {
					char letra = sCurrentLine.charAt(i);
					switch (letra) {
					case 'L': {
						Obstaculo l = new Ladrillo(posX, posY);
						misObstaculos.addLast(l);
						gui.add(l.getLabel());
						posX = posX + pixelesAncho;
						if (posX == width) {
							posY = posY + pixelesAlto;
							posX = 0;
						}
						break;
					}
					case 'A': {
						Obstaculo a = new Acero(posX, posY);
						misObstaculos.addLast(a);
						gui.add(a.getLabel());
						posX = posX + pixelesAncho;
						if (posX == width) {
							posY = posY + pixelesAlto;
							posX = 0;
						}
						break;
					}
					case 'W': {
						Obstaculo w = new Agua(posX, posY);
						misObstaculos.addLast(w);
						gui.add(w.getLabel());
						posX = posX + pixelesAncho;
						if (posX == width) {
							posY = posY + pixelesAlto;
							posX = 0;
						}
						break;
					}
					case 'T': {
						Obstaculo t = new Arbol(posX, posY);
						misObstaculos.addLast(t);
						gui.add(t.getLabel());
						posX = posX + pixelesAncho;
						if (posX == width) {
							posY = posY + pixelesAlto;
							posX = 0;
						}
						break;
					}
					case 'B': {
						Obstaculo t = new Base(posX, posY);
						misObstaculos.addLast(t);
						gui.add(t.getLabel());
						posX = posX + pixelesAncho;
						if (posX == width) {
							posY = posY + pixelesAlto;
							posX = 0;
						}
						break;
					}
					default: {
						posX = posX + pixelesAncho;
						if (posX == width) {
							posY = posY + pixelesAlto;
							posX = 0;
						}
						break;
					}
					}
				}
			}
		} catch (IOException e) { // Esto es por si ocurre un error
			e.printStackTrace();
		} finally { // Esto es para que, haya ocurrido error o no
			try {
				if (br != null)
					br.close(); // Cierre el archivo
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
