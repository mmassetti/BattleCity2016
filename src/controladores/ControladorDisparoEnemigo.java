package controladores;

import java.util.Iterator;
import javax.swing.JPanel;
import TDALista.*;
import grafica.PanelJuego;
import juego.Disparo;
import juego.Jugador;
import obstaculos.Obstaculo;

public class ControladorDisparoEnemigo extends Controlador {
	private PanelJuego gui;
	private Disparo disparo;
	private PositionList<Disparo> listaDisparosActuales;
	private PositionList<Obstaculo> listaObstaculos;
	private PositionList<Controlador> listaControladores;
	private Jugador miJugador;
	Thread hilo;

	public ControladorDisparoEnemigo(Disparo disparo, PositionList<Obstaculo> obstaculos, Jugador jugador,
			PositionList<Controlador> controladores, PositionList<Disparo> disparosActuales, JPanel v) {
		gui = (PanelJuego) v;
		this.disparo = disparo;
		miJugador = jugador;
		listaDisparosActuales = disparosActuales;
		listaObstaculos = obstaculos;
		listaControladores = controladores;
		hilo = new Thread(this);
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		try {
			while (disparo.getExiste() && hayJuego) {
				if (!juegoEnPausa) {
					disparo.mover();
					controlarObstaculos();
					controlarJugador();
					controlarRango();
					Thread.sleep(50);
				}
			}
		} catch (InterruptedException e) {
		}
	}

	private void controlarObstaculos() {
		Iterator<Obstaculo> it = listaObstaculos.iterator();
		boolean encontre = false;
		Obstaculo obs = null;
		while (it.hasNext() && !encontre) {
			obs = it.next();
			encontre = obs.accept(disparo.getVisitor());
		}
		if (encontre) {
			if (obs.recibirDisparo() == 0) {
				gui.remove(obs.getLabel());
				listaObstaculos.removeElement(obs);
			}
			destruirDisparo();
		}
	}

	private void controlarJugador() {
		boolean encontre = miJugador.accept(disparo.getVisitor());
		if (encontre)
			destruirDisparo();
	}

	private void controlarRango() {
		if (!rectanguloPanel.contains(disparo.crearRectangulo()))
			destruirDisparo();
	}

	private void destruirDisparo() {
		gui.remove(disparo.getLabel());
		listaDisparosActuales.removeElement(disparo);
		disparo.destruir();
		listaControladores.removeElement(this);
	}
}
