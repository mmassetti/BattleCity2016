package juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import obstaculos.*;

public class ManejadorArchivo {
	private String fileName;

	public ManejadorArchivo() {
	}

	public void cargarMapa(Juego juego, int posX, int posY, int nroMapa) {
		BufferedReader br = null;
		fileName = "/mapa" + nroMapa + ".txt";
		

		try {
			int width = 64 * 20;
			String sCurrentLine;
			InputStream in = getClass().getResourceAsStream(fileName); 
			br = new BufferedReader(new InputStreamReader(in));

			// Para cada linea del archivo
			while ((sCurrentLine = br.readLine()) != null) {
				// Para cada letra de la linea
				for (int i = 0; i < sCurrentLine.length(); i++) {
					char letra = sCurrentLine.charAt(i);
					switch (letra) {
					case 'L': {
						Obstaculo l = new Ladrillo(posX, posY);
						juego.getMisObstaculos().addLast(l);
						juego.getGui().add(l.getLabel());
						posX = posX + juego.getAnchoPixel();
						if (posX == width) {
							posY = posY + juego.getAltoPixel();
							posX = 0;
						}
						break;
					}
					case 'A': {
						Obstaculo a = new Acero(posX, posY);
						juego.getMisObstaculos().addLast(a);
						juego.getGui().add(a.getLabel());
						posX = posX + juego.getAnchoPixel();
						if (posX == width) {
							posY = posY + juego.getAltoPixel();
							posX = 0;
						}
						break;
					}
					case 'W': {
						Obstaculo w = new Agua(posX, posY);
						juego.getMisObstaculos().addLast(w);
						juego.getGui().add(w.getLabel());
						posX = posX + juego.getAnchoPixel();
						if (posX == width) {
							posY = posY + juego.getAltoPixel();
							posX = 0;
						}
						break;
					}
					case 'T': {
						Obstaculo t = new Arbol(posX, posY);
						juego.getMisObstaculos().addLast(t);
						juego.getGui().add(t.getLabel());
						posX = posX + juego.getAnchoPixel();
						if (posX == width) {
							posY = posY + juego.getAltoPixel();
							posX = 0;
						}
						break;
					}
					case 'B': {
						Obstaculo t = new Base(posX, posY, juego.getTerminador());
						juego.setBase((Base) t);
						juego.getMisObstaculos().addLast(t);
						juego.getGui().add(t.getLabel());
						posX = posX + juego.getAnchoPixel();
						if (posX == width) {
							posY = posY + juego.getAltoPixel();
							posX = 0;
						}
						break;
					}
					default: {
						posX = posX + juego.getAnchoPixel();
						if (posX == width) {
							posY = posY + juego.getAltoPixel();
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
