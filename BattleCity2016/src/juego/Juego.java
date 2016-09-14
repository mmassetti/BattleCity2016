package juego;

import TDALista.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import grafica.*;

public class Juego {
	// Atributos
	protected Enemigo[] miEnemigo;
	protected PositionList<ObjetoJuego> misObstaculo;
	protected PowerUp[] miPoder;
	protected Jugador miJugador;
	protected int cantEnemigos;
	protected Disparo[] miDisparo;
	protected int posX, posY;

	// Constructor
	public Juego(Ventana gui) {
		miJugador = new Jugador(200, 700, 10, 15, 10, 10,new Nivel1());
		gui.add(miJugador.getLabel());
		misObstaculo = new ListaDoblementeEnlazada<ObjetoJuego>();
		posX = 0;
		posY = 0;
		cargarMapa(gui);
	}

	// Metodos
	public Jugador getMiJugador() {
		return miJugador;
	}

	public void setMiJugador(Jugador miJugador) {
		this.miJugador = miJugador;
	}

	public void mover(int dir) {
		int direccion = 0;

		switch (dir) {
		case KeyEvent.VK_UP: // Arriba
			direccion = 0;
			break;
		case KeyEvent.VK_DOWN: // Abajo
			direccion = 1;
			break;
		case KeyEvent.VK_LEFT: // Izquierda
			direccion = 2;
			break;
		case KeyEvent.VK_RIGHT: // Derecha
			direccion = 3;
			break;
		}

		miJugador.mover(direccion);
	}

	private void cargarMapa(Ventana gui) {
		BufferedReader br = null;

		String fileName = "mapa.txt";

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			// Para cada linea del archivo
			while ((sCurrentLine = br.readLine()) != null) {
				// Para cada letra de la linea
				for (int i = 0; i < sCurrentLine.length(); i++) {
					char letra = sCurrentLine.charAt(i);
					switch (letra) {
					case 'L': {
						if(posX != 960){
							ObjetoJuego l = new Ladrillo(posX, posY);
							misObstaculo.addLast(l); // Creo un ladrillo y lo
													// agrego a la lista
							gui.add(l.getLabel());
							posX = posX + 32;
						}
						else {
							posY = posY + 32;
							posX = 0;
						}

						break;
					}
					case 'A': {
						if(posX != 960){
							ObjetoJuego a = new Acero(posX, posY);
							gui.add(a.getLabel());
							posX = posX + 32;
						}
						else{
							posY = posY + 32;
							posX = 0;
						}
						break;
					}
					case 'W':
						if(posX != 960){
							ObjetoJuego w = new Agua(posX, posY);
							gui.add(w.getLabel());
							posX = posX + 32;
						}
						else{
							posY = posY + 32;
							posX = 0;
						}
						break;
					case 'T':
						if(posX != 960){
							ObjetoJuego t = new Arbol(posX, posY);
							gui.add(t.getLabel());
							posX = posX + 32;
						}
						else{
							posY = posY + 32;
							posX = 0;
						}
					default:
						if(posX != 960)
							posX = posX + 32;
						else{
							posY = posY + 32;
							posX = 0;
						}
					}
				}
				System.out.println("");
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

	public void finJuego() {

	}
}